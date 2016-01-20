package business.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.system.dao.RoleDao;
import business.system.entity.Resource;
import business.system.entity.Role;
import business.system.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Resource> getResource(Role role) {
		return roleDao.getResources(role);
	}

}
