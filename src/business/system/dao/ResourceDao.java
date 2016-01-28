package business.system.dao;

import java.util.List;

import business.base.dao.BaseDao;
import business.system.entity.Resource;
import business.system.entity.Role;

public interface ResourceDao extends BaseDao<Resource>{
	
	public List<Resource> parentList();
	
	public List<Resource> childList(Integer pid);
	
}
