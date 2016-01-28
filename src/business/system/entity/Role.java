package business.system.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sys_role",schema = "")
public class Role {
	
	@Id
	@Column(name = "id",  nullable = false, length = 11)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", nullable = true, length = 20)
	private String name;
	
	@Column(name = "descn", nullable = true, length = 200)
	private String descn;
	
	@JsonIgnore
	@ManyToMany  
    @JoinTable(name = "sys_admin_role",  joinColumns = @JoinColumn(name = "roleid"), inverseJoinColumns = @JoinColumn(name = "adminid"))  
	private List<Admin> admins=new ArrayList<Admin>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "sys_role_resource", joinColumns = @JoinColumn(name = "roleid"),inverseJoinColumns = @JoinColumn(name = "resourceid"))
	private List<Resource> resources = new ArrayList<Resource>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}
	
	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	
	
}
