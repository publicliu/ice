package net.lw.ice.web.app.weixin.meetlove.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument.Content;

import net.lw.ice.web.app.weixin.meetlove.form.ReceiveTextMsgForm;
import net.lw.ice.web.app.weixin.meetlove.form.SendTextMsgForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.ibm.db2.jcc.am.lo;


@Controller
@RequestMapping("/app/weixin/meetlove")
public class MeetLoveController {

	private final Logger logger = LoggerFactory.getLogger(MeetLoveController.class);

	@RequestMapping(value="/join",method=RequestMethod.GET)
	@ResponseBody
	public String join(WebRequest webRequest,HttpServletRequest request){
		logger.debug("join start------------------------------");
		Iterator<String> iterator = webRequest.getParameterNames();
		while (iterator.hasNext()) {
			String name = iterator.next();
			String value = request.getParameter(name);
			logger.debug("name:"+name+",value:"+value);
		}
		logger.debug("join end------------------------------");
		String echostr = request.getParameter("echostr");
		logger.debug("echostr:"+echostr);
		return echostr;
	}

	@RequestMapping(value="/join",method=RequestMethod.POST)
	@ResponseBody
	public String receive(WebRequest webRequest,HttpServletRequest request){
		logger.debug("receive start------------------------------");
		Iterator<String> iterator = webRequest.getParameterNames();
		while (iterator.hasNext()) {
			String name = iterator.next();
			String value = request.getParameter(name);
			logger.debug("name:"+name+",value:"+value);
		}

		try {
			request.setCharacterEncoding("UTF-8");
			BufferedReader reader = request.getReader();
			String content = "";
			String line = "";
			while((line = reader.readLine()) != null){
				content = content+line;
			}
			logger.debug("content--->");
			logger.debug(content);
			ReceiveTextMsgForm receiveForm = getReceiveMsg(content);
			String sendMsg = SendTextMsgForm.asXml(SendTextMsgForm.toForm(receiveForm, "<a href='http://115.159.33.156/ice-web/meetlove.html'>遇见爱</a>"));
			logger.debug("sendMsg--->");
			logger.debug(sendMsg);
			logger.debug("消息回复结束");
			return sendMsg;
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		logger.debug("receive end------------------------------");
		return "";
	}

	private ReceiveTextMsgForm getReceiveMsg(String xml){
		return ReceiveTextMsgForm.toForm(xml);
	}



}
