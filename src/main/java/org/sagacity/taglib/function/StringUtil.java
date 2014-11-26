/**
 * 
 */
package org.sagacity.taglib.function;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO
 * 
 */
public class StringUtil {
	public static Integer containNumber(String str, String containStr) {
		if (str == null || containStr == null) {
			return 0;
		}
		int count = 0;
		// 如果字符串中有字符串
		while (str.indexOf(containStr) != -1) {
			count++;
			str = str.substring(str.indexOf(containStr) + containStr.length());// 将字符串出现containStr的位置之前的全部截取掉
		}
		return count;
	}
	
	public static String decodeISO(String str){
		if(null != str && str.length() > 0){
			try {
				str = new String(str.getBytes("ISO8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	/**
	 * 截取字符串长度
	 * @param 
	 * @name limitSize
	 * @active
	 * @state
	 * @type String
	 * @time 下午04:35:58
	 * @exception/throws
	 * @see
	 * @since
	 * @param str
	 * @param size
	 * @return
	 */
	public static String limitSize(String str, Integer size){
		if(null != str && str.length() > size){
			if(null == size){
				size = 20;
			}
			return str.substring(0, size -1) + "...";
		}
		return str;
	}
	
	/**
	 * 产生UUID
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 检查是否为图片
	 * @param fileName
	 * @return
	 */
	public static boolean isImage(String fileName){
		if(StringUtils.isNotBlank(fileName)){
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			if(StringUtils.isNotBlank(suffix)){
				if(suffix.equalsIgnoreCase("bmp")){
					return true;
				}
				if(suffix.equalsIgnoreCase("gif")){
					return true;
				}
				if(suffix.equalsIgnoreCase("jpg")){
					return true;
				}
				if(suffix.equalsIgnoreCase("jpeg")){
					return true;
				}
				if(suffix.equalsIgnoreCase("png")){
					return true;
				}
			}
		}
		return false;
	} 
}
