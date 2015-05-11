package net.lw.ice.web.init;

import net.lw.ice.api.person.entity.IOrganization;
import net.lw.ice.api.person.service.IOrganizationService;

import org.springframework.beans.factory.annotation.Autowired;

public class IceInit {


	@Autowired
	private IOrganizationService organizationService;

	public void init(){
		//this.initOrg();
	}

	private void initOrg(){
		IOrganization organization = organizationService.make();
		organization.setName("南京分公司");
		organization.setCode("nj");
		organization.setDescription("备件中心");
		organization.setAddress("南京郁金香");
		organization.setZip("12345678");
		organization.setParent(null);
		organizationService.add(organization);

		IOrganization organization2 = organizationService.make();
		organization2.setName("高淳分公司");
		organization2.setCode("gaochun");
		organization2.setDescription("备件中心");
		organization2.setAddress("南京高淳");
		organization2.setZip("12345678");
		organization2.setParent(organization);
		organizationService.add(organization2);

	}


}
