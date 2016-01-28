package business.system.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sys_resource",schema = "")
public class Resource {
	
	@Id
	@Column(name = "id",  nullable = false, length = 10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", nullable = true, length = 50)
	private String name;
	
	@Column(name = "restype", nullable = true, length = 20)
	private String restype;
	
	@Column(name = "resstring", nullable = true, length = 200)
	private String resstring;
	
	@Column(name = "descn", nullable = true, length = 200)
	private String descn;
	
	@Column(name = "pid", nullable = true, length = 10)
	private Integer pid;
	
	@Column(name = "ordernum", nullable = false, length = 10)
	private Integer ordernum;

	@Column(name="leaf",nullable=true,length=10)
	private Integer leaf;
	
	@Column(name = "opentype", nullable = true, length = 10)
	private String opentype;
	
	@Column(name = "options", nullable = true, length = 255)
	private String options;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "resources",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<Role> roles = new ArrayList<Role>();

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
	
	public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public String getResstring() {
		return resstring;
	}

	public void setResstring(String resstring) {
		this.resstring = resstring;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	public String getOpentype() {
		return opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
}
