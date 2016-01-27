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
@Table(name="sys_admin",schema = "")
public class Admin {
	
	@Id
	@Column(name = "id",  nullable = false, length = 11)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "loginname", nullable = false, length = 50)
	private String loginname;
	
	@Column(name = "pwd", nullable = false, length = 50)
	private String pwd;

	@Column(name = "name", nullable = true, length = 50)
	private String name;
	
	@Column(name = "email", nullable = true, length = 50)
	private String email;
	
	@Column(name = "state", nullable = true, length = 11)
	private int state;
	
	@Column(name = "isdelete", nullable = true, length = 11)
	private int isdelete;
	
	@ManyToMany
	@JoinTable(name = "sys_admin_role", joinColumns = { @JoinColumn(name = "adminid") }, inverseJoinColumns = { @JoinColumn(name = "roleid") })
	private List<Role> roles=new ArrayList<Role>();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLoginname() {
		return loginname;
	}
	
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getIsdelete() {
		return isdelete;
	}
	
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	@JsonIgnore
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
