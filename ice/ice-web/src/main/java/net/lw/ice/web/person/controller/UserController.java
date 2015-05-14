package net.lw.ice.web.person.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.api.person.service.IUserService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.filter.Filter;
import net.lw.ice.web.person.form.UserForm;
import net.lw.ice.web.util.FishWebUtils;
import net.lw.ice.web.util.IceConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;


@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private IUserService userService;

	@Autowired
	private IOrganizationService orgService;


	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public  ModelMap list(@RequestParam String orgCode ,@RequestParam int start,@RequestParam int limit,
			WebRequest webRequest,HttpServletRequest request){
		ModelMap model = new ModelMap();
		IFilter filter = new Filter();

		Iterator<String> iterator = webRequest.getParameterNames();
		while (iterator.hasNext()) {
			String name = iterator.next();
			if (FishWebUtils.isIgnoreRequestName(name)) {
				continue;
			} else {
				if (request.getParameter(name).isEmpty()) {
					continue;
				} else {
					// 去掉前端页面传来的sort排序字段
					if ("sort".equals(name)) {
						continue;
					} else if ("userCode".equals(name)) {
						filter.like("code", request.getParameter(name));
					} else if ("userName".equals(name)) {
						filter.like("name", request.getParameter(name));
					}
				}
			}
		}

//		IPageResult<IUser> pageResult = orgService.page(orgCode, start, limit, filter);
//		model.addAttribute("success", true);
//		model.addAttribute("total", pageResult.getTotal());
//		model.addAttribute("data", UserForm.toForms(pageResult.list()));
		return model;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ModelMap add(@RequestParam String orgCode ,@RequestBody UserForm form){
		ModelMap model = new ModelMap();
		if(isExistUserByCode(form.getCode())){
			model.addAttribute("success", false);
			model.put("errors", "增加失败:用户名重复.");
			return model;
		}
		IUser user = userService.make();
//		user.setCode(form.getCode());
		user.setSystem(false);

		try {
			user = userService.add(user);
		} catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("errors","添加用户发生异常");
			return model;
		}

		model.addAttribute("data", UserForm.toForm(user));
		model.addAttribute("success", true);
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ModelMap delete(@PathVariable long id){
		ModelMap model = new ModelMap();

		if(userService.get(id) == null){
			model.addAttribute("success", true);
			return model;
		}

		try {
			userService.remove(id);
			model.addAttribute("success", true);
		} catch (Exception e) {
			model.addAttribute("errors", "删除失败:后台处理出错.");
			model.addAttribute("success", false);
		}
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelMap update(@PathVariable long id, @RequestBody UserForm form) {
		ModelMap result = new ModelMap();
		IUser user = userService.get(id);
		if(user == null){
			result.put(IceConstant.ERROR_MSG, "更新失败，用户已不存在");
			result.put(IceConstant.SUCCESS, false);
			return result;
		}

		String code = form.getCode();
		if(userService.get(code)!=null){
			result.put(IceConstant.ERROR_MSG, "更新失败，用户名已存在");
			result.put(IceConstant.SUCCESS, false);
			return result;
		}

//		user.setCode(form.getCode());

		try {
			userService.update(user);
			result.put(IceConstant.ERROR_MSG, "更新成功");
			result.put(IceConstant.SUCCESS, true);
		} catch (Exception e) {
			result.put(IceConstant.ERROR_MSG, "更新失败");
			result.put(IceConstant.SUCCESS, false);
		}

		return result;
	}

	private boolean isExistUserByCode(String userCode){
		IUser user = userService.get(userCode);
		if(user == null){
			return false;
		}
		return true;
	}

}
