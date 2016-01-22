package plug;

import java.io.Serializable;
import java.util.Map;

/**
 * ztree
 * @author Administrator
 */
public class ZTreeInfo implements Serializable {
	
	// 节点id
	private Integer id;

	// 父节点id，无父节点为0，默认为0
	private Integer pId = 0;

	// 节点名称
	private String name;

	// 超链接
	private String theUrl;

	// 链接方向
	private String target;

	// 是否节点显示checkbox
	private boolean nocheck;
	//打开类型,默认为tab
	private String openType="tab";

	// 是否默认选中
	private boolean checked = false;

	// 是否展开
	private boolean open = false;

	// 是否父节点
	private boolean isParent = false;
	
	private String options;

	private Map<String, Object> attributes;

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer id) {
		pId = id;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

 
	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public boolean isisParent() {
		return isParent;
	}

	public void setisParent(boolean isParent) {
		this.isParent = isParent;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getTheUrl() {
		return theUrl;
	}

	public void setTheUrl(String theUrl) {
		this.theUrl = theUrl;
	}

}
