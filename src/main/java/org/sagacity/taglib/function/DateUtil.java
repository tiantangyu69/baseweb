/**
 * 
 */
package org.sagacity.taglib.function;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LIZHITAO
 * 
 */
public class DateUtil {
	public static String formatDateTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
