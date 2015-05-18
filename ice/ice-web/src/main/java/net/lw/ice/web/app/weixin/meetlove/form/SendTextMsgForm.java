package net.lw.ice.web.app.weixin.meetlove.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import net.lw.meetlove.api.MsgType;

public class SendTextMsgForm {

	private String toUserName;
	private String fromUserName;
	private Date createTime;
	private MsgType msgType;
	private String content;


	public SendTextMsgForm() {}

	public SendTextMsgForm(String toUserName, String fromUserName,
			 MsgType msgType, String content) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = new Date();
		this.msgType = msgType;
		this.content = content;
	}

	public static SendTextMsgForm toForm(ReceiveTextMsgForm receiveForm,String content){
		return new SendTextMsgForm(
					receiveForm.getFromUserName(),
					receiveForm.getToUserName(),
					receiveForm.getMsgType(),
					content
				);
	}

	public static String asXml(SendTextMsgForm form){
		Element root = DocumentHelper.createElement("xml");

		Element toUserElement = root.addElement("ToUserName");
		toUserElement.addCDATA(form.getToUserName());

		Element formUserNameElement = root.addElement("FromUserName");
		formUserNameElement.addCDATA(form.getFromUserName());

		Element createTimeElement = root.addElement("CreateTime");
		createTimeElement.addCDATA(""+form.getCreateTime().getTime());

		Element msgTypeElement = root.addElement("MsgType");
		msgTypeElement.addCDATA(form.getMsgType().getId());

		Element contentElement = root.addElement("Content");
		contentElement.addCDATA(form.getContent());
		return root.asXML();
	}





	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}
	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}
	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the msgType
	 */
	public MsgType getMsgType() {
		return msgType;
	}
	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}



}
