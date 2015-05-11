package net.lw.ice.web.person.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;

public class OrgForm {

	private long id;
	private String code;
	private String name;
	private String address;
	private String zip;
	private String des;

	public OrgForm() {}

	public OrgForm(long id, String code, String name, String address,
			String zip, String des) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.des = des;
	}


	public static OrgForm toForm(IOrganization org){
		return new OrgForm(org.getId(),
				org.getCode(),
				org.getName(),
				org.getAddress(),
				org.getZip(),
				org.getDescription());
	}

	public static List<OrgForm> toForms(List<IOrganization> orgs){
		List<OrgForm> forms = new ArrayList<OrgForm>();
		for(IOrganization org : orgs){
			forms.add(toForm(org));
		}
		return forms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}









}
