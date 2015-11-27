package com.gts.base.platform.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.gts.framework.core.util.FtpHelper;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.GtsLoggerFactory;

@Component
public class BaseController {
	
	private final GtsLogger LOGGER = GtsLoggerFactory.getLogger(getClass());
	
	@Value("#{settings['devmode']}")
	private String devmode;
	
	@Resource(name = "sharedTransactionTemplate")
	public TransactionTemplate transactionTemplate;
	
	@Autowired
	public FtpHelper ftpHelper;
	
	/**
	 * @Description: 正则匹配
	 * @param regex
	 * @param str
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月12日 下午3:28:32
	 */
	public boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * @Description: 获取session中T类型的对象
	 * @param session
	 * @param key
	 * @return T 返回类型
	 * @author gaoxiang
	 * @date 2015年11月13日 下午6:22:12
	 */
	@SuppressWarnings("unchecked")
	public <T> T getSessionObject(HttpSession session,String key){
		T t = null;
		try {
			t = (T) session.getAttribute(key);
		} catch (Exception e) {
			LOGGER.error("类型转换异常",e);
		}
		return t;
	}
	
	/**
	 * @Description: 获取map里的某个对象
	 * @param map 
	 * @param key
	 * @return T 返回类型
	 * @author gaoxiang
	 * @date 2015年11月13日 下午6:21:53
	 */
	@SuppressWarnings("unchecked")
	public <T> T getMapObject(Map<String,Object> map,String key){
		T t = null;
		try {
			t = (T) map.get(key);
		} catch (Exception e) {
			LOGGER.error("类型转换异常",e);
		}
		return t;
	}
	
	/**
	 * @Description: 下载FTP服务器上的文件
	 * @param remoteFilePath
	 * @param response
	 * @throws Exception
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 上午10:35:35
	 */
	public void downloadFtpFile(String remoteFilePath, HttpServletResponse response) throws Exception{
		try {
			response.setContentType("application/x-msdownload");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + remoteFilePath);
			//连接FTP服务器
			ftpHelper.connectFTPServer();
			InputStream inputStream = ftpHelper.downloadFile(remoteFilePath);
			LOGGER.info("开始下载文件:"+remoteFilePath);
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[4096];
			int bytesRead;
			while (-1 != (bytesRead = (bis.read(buff, 0, buff.length)))) {
				bos.write(buff, 0, bytesRead);
			}
			//completePendingCommand()会一直在等FTP Server返回226 Transfer complete，
			//但是FTP Server只有在接受到InputStream执行close方法时，才会返回。所以先要执行close方法
			inputStream.close();
			ftpHelper.getFtp().completePendingCommand();
			ftpHelper.closeFTPClient();
			bos.flush();
			bis.close();
			bos.close();
		} catch (Exception e) {
			ftpHelper.closeFTPClient();
			LOGGER.error("从FTP下载文件异常：", e);
		}
	}
}
