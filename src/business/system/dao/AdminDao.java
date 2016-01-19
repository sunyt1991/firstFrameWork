package business.system.dao;

import java.util.List;

import business.base.dao.BaseDao;
import business.system.entity.Admin;
import business.system.entity.Role;

public interface AdminDao extends BaseDao<Admin>{
	
	public List<Role> getRoles(Admin admin);
	
}
