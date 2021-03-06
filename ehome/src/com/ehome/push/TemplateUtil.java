package com.ehome.push;

import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

/**
 * 推送模版工具类
 * 
 * @author kokJuis
 * @version 1.0
 * @date 2017-2-13
 */
public class TemplateUtil {

	/**
	 * 点击通知打开网页
	 * 
	 * @author kokJuis
	 * @version 1.0
	 * @date 2017-2-13
	 * @param title
	 *            通知栏标题
	 * @param text
	 *            通知栏内容
	 * @param logo
	 *            通知栏图标名称
	 * @param logoUrl
	 *            通知栏网络图标，填写图标URL地址
	 * @param isRing
	 *            是否响铃
	 * @param isVibrate
	 *            是否震动
	 * @param isClearable
	 *            是否可清除
	 * @param url
	 *            设置打开的网址地址
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static LinkTemplate linkTemplate(String title, String text,
			String logo, String logoUrl, boolean isRing, boolean isVibrate,
			boolean isClearable, String url) {
		LinkTemplate template = new LinkTemplate();
		// 设置APPID与APPKEY
		template.setAppId(Constants.APPID);
		template.setAppkey(Constants.APPKEY);
		// 设置通知栏标题,不能为空
		if (title != null) {
			template.setTitle(title);
		} else {
			template.setTitle("通知");
		}
		// 设置通知栏内容，不能为空
		if (text != null) {
			template.setText(text);
		} else {
			template.setText("无内容");
		}
		// 配置通知栏图标，不能为空
		if (logo != null) {
			template.setLogo(logo);
		} else {
			template.setLogo("icon.png");
		}
		// 配置通知栏网络图标，填写图标URL地址,不能为空
		if (logoUrl != null) {
			template.setLogoUrl(logoUrl);
		} else {
			template.setLogoUrl("");
		}
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(isRing);
		template.setIsVibrate(isVibrate);
		template.setIsClearable(isClearable);
		// 设置打开的网址地址
		if (url != null) {
			template.setUrl(url);
		} else {
			template.setUrl("http://www.baidu.com");
		}
		// 设置IOS推送模版
		template.setAPNInfo(apnPayload(url));
		return template;
	}

	/**
	 * 点击通知打开应用模板
	 * 
	 * @author kokJuis
	 * @version 1.0
	 * @date 2017-2-14
	 * @param title
	 *            标题
	 * @param text
	 *            标题内容
	 * @param logo
	 *            logo名称
	 * @param logoUrl
	 *            通知栏网络图标，填写图标URL地址
	 * @param isRing
	 *            是否响铃
	 * @param isVibrate
	 *            是否震动
	 * @param isClearable
	 *            是否可清除
	 * @param content
	 *            透传消息内容
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static NotificationTemplate notificationTemplate(String title,
			String text, String logo, String logoUrl, boolean isRing,
			boolean isVibrate, boolean isClearable, String content) {
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(Constants.APPID);
		template.setAppkey(Constants.APPKEY);
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(2);
		if (content != null) {
			template.setTransmissionContent(content);
		} else {
			template.setTransmissionContent("无透传内容");
		}
		// 设置定时展示时间
		// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
		// 设置通知栏标题,不能为空
		if (title != null) {
			template.setTitle(title);
		} else {
			template.setTitle("通知");
		}
		// 设置通知栏内容，不能为空
		if (text != null) {
			template.setText(text);
		} else {
			template.setText("无内容");
		}
		// 配置通知栏图标，不能为空
		if (logo != null) {
			template.setLogo(logo);
		} else {
			template.setLogo("icon.png");
		}
		// 配置通知栏网络图标，填写图标URL地址,不能为空
		if (logoUrl != null) {
			template.setLogoUrl(logoUrl);
		} else {
			template.setLogoUrl("");
		}
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(isRing);
		template.setIsVibrate(isVibrate);
		template.setIsClearable(isClearable);
		// 设置IOS推送模版
		template.setAPNInfo(apnPayload(content));
		return template;
	}

	/**
	 * 透传消息模版
	 * 
	 * @author kokJuis
	 * @version 1.0
	 * @date 2017-2-14
	 * @param content
	 * @return
	 */
	public static TransmissionTemplate transmissionTemplate(String content) {
		TransmissionTemplate template = new TransmissionTemplate();
		// 设置APPID与APPKEY
		template.setAppId(Constants.APPID);
		template.setAppkey(Constants.APPKEY);
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(2);
		if (content != null) {
			template.setTransmissionContent(content);
		} else {
			template.setTransmissionContent("无透传消息");
		}
		template.setAPNInfo(apnPayload(content));
		// 设置定时展示时间
		// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
		return template;
	}

	/**
	 * 获取IOS透传
	 * 
	 * @author kokJuis
	 * @version 1.0
	 * @date 2017-2-14
	 * @param content
	 * @return
	 */
	public static APNPayload apnPayload(String content) {
		// 设置IOS离线推送
		APNPayload payload = new APNPayload();
		payload.setAutoBadge("+1"); // 将应用icon上显示的数字设为1
		// 在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，如10，效果和setBadge一样，
		// 应用icon上显示指定数字。不能和setBadge同时使用
		payload.setContentAvailable(1);
		payload.setSound("default");
		// payload.setCategory("$由客户端定义");
		// 简单模式APNPayload.SimpleMsg
		payload.setAlertMsg(new APNPayload.SimpleAlertMsg("您有新的通知"));
		payload.addCustomMsg("data", content);
		// 字典模式使用下者
		// payload.setAlertMsg(getDictionaryAlertMsg());
		return payload;
	}
}
