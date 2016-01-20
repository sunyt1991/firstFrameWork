package business.system.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import business.system.dao.RoleDao;
import business.system.entity.Resource;
import business.system.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao{

	@Override
	public List<Resource> getResources(Role role) {
		return role.getResources();
	}

	@Override
	public Serializable save(Role o) {
		return null;
	}

	@Override
	public void delete(Role o) {
		
	}

	@Override
	public void update(Role o) {
		
	}

	@Override
	public void saveOrUpdate(Role o) {
		
	}

	@Override
	public List<Role> find(String hql) {
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
	public List<Role> find(String hql, Object[] param) {
		return null;
	}

	@Override
	public List<Role> find(String hql, List<Object> param) {
		return null;
	}

	@Override
	public List<Role> find(String hql, Object[] param, Integer page,
			Integer rows) {
		return null;
	}

	@Override
	public List<Role> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		return null;
	}

	@Override
	public Role get(Class<Role> c, Serializable id) {
		return null;
	}

	@Override
	public Role get(String hql, Object[] param) {
		return null;
	}

	@Override
	public Role get(String hql, List<Object> param) {
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

}
