package business.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_admin",schema = "")
public class Admin {
	private int id;
	
	private String loginname;
	
	private String pwd;
	
	private String name;
	
	private int state;
	
	private int isdelete;
	
	@Id
	@Column(name = "id",  nullable = false, length = 11)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "loginname", nullable = false, length = 100)
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@Column(name = "pwd", nullable = false, length = 100)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "state", nullable = false, length = 100)
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Column(name = "isdelete", nullable = false, length = 100)
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	
}
