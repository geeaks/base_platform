package com.gts.framework.web.util;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import com.gts.framework.core.constants.CodeType;
import com.gts.framework.core.util.AESCoder;
import com.gts.framework.core.util.GtsDigestUtils;

/**
 * @Description: sign验证工具类
 * @ClassName: SignUtils
 * @author gaoxiang
 * @date 2015年11月24日 下午10:49:03
 */ 
public class SignUtils {
	
	/**
	 * 获取签名数据串
	 * 
	 * @param signName
	 * @param params
	 * @return
	 */
	public static String getSignData(String signName, Map<String, String[]> params) {
		StringBuffer content = new StringBuffer();
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			if (signName.equals(key)) {
				continue;
			}
			String[] values = params.get(key);
			String value = StringUtils.isBlank(values[0]) ? "" : values[0];
			content.append("&" + key + "=" + value);
		}
		return StringUtils.removeStart(content.toString(), "&");
	}
	
	/**
	 * 获取签名数据串
	 * 
	 * @param signName
	 * @param params
	 * @return
	 */
	public static String getSignData2(String signName, Map<String, String> params) {
		StringBuffer content = new StringBuffer();
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			if (signName.equals(key)) {
				continue;
			}
			String value = params.get(key);
			value = StringUtils.isBlank(value) ? "" : value;
			
			content.append("&" + key + "=" + value);
		}
		return StringUtils.removeStart(content.toString(), "&");
	}
	
	/**
	 * 获取签名值
	 * 
	 * @param key
	 * @param signName
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String createSign(String key, String signName, Map<String, String> params, CodeType type)
	        throws Exception {
		return SignUtils.encode(key, SignUtils.getSignData2(signName, params), type);
	}
	
	/**
	 * 获取签名值
	 * 
	 * @param key
	 * @param signName
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String createSign2(String key, String signName, Map<String, String[]> params, CodeType type)
	        throws Exception {
		return SignUtils.encode(key, SignUtils.getSignData(signName, params), type);
	}
	
	/**
	 * 加密
	 * 
	 * @param key
	 * @param data
	 * @return
	 * @throws DecoderException
	 * @throws Exception
	 */
	public static String encode(String key, String data, CodeType type)
	        throws GeneralSecurityException, DecoderException {
		if (CodeType.AES.equals(type)) {
			byte[] keyByte = Hex.decodeHex(new String(key).toCharArray());
			Key k = AESCoder.toKey(keyByte);
			byte[] encryptData = AESCoder.encrypt(data.getBytes(), k);
			return Base64.encodeBase64String(encryptData);
		} else if (CodeType.MD5.equals(type)) {
			return GtsDigestUtils.digest(data + key).toLowerCase();
		}
		return "";
	}
	
	/**
	 * 解密
	 * 
	 * @param key
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decodeByAes(String key, String data) throws Exception {
		byte[] keyByte = Hex.decodeHex(key.toCharArray());
		Key k = AESCoder.toKey(keyByte);
		byte[] decryptData = AESCoder.decrypt(Base64.decodeBase64(data), k);
		return new String(decryptData);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// String key = "6b880312f5f90eb2272369eccbec4e97";
		// Map<String, String> m = new HashMap();
		// try {
		//
		// m.put("t", "");
		// System.out.println("key : [" + key + "],sign :["
		// + SignUtils.createSign(key, "sign", m, CodeType.AES) + "]");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// // 测试String 逻辑
		// String sKey = AESCoder.createKey();
		// String sData = "加密我---------------------------------";
		// System.out.println("Key:" + sKey);
		// System.out.println("加密前数据: string:" + sData);
		// String eData = SignUtils.encode(sKey, sData, CodeType.AES);
		// System.out.println("加密后数据: String:" + eData);
		// System.out.println("解密后数据: string:" + SignUtils.decodeByAes(sKey, eData));
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		
		// try {
		// System.out.println(HttpUtils.doGetBySign("https://github.com/","12345678","sign",
		// "UTF-8",CodeType.MD5,false));
		// System.out.println(HttpUtils.doPost("http://www.baidu.com", "", "UTF-8"));
		// } catch (Exception e) {
		// System.out.print(e.getMessage());
		// }
		
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(AESCoder.createKey());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
