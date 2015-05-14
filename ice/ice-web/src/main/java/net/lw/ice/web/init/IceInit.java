package net.lw.ice.web.init;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.entity.IPerson;
import net.lw.ice.api.person.entity.IUser;
import net.lw.ice.api.person.service.IOrganizationService;
import net.lw.ice.api.person.service.IPersonService;
import net.lw.ice.api.person.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;

public class IceInit {


	@Autowired
	private IOrganizationService organizationService;

	@Autowired
	private IUserService userService;
	@Autowired
	private IPersonService personService;

	public void init(){
		this.initOrg();
		this.initUser();
	}

	private void initOrg(){
		IOrganization root = organizationService.make();
		root.setName("组织机构");
		root.setCode("root");
		root.setDescription("root");
		root.setAddress("root");
		root.setZip("12345678");
		root.setParent(null);
		organizationService.add(root);


		IOrganization organization1 = organizationService.make();
		organization1.setName("江苏总部");
		organization1.setCode("320000");
		organization1.setDescription("江苏总部");
		organization1.setAddress("江苏总部");
		organization1.setZip("12345678");
		organization1.setParent(root);
		organizationService.add(organization1);

		IOrganization organization2 = organizationService.make();
		organization2.setName("南京分公司");
		organization2.setCode("320100");
		organization2.setDescription("南京加盟店");
		organization2.setAddress("明发商业广场");
		organization2.setZip("12345678");
		organization2.setParent(organization1);
		organizationService.add(organization2);

	}

	private void initUser(){

		IPerson person = personService.make();
		person.setName("admin");
		person.setCode("admin");
		person.setMobile("13805146805");
		person.setOrganization(organizationService.getByCode("root"));
		personService.add(person);


		IUser user = userService.make();
		user.setPlainText("888888");
		user.setPerson(person);
		userService.add(user);
	}

}
