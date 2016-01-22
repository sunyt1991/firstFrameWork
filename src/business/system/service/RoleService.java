package business.system.service;

import java.util.List;

import plug.ZTreeInfo;
import business.system.entity.Role;

public interface RoleService {

	public List<ZTreeInfo> getResource(Role role);
	
}
