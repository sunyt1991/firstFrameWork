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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Resource o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Resource o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Resource o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resource> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findSQL(String hql, Class T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findSQL(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> find(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> find(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource get(Class<Resource> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource get(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource get(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer executeHql(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer executeHql(String hql, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer executeHql(String hql, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

}
