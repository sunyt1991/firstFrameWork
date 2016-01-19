package business.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.base.dao.BaseDao;
import business.system.dao.AdminDao;
import business.system.entity.Admin;
import business.system.entity.Role;
import business.system.service.AdminService;
import util.EncryUtil;

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
		System.out.println(">>>>>:"+adminDb);
		if (adminDb != null) {
			//BeanUtils.copyProperties(adminDb, admin, new String[] { "pwd" });
			return adminDb;
		}
		return null;
	}
	

	@Override
	public void save(Admin admin) {
		
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
	
}
