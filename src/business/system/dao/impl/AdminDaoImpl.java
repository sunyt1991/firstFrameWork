package business.system.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import business.system.dao.AdminDao;
import business.system.entity.Admin;
import business.system.entity.Role;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	@Override
	public Serializable save(Admin o) {
		return null;
	}

	@Override
	public void delete(Admin o) {
		
	}

	@Override
	public void update(Admin o) {
		
	}

	@Override
	public void saveOrUpdate(Admin o) {
		
	}

	@Override
	public List<Admin> find(String hql) {
		return null;
	}

	@Override
	public List findSQL(String hql, Class T) {
		return null;
	}

	@Override
	public List findSQL(String hql) {
		return null;
	}

	@Override
	public List<Admin> find(String hql, Object[] param) {
		return null;
	}

	@Override
	public List<Admin> find(String hql, List<Object> param) {
		return null;
	}

	@Override
	public Admin get(Class<Admin> c, Serializable id) {
		return null;
	}

	@Override
	public Admin get(String hql, Object[] param) {
		return null;
	}

	@Override
	public Admin get(String hql, List<Object> param) {
		return null;
	}

	@Override
	public Long count(String hql) {
		return null;
	}

	@Override
	public Long count(String hql, Object[] param) {
		return null;
	}

	@Override
	public Long count(String hql, List<Object> param) {
		return null;
	}

	@Override
	public Integer executeHql(String hql) {
		return null;
	}

	@Override
	public Integer executeHql(String hql, Object[] param) {
		return null;
	}

	@Override
	public Integer executeHql(String hql, List<Object> param) {
		return null;
	}

	@Override
	public List<Role> getRoles(Admin admin) {
		List<Role> roles=admin.getRoles();
		return roles;
	}

	@Override
	public Admin saveAndGetEntity(Admin o) {
		return null;
	}

}
