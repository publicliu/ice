package net.lw.ice.person.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import net.lw.ice.api.person.entity.IOrganization;


@Entity
@Table(name = "SM_ORG")
public class Organization implements IOrganization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SM_ORG")
	@SequenceGenerator(name = "SEQ_SM_ORG", sequenceName = "SEQ_SM_ORG")
	@Column(name = "ID")
	private long id;


	@Column(name = "CODE", nullable = false, length = 40)
	private String code;

	@Column(name = "NAME", nullable = false, length = 40)
	private String name;

	@Column(name = "ADDRESS", nullable = true, length = 60)
	private String address;

	@Column(name = "ZIP", nullable = true, length = 20)
	private String zip;

	@Column(name = "DESCRIPTION", nullable = true, length = 40)
	private String description;

	@ManyToOne(fetch=FetchType.LAZY,targetEntity=net.lw.ice.person.entity.Organization.class)
	@JoinColumn(name="PARENT_ID")
	private IOrganization parent;

	@OneToMany(mappedBy="parent",targetEntity=net.lw.ice.person.entity.Organization.class)
	private List<IOrganization> children = new ArrayList<IOrganization>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getGuid() {
		return String.valueOf(id);
	}

	@Override
	public IOrganization getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	@Override
	public void setParent(IOrganization parent) {
		this.parent = parent;

	}

	public void setGuid(String guid) {
		this.id = Long.valueOf(guid);
	}

	@Override
	public List<IOrganization> listChildren() {
		return this.children;
	}


}
