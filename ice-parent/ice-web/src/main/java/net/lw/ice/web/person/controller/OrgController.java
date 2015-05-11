package net.lw.ice.web.person.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.common.IFilter;
import net.lw.ice.common.IPageResult;
import net.lw.ice.common.filter.Filter;
import net.lw.ice.web.person.form.OrgForm;
import net.lw.ice.web.person.form.OrgTreeForm;
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
@RequestMapping("/org")
public class OrgController {

	@Autowired
	private IOrganizationService orgService;


	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public  ModelMap list(@RequestParam String parentOrgCode ,@RequestParam int start,@RequestParam int limit,
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
					} else if ("orgCode".equals(name)) {
						filter.like("code", request.getParameter(name));
					} else if ("orgName".equals(name)) {
						filter.like("name", request.getParameter(name));
					}
				}
			}
		}

		IPageResult<IOrganization> pageResult = orgService.pageChildrenByCode(start, limit, filter, parentOrgCode);
		model.addAttribute("success", true);
		model.addAttribute("total", pageResult.getTotal());
		model.addAttribute("data", OrgForm.toForms(pageResult.list()));
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/orgTree",method=RequestMethod.GET)
	public ModelMap getOrgTree(@RequestParam String node){
		ModelMap model = new ModelMap();
		List<IOrganization> orgs = orgService.listChildrenByCode(node);
		model.addAttribute("success", true);
		model.addAttribute("data", OrgTreeForm.toForms(orgs));
		return model;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ModelMap add(@RequestParam String parentOrgCode ,@RequestBody OrgForm form){
		ModelMap result = new ModelMap();
		if(isExistOrgByCode(form.getCode())){
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "增加失败:机构编码已存在.");
			return result;
		}

		IOrganization org = orgService.make();
		org.setCode(form.getCode());
		org.setAddress(form.getAddress());
		org.setName(form.getName());
		org.setDescription(form.getDes());
		org.setZip(form.getZip());

		try {
			IOrganization parentOrg = orgService.getByCode(parentOrgCode);
			org.setParent(parentOrg);
			org = orgService.add(org);
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "增加失败");
		}

		result.addAttribute("data",OrgForm.toForm(org));
		result.addAttribute("success", true);

		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ModelMap delete(@PathVariable long id){
		ModelMap result = new ModelMap();
		result.addAttribute(IceConstant.SUCCESS, true);
		IOrganization org = orgService.get(id);


		List<IOrganization> orgChildren = orgService.listChildren(id);
		if(orgChildren != null && orgChildren.size() > 0){
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "删除失败，本机构下还有子机构无法删除");
			return result;
		}

		List<IUser> users = orgService.listUser(org.getCode());
		if(users != null && users.size()>0){
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "删除失败，本机构下还有用户无法删除");
			return result;
		}

		try {
			orgService.remove(org);
			result.addAttribute(IceConstant.SUCCESS, true);
			result.addAttribute(IceConstant.ERROR_MSG, "删除成功");
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "删除失败");
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ModelMap udpate(@PathVariable long id ,@RequestBody OrgForm form){
		ModelMap result = new ModelMap();
		IOrganization org = orgService.get(id);
		if(org == null){
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "修改失败，机构已不存在");
			return result;
		}

		IOrganization org2 = orgService.getByCode(form.getCode());
		if( org2 != null && org2.getId()!= id){
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "修改失败，机构编号已存在");
			return result;
		}

		org.setCode(form.getCode());
		org.setName(form.getName());
		org.setAddress(form.getAddress());
		org.setDescription(form.getDes());
		org.setZip(form.getZip());

		try {
			orgService.update(org);
		} catch (Exception e) {
			result.addAttribute(IceConstant.SUCCESS, false);
			result.addAttribute(IceConstant.ERROR_MSG, "修改失败");
			return result;
		}


		result.addAttribute(IceConstant.SUCCESS, true);
		result.addAttribute(IceConstant.ERROR_MSG, "修改成功");
		return result;
	}

	private boolean isExistOrgByCode(String code){
		IOrganization org = orgService.getByCode(code);
		if(org == null){
			return false;
		}
		return true;
	}

}
