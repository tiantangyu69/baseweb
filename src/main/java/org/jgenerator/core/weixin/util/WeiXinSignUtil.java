/**
 * 
 */
package org.jgenerator.core.weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author LIZHITAO 微信开发者验证工具类
 */
public class WeiXinSignUtil {

	/**
	 * Function:微信验证方法
	 * 
	 * @author LIZHITAO
	 * @param signature
	 *            微信加密签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param echostr
	 *            随机字符串
	 * @param token
	 *            用户自定义标示
	 * @return
	 */
	public static String checkAuthentication(String signature,
			String timestamp, String nonce, String echostr, String token) {
		String result = "";
		// 将获取到的参数放入数组
		String[] ArrTmp = { token, timestamp, nonce };
		// 按微信提供的方法，对数据内容进行排序
		Arrays.sort(ArrTmp);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
		// 对排序后的字符串进行SHA-1加密
		String pwd = Encrypt(sb.toString());
		if (pwd.equals(signature)) {
			try {
				System.out.println("微信平台签名消息验证成功！");
				result = echostr;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("微信平台签名消息验证失败！");
		}
		return result;
	}

	/**
	 * 用SHA-1算法加密字符串并返回16进制串
	 * 
	 * @param strSrc
	 * @return
	 */
	private static String Encrypt(String strSrc) {
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("错误");
			return null;
		}
		return strDes;
	}

	/**
	 * 将字节数组转换为16进制字符串
	 * 
	 * @param bts
	 * @return
	 */
	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
}
