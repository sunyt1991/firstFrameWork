package business.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plug.TreeInfo;
import business.base.dao.BaseDao;
import business.system.dao.ResourceDao;
import business.system.entity.Resource;
import business.system.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{
	
	private BaseDao<Resource> baseDao;
	
	private ResourceDao resourceDao;

	public BaseDao<Resource> getBaseDao() {
		return baseDao;
	}
	
	@Autowired
	public void setBaseDao(BaseDao<Resource> baseDao) {
		this.baseDao = baseDao;
	}
	
	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	@Override
	public List<TreeInfo> treeList(Integer node) {
		List treeList = new ArrayList();  
		List<Resource> permenus = new ArrayList<Resource>();
		List<Resource> menuList = new ArrayList<Resource>();
		if(node==null){
			menuList=baseDao.find("select * from Resource r where (r.pid is null or r.pid ='') order by r.ordernum desc ");
			for (Resource menu : menuList) {		
				permenus.add(menu);
			}
		} else { 
			List<Resource> selectMenus = new ArrayList<Resource>() ;
			//selectMenus = Resource.dao.find("select * from Resource d where d.parentid="+node+" and d.isdelete=0 order by ordernum,id desc") ;
			selectMenus=resourceDao.childList(node);
			permenus.clear();
			permenus.addAll(selectMenus);
		}
		for(Resource resource:permenus){
			Map<String,Object> tree = new HashMap<String,Object>();
		     tree.put("id", resource.getId());
		     tree.put("name", resource.getName());
		     tree.put("descn", resource.getDescn());
		     if(isHaveChild(resource.getId())){
		    	 tree.put("state", "closed");
		     }else{
		    	 tree.put("state", "open");
		     }
		     if(resource.getPid()!=null){
		    	 tree.put("_parentId", resource.getPid());
		     }
			 treeList.add(tree);
		}
		return treeList;
	}
	
	public boolean isHaveChild(Integer pid){
		List<Resource> list=resourceDao.childList(pid);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
}
