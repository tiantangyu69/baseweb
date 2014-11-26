/*******************************************************
 * @author LIZHITAO
 * @date 2013-11-26 下午01:24:49
 * @name EncryptUtil.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.taglib.function;

import org.sagacity.util.security.EncrypBase64;

/**
 * @author LIZHITAO
 *
 */
public class EncryptUtil {
	/**
	 * base64加密
	 * @param 
	 * @name encode
	 * @active
	 * @state
	 * @type String
	 * @time 下午01:28:48
	 * @exception/throws
	 * @see
	 * @since
	 * @param str
	 * @return
	 */
	public static String encode(String str){
		return EncrypBase64.encode(str);
	}
	
	/**
	 * base64解密
	 * @param 
	 * @name decode
	 * @active
	 * @state
	 * @type String
	 * @time 下午01:29:34
	 * @exception/throws
	 * @see
	 * @since
	 * @param str
	 * @return
	 */
	public static String decode(String str){
		return EncrypBase64.decode(str);
	}
}
