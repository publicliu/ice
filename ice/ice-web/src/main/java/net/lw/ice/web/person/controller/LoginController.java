package net.lw.ice.web.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IUserService;
import net.lw.ice.common.exception.AppException;
import net.lw.ice.common.util.MsgDigestAlgorithm;
import net.lw.ice.web.util.FishWebUtils;
import net.lw.ice.web.util.UserSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);

	@Autowired(required = false)
	private IUserService userService;


	/**
	 * 登录并验证用户
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	ModelMap login(@RequestParam String username, @RequestParam String password, HttpSession session,
			HttpServletRequest request, WebRequest webrequest) {
		ModelMap result = new ModelMap();


		try {
			IUser user = userService.login(username, password);
			IOrganization org = user.getOrganization();

			result.addAttribute("success", true);
			result.addAttribute("id", session.getId());

			// 保存会话信息
			UserSession userSession = new UserSession();
			userSession.setUserId(user.getId());
			userSession.setUserName(user.getName());
			userSession.setUserCode(user.getCode());
			userSession.setOrgId(org.getId());
			userSession.setOrgName(org.getName());
			userSession.setOrgCode(org.getCode());
			session.setAttribute(FishWebUtils.USER, userSession);
		}catch(AppException app){
			logger.error(app.getMessage());
			result.addAttribute("success", false);
			result.addAttribute("message", app.getMessage());
		}
		catch (Exception e) {
			logger.error(String.format("User login error![%s]",e));
			result.addAttribute("success", false);
			result.addAttribute("message", "用户登录发生异常.");
		}
		return result;
	}

	/**
	 * 验证用户和密码是否正确
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap check(@RequestParam String code, @RequestParam String password, HttpSession session,
			HttpServletRequest request, WebRequest webrequest) {
		ModelMap result = new ModelMap();
		IUser user = userService.get(code);
		// 验证密码
		String pwd = MsgDigestAlgorithm.getMD5Str(password);
		if (!user.getPassword().equals(pwd)) {
			result.addAttribute("success", false);
			result.addAttribute("errors", "您输入的密码错误,请重新输入密码.");
		} else {
			result.addAttribute("success", true);
		}
		return result;
	}



}
