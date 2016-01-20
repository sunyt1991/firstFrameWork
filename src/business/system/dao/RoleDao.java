package business.system.dao;

import java.util.List;

import business.base.dao.BaseDao;
import business.system.entity.Resource;
import business.system.entity.Role;

public interface RoleDao extends BaseDao<Role>{
	
	public List<Resource> getResources(Role role);

}
