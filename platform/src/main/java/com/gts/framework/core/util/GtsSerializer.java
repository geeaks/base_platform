package com.gts.framework.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.GtsLogUtil;
import com.gts.framework.log.util.GtsLoggerFactory;

/**
 * @Description: 序列化工具类
 * @ClassName: UcfSerializer
 * @author gaoxiang
 * @date 2015年11月17日 下午10:54:12
 */ 
public class GtsSerializer {
	
	private final static GtsLogger serializerLogger = GtsLoggerFactory.getLogger(GtsSerializer.class);
	
	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream bis = null;
		ObjectOutputStream os = null;
		byte[] byteArray = (byte[]) null;
		try {
			bis = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bis);
			os.writeObject(obj);
			os.flush();
			byteArray = bis.toByteArray();
		} catch (IOException e) {
			GtsLogUtil.error(e, serializerLogger, "Object convert to bytes array fail:object={0}", obj);
			throw e;
		} finally {
			closeOutputStream(os, bis);
		}
		return byteArray;
	}
	
	public static Object deSerialize(byte[] byteArray) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bos = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			bos = new ByteArrayInputStream(byteArray);
			ois = new ObjectInputStream(bos);
			obj = ois.readObject();
		} catch (IOException e) {
			GtsLogUtil.error(e, serializerLogger, "bytes array convert to object fail:byteArray={0}", byteArray);
			throw e;
		} catch (ClassNotFoundException e) {
			GtsLogUtil.error(e, serializerLogger, "bytes array convert to object fail:byteArray={0}", byteArray);
			throw e;
		} finally {
			closeInputStream(bos, ois);
		}
		return obj;
	}
	
	private static void closeOutputStream(ObjectOutputStream os, ByteArrayOutputStream bis) throws IOException {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				GtsLogUtil.error(e, serializerLogger, "close objectOutputStream fail:object={0}", os);
				throw e;
			}
		}
		if (bis != null) {
			try {
				bis.close();
			} catch (IOException e) {
				GtsLogUtil.error(e, serializerLogger, "close byteArrayOutputStream fail:object={0}", os);
				throw e;
			}
		}
	}
	
	private static void closeInputStream(ByteArrayInputStream bos, ObjectInputStream ois) throws IOException {
		if (bos != null) {
			try {
				bos.close();
			} catch (IOException e) {
				GtsLogUtil.error(e, serializerLogger, "close objectInputStream fail:object={0}", bos);
				throw e;
			}
		}
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				GtsLogUtil.error(e, serializerLogger, "close byteArrayInputStream fail:object={0}", ois);
				throw e;
			}
		}
	}
	
}
