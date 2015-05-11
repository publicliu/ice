package net.lw.ice.web.person.form;

import java.util.ArrayList;
import java.util.List;

import net.lw.ice.api.person.entity.IOrganization;

public class OrgTreeForm {

	private String id;
	private String guid;
	private String text;
	private boolean leaf = true;

	public OrgTreeForm() {
	}

	public OrgTreeForm(IOrganization organization) {
		id = organization.getCode();
		guid = organization.getGuid();
		text = organization.getName();
		leaf = !(organization.listChildren().size()>0);
	}

	public static OrgTreeForm toForm(IOrganization org){
		OrgTreeForm form = new OrgTreeForm(org);
		return form;
	}

	public static List<OrgTreeForm> toForms(List<IOrganization> orgs){
		List<OrgTreeForm> forms = new ArrayList<OrgTreeForm>();
		for(IOrganization org : orgs){
			forms.add(toForm(org));
		}
		return forms;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}


}
