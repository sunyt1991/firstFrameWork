package business.system.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sys_admin",schema = "")
public class Admin {
	private Integer id;
	
	private String loginname;
	
	private String pwd;
	
	private String name;
	
	private int state;
	
	private int isdelete;
	
	private List<Role> roles;
	
	@Id
	@Column(name = "id",  nullable = false, length = 11)
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "loginname", nullable = false, length = 255)
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@Column(name = "pwd", nullable = false, length = 255)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Column(name = "name", nullable = true, length = 255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "state", nullable = true, length = 11)
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Column(name = "isdelete", nullable = true, length = 11)
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "sys_admin_role", joinColumns = { @JoinColumn(name = "adminid", unique = false, nullable = false, insertable = true, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "roleid", unique = false, nullable = false, insertable = true, updatable = false) })
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
