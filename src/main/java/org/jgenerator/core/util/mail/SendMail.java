/*******************************************************
 * @author 李智涛
 * @date 2013-7-1 下午01:35:02
 * @name SendTextMail.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.jgenerator.core.util.mail;

import java.io.File;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author 李智涛 发送邮件的辅助类
 * 
 */
@Component
public class SendMail {
	@Resource
	private JavaMailSenderImpl javaMailSender;
	
	/**
	 * @name sendTextMail
	 * @active 发送普通文本邮件
	 * @state
	 * @type void
	 * @time 下午02:54:49
	 * @exception/throws
	 * @see
	 * @since
	 * @param to 收件人的邮箱地址
	 * @param subject 邮件主题
	 * @param text 邮件文本内容
	 */
	public void sendTextMail(String to, String subject, String text){
		// 获取JavaMailSender bean
		SimpleMailMessage mail = new SimpleMailMessage(); // <span style="color: #ff0000;">注意SimpleMailMessage只能用来发送text格式的邮件</span>
		try {
			mail.setTo(to);// 接受者
			mail.setFrom(javaMailSender.getUsername());// 发送者,这里还可以另起Email别名，不用和xml里的username一致
			mail.setSubject(subject);// 主题
			mail.setText(text);// 邮件内容
			javaMailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	/**
	 * @name sendHtmlTextMail
	 * @active 发送html格式的邮件
	 * @state
	 * @type void
	 * @time 下午02:55:20
	 * @exception/throws
	 * @see
	 * @since
	 * @param to 收件人的邮箱地址
	 * @param subject 邮件主题
	 * @param htmlText 邮件内容
	 */
	public void sendHtmlTextMail(String to, String subject, String htmlText) {
		// 获取JavaMailSender bean
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		try {
			// 设置utf-8或GBK编码，否则邮件会有乱码
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			messageHelper.setTo(to);// 接受者
			messageHelper.setFrom(javaMailSender.getUsername());// 发送者
			messageHelper.setSubject(subject);// 主题
			// 邮件内容，注意加参数true，表示启用html格式
			messageHelper.setText(htmlText, true);
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @name sendAttachmentMail
	 * @active 发送带附件的email
	 * @state
	 * @type void
	 * @time 下午02:58:31
	 * @exception/throws
	 * @see
	 * @since
	 * @param to 收件人的邮箱地址
	 * @param subject 邮件主题
	 * @param files 附件
	 */
	public void sendAttachmentMail(String to, String subject, String htmlText,
			File[] files) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		try {
			// 设置utf-8或GBK编码，否则邮件会有乱码
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mailMessage, true, "utf-8");
			messageHelper.setTo(to);// 接受者
			messageHelper.setFrom(javaMailSender.getUsername());// 发送者
			messageHelper.setSubject(subject);// 主题
			// 邮件内容，注意加参数true
			messageHelper.setText(htmlText, true);
			// 附件内容
			messageHelper.addInline("a", new File("F:\\a.jpg"));
			File file = new File("F:\\的是非得失.zip");
			// 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题
			messageHelper.addAttachment(MimeUtility.encodeWord(file.getName()),file);
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
