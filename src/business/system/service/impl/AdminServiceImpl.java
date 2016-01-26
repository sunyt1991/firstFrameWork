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
		
		System.out.println(">>>>>>>");
		return baseDao.find(hql, parms);
	}
	
	private Long total(Admin admin) {
		System.out.println("1");
		String hql = "select count(*) from Admin t where 1=1 ";
		System.out.println("2");
		
		List<Object> parms = new ArrayList<Object>();
		System.out.println("3");
		
		hql = addWhere(admin, hql, parms);
		System.out.println("4");
		return baseDao.count(hql, parms);
	}
	
	private String addWhere(Admin admin, String hql, List<Object> parms) {
		return hql;
	}
}
