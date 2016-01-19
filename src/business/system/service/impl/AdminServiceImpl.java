package business.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.base.dao.BaseDao;
import business.system.entity.Admin;
import business.system.service.AdminService;
import util.EncryUtil;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	private BaseDao<Admin> userDao;
	
	
	public BaseDao<Admin> getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(BaseDao<Admin> userDao) {
		this.userDao = userDao;
	}

	@Override
	public Admin login(String username,String password) {
		Admin adminDb = userDao.get("from Admin a where a.loginname = ? and a.pwd = ?", new Object[] { username, EncryUtil.e(password) });
		System.out.println(">>:"+adminDb);
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
	
}
