package business.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plug.ZTreeInfo;
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
	public List<ZTreeInfo> getResource(Role role) {
		List<Resource> resources=roleDao.getResources(role);
		List<ZTreeInfo> treelist=new ArrayList<ZTreeInfo>();
	    for (Resource re : resources) {
			ZTreeInfo ztree = new ZTreeInfo();
			ztree.setId(re.getId());
			ztree.setName(re.getName());
			ztree.setTheUrl(re.getResstring());
			ztree.setOptions(re.getOptions());
			ztree.setOpenType(re.getOpentype()); 
			if (re.getLeaf() == 0) {
				ztree.setisParent(true);
			}
			if (re.getPid() != null) {
				ztree.setpId(re.getPid());
			}else{
				ztree.setpId(null);
			}
			treelist.add(ztree);
		}
		
		return treelist;
	}

}
