package business.system.service;

import java.util.List;

import business.system.entity.Resource;
import business.system.entity.Role;

public interface RoleService {

	public List<Resource> getResource(Role role);
	
}
