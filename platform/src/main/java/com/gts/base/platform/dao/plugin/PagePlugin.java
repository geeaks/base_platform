package com.gts.base.platform.dao.plugin;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.xml.bind.PropertyException;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gts.base.platform.dao.plugin.util.Dialect;
import com.gts.base.platform.dao.plugin.util.MySql5Dialect;
import com.gts.base.platform.dao.plugin.util.MySql5PageHepler;
import com.gts.base.platform.dao.plugin.util.OracleDialect;


@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PagePlugin implements Interceptor {
	
	private static final Logger logger=LoggerFactory.getLogger(PagePlugin.class);
	//数据库方言
	private static String dialect = "";
	//mapper.xml中需要拦截的ID(正则匹配)
	private static String pageSqlId = "";
	
	public Object intercept(Invocation invocation) throws Throwable {
		if(invocation.getTarget() instanceof RoutingStatementHandler){
			RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
			//拦截需要分页的SQL
			if(mappedStatement.getId().matches(pageSqlId)){ 
				BoundSql boundSql = delegate.getBoundSql();
				//分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
				Object parameterObject = boundSql.getParameterObject();
				if(parameterObject==null){
					logger.warn("parameterObject未实例化，不会进行分页查询");
				}else{
					Dialect.Type databaseType = Dialect.Type.valueOf(dialect.toUpperCase());
					if(databaseType == null) throw new RuntimeException("the value of the dialect property in configuration is not defined : " + dialect);
					Dialect dialect = null;
					//不同的数据库的方言处理类
					switch(databaseType){
						case ORACLE: 
							dialect = new OracleDialect();
							break;
						case MYSQL: 
							dialect = new MySql5Dialect();
							break;
					}
					Connection connection = (Connection) invocation.getArgs()[0];
					String sql = boundSql.getSql();
					String countSql=MySql5PageHepler.getCountString(sql);//记录统计
					PreparedStatement countStmt = connection.prepareStatement(countSql);
					BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),countSql,boundSql.getParameterMappings(),parameterObject);
					setParameters(countStmt,mappedStatement,countBS,parameterObject);
					ResultSet rs = countStmt.executeQuery();
					int count = 0;
					if (rs.next()) count = rs.getInt(1);
					rs.close();
					countStmt.close();
					Page page = null;
					//参数为某个实体，该实体拥有Page属性
					Field pageField = ReflectHelper.getFieldByFieldName(parameterObject,"page");
					if(pageField!=null){
						page = (Page) ReflectHelper.getValueByFieldName(parameterObject,"page");
						if(page==null){
							page = new Page();
						}
						page.setEntityOrField(false); 
						//通过反射，对实体对象设置分页对象
						ReflectHelper.setValueByFieldName(parameterObject,"page", page); 
					}else{
						throw new NoSuchFieldException(parameterObject.getClass().getName()+"不存在 page属性！");
					}
					page.setTotalResult(count);
					String pageSql=dialect.getLimitString(sql, page.getBeginIndex()-1, page.getShowCount());
					//将分页sql语句反射回BoundSql.
					ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); 
				}
			}
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		dialect = properties.getProperty("dialect");
		if (StringUtils.isEmpty(dialect)) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
				logger.error(e.getMessage(),e);
			}
		}
		pageSqlId = properties.getProperty("pageSqlId");
		if (StringUtils.isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				logger.error(e.getMessage(),e);
			}
		}
	}
	
	/**
	 * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName.startsWith("__frch_")&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+ mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
				}
			}
		}
	}
	
}
