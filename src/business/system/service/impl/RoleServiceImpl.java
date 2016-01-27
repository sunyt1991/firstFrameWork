package business.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plug.PageData;
import plug.ZTreeInfo;
import business.base.dao.BaseDao;
import business.system.dao.RoleDao;
import business.system.entity.Admin;
import business.system.entity.Resource;
import business.system.entity.Role;
import business.system.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;
	
	private BaseDao<Role> baseDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public BaseDao<Role> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDao<Role> baseDao) {
		this.baseDao = baseDao;
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

	@Override
	public PageData<Role> list(Role role) {
		PageData<Role> p = new PageData<Role>();
		p.setRows(find(role));
		p.setTotal(total(role));
		return p;
	}
	
	private List<Role> find(Role role) {
		String hql = "from Role r where 1=1 ";
		List<Object> parms = new ArrayList<Object>();
		hql = addWhere(role, hql, parms);
		return baseDao.find(hql, parms);
	}
	
	private String addWhere(Role role, String hql, List<Object> parms) {
		return hql;
	}
	
	private Long total(Role role) {
		String hql = "select count(*) from Role r where 1=1 ";
		List<Object> parms = new ArrayList<Object>();
		hql = addWhere(role, hql, parms);
		return baseDao.count(hql, parms);
	}

	@Override
	public Role getById(Integer id) {
		if(id==null){
			return null;
		}
		return baseDao.get(Role.class, id);
	}

}
