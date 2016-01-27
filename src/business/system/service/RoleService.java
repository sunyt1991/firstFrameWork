package business.system.service;

import java.util.List;

import plug.PageData;
import plug.ZTreeInfo;
import business.system.entity.Admin;
import business.system.entity.Role;

public interface RoleService {

	public List<ZTreeInfo> getResource(Role role);
	
	public PageData<Role> list(Role role);
	
	public Role getById(Integer id);
	
}
