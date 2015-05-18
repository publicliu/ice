package net.lw.ice.web.app.weixin.meetlove.form;

import java.util.Date;

import net.lw.meetlove.api.MsgType;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveTextMsgForm {

	private final static Logger logger = LoggerFactory.getLogger(ReceiveTextMsgForm.class);
	private String url;
	private String toUserName;
	private String fromUserName;
	private Date createTime;
	private MsgType msgType;
	private String content;
	private String msgId;


	public ReceiveTextMsgForm() {}


	public ReceiveTextMsgForm(String url, String toUserName,
			String fromUserName, Date createTime, MsgType msgType,
			String content, String msgId) {
		this.url = url;
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
		this.content = content;
		this.msgId = msgId;
	}

	public static ReceiveTextMsgForm toForm(String xml){
		ReceiveTextMsgForm form = new ReceiveTextMsgForm();
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element rootElement = doc.getRootElement();
			String path = rootElement.getPath()+"/";
			Node toUserNameNode = doc.selectSingleNode(path+"ToUserName");
			Node fromUserNameNode = doc.selectSingleNode(path+"FromUserName");
			Node msgTypeNode = doc.selectSingleNode(path+"MsgType");
			Node contentNode = doc.selectSingleNode(path+"Content");
			Node msgIdNode = doc.selectSingleNode(path+"MsgId");

			form.setToUserName(toUserNameNode.getText());
			form.setFromUserName(fromUserNameNode.getText());
			form.setMsgType(MsgType.getById(msgTypeNode.getText()));
			form.setContent(contentNode.getText());
			form.setMsgId(msgIdNode.getText());

		} catch (DocumentException e) {
			logger.debug(e.getMessage());
		}
		return form;
	}

	public static void main(String[] args) {
		String xml = "<xml><URL><![CDATA[http://115.159.33.156/ice-web/api/app/weixin/meetlove/join]]></URL><ToUserName><![CDATA[1]]></ToUserName><FromUserName><![CDATA[2]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[1111]]></Content><MsgId>1111</MsgId></xml>";
		ReceiveTextMsgForm receiveForm = toForm(xml);
		String sendXml = SendTextMsgForm.asXml(SendTextMsgForm.toForm(receiveForm, "test"));
		System.out.println(sendXml);
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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


	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}


	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}







}
