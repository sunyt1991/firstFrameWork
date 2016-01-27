package business.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plug.PageData;
import util.EncryUtil;
import business.base.dao.BaseDao;
import business.system.dao.AdminDao;
import business.system.entity.Admin;
import business.system.entity.Role;
import business.system.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	private BaseDao<Admin> baseDao;
	
	private AdminDao adminDao;
	
	public BaseDao<Admin> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDao<Admin> baseDao) {
		this.baseDao = baseDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public Admin login(String username,String password) {
		Admin adminDb = baseDao.get("from Admin a where a.loginname = ? and a.pwd = ?", new Object[] { username, EncryUtil.e(password) });
		if (adminDb != null) {
			return adminDb;
		}
		return null;
	}
	
	@Override
	public Admin save(Admin admin) {
		return baseDao.saveAndGetEntity(admin);
	}

	@Override
	public void update(Admin admin) {
		
	}

	@Override
	public void delete(String ids) {
		
	}

	@Override
	public List<Role> getRoles(int adminId) {
		Admin admin=baseDao.get("from Admin where id=?", new Object[]{adminId});
		return adminDao.getRoles(admin);
	}

	@Override
	public PageData<Admin> list(Admin admin) {
		PageData<Admin> p = new PageData<Admin>();
		p.setRows(find(admin));
		p.setTotal(total(admin));
		return p;
		
	}
	
	private List<Admin> find(Admin online) {
		String hql = "from Admin t where 1=1 ";
		List<Object> parms = new ArrayList<Object>();
		hql = addWhere(online, hql, parms);
		return baseDao.find(hql, parms);
	}
	
	private Long total(Admin admin) {
		String hql = "select count(*) from Admin t where 1=1 ";
		List<Object> parms = new ArrayList<Object>();
		hql = addWhere(admin, hql, parms);
		return baseDao.count(hql, parms);
	}
	
	private String addWhere(Admin admin, String hql, List<Object> parms) {
		return hql;
	}

	@Override
	public Admin getById(Integer id) {
		if(id==null){
			return null;
		}
		return baseDao.get(Admin.class, id);
	}

	@Override
	public void setRole(Role role) {
		
	}
}
