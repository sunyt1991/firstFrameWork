package plug;

import java.io.Serializable;

public class SessionInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int adminId;
	
	private String loginName;
	
	private String pwd;
	
	private String ip;

	private String roleId;
	
	private String roleName;
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String toString() {
		return loginName;
	}

	public String getRoleid() {
		return roleId;
	}

	public void setRoleid(String roleid) {
		this.roleId = roleid;
	}

	public String getRolename() {
		return roleName;
	}

	public void setRolename(String rolename) {
		this.roleName = rolename;
	}
	
	

}
