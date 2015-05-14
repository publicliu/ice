package net.lw.ice.web.person.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.ice.api.person.entity.IPerson;

public class PersonForm {

	private long id;
	private String code;
	private String name;
	private String mobile;
	private String phone;
	private String email;

	public PersonForm() {}




	public PersonForm(long id,String code,String name, String mobile,
			String phone, String email) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
	}




	public static PersonForm toForm(IPerson person){
		return new PersonForm(person.getId(),
				person.getCode(),
				person.getName(),
				person.getMobile(),
				person.getPhone(),
				person.getEmail());
	}

	public static List<PersonForm> toForms(List<IPerson> persons){
		List<PersonForm> forms = new ArrayList<PersonForm>();
		for(IPerson person : persons){
			forms.add(toForm(person));
		}
		return forms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
