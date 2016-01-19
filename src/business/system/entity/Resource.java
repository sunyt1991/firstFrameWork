package business.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_role",schema = "")
public class Resource {
	
	private int id;
	
	private String name;
	
	private String restype;
	
	private String resstring;
	
	private String descn;
	
	private int pid;
	
	private int ordernum;
	
	private String opentype;
	
	private String options;

	@Id
	@Column(name = "id",  nullable = false, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = true, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "restype", nullable = true, length = 20)
	public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	@Column(name = "resstring", nullable = true, length = 20)
	public String getResstring() {
		return resstring;
	}

	public void setResstring(String resstring) {
		this.resstring = resstring;
	}

	@Column(name = "descn", nullable = true, length = 20)
	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	@Column(name = "pid", nullable = true, length = 20)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name = "ordernum", nullable = true, length = 20)
	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	@Column(name = "opentype", nullable = true, length = 20)
	public String getOpentype() {
		return opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	@Column(name = "options", nullable = true, length = 20)
	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
	
	
}
