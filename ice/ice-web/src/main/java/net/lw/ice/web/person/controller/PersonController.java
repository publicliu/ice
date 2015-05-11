package net.lw.ice.web.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/person")
public class PersonController {



	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public  ModelMap list(){
		ModelMap model = new ModelMap();
		model.put("success", true);
		return model;
	}


}
