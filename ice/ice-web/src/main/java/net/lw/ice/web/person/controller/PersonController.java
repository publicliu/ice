package net.lw.ice.web.person.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.api.person.service.IPersonService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.filter.Filter;
import net.lw.ice.web.person.form.PersonForm;
import net.lw.ice.web.util.FishWebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;


@Controller
@RequestMapping("/person")
public class PersonController {


	@Autowired
	private IPersonService personService;
	@Autowired
	private IOrganizationService orgService;

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public  ModelMap list(@RequestParam String orgCode ,@RequestParam int start,@RequestParam int limit,
			WebRequest webRequest,HttpServletRequest request){

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

		IPageResult<IPerson> pageResult = orgService.listByOrgCode(orgCode, start, limit, filter);

		ModelMap model = new ModelMap();
		model.addAttribute("success", true);
		model.addAttribute("total", pageResult.getTotal());
		model.addAttribute("data", PersonForm.toForms(pageResult.list()));
		return model;
	}


}
