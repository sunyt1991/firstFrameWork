package business.system.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import business.system.dao.ResourceDao;
import business.system.entity.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl implements ResourceDao{

	@Override
	public Serializable save(Resource o) {
		return null;
	}

	@Override
	public void delete(Resource o) {
	}

	@Override
	public void update(Resource o) {
	}

	@Override
	public void saveOrUpdate(Resource o) {
	}

	@Override
	public List<Resource> find(String hql) {
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
	public List<Resource> find(String hql, Object[] param) {
		return null;
	}

	@Override
	public List<Resource> find(String hql, List<Object> param) {
		return null;
	}

	@Override
	public Resource get(Class<Resource> c, Serializable id) {
		return null;
	}

	@Override
	public Resource get(String hql, Object[] param) {
		return null;
	}

	@Override
	public Resource get(String hql, List<Object> param) {
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
	public Resource saveAndGetEntity(Resource o) {
		return null;
	}

	@Override
	public List<Resource> parentList() {
		return null;
	}

	@Override
	public List<Resource> childList(Integer pid) {
		
		return null;
	}

}
