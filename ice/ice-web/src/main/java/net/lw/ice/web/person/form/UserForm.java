package net.lw.ice.web.person.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.ice.api.person.entity.IUser;

public class UserForm {

	private long id;
	private String code;
	private String name;
	private String mobile;
	private String phone;
	private String email;

	public UserForm() {}




	public UserForm(long id, String code, String name, String mobile,
			String phone, String email) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
	}




	public static UserForm toForm(IUser user){
		return new UserForm(user.getId(),
				user.getCode(),
				user.getName(),
				user.getMobile(),
				user.getPhone(),
				user.getEmail());
	}

	public static List<UserForm> toForms(List<IUser> users){
		List<UserForm> forms = new ArrayList<UserForm>();
		for(IUser user : users){
			forms.add(toForm(user));
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
