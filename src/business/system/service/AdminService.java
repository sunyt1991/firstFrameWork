package business.system.service;

import java.util.List;

import plug.RequestPage;
import business.system.entity.Admin;
import business.system.entity.Role;

public interface AdminService {
	
	public Admin login(String username,String password);

	public void save(Admin admin);

	public void update(Admin admin);

	public void delete(String ids);
	
	public List<Admin> list(Object[] params,RequestPage requestPage);
	
	public List<Role> getRoles(int adminId);
		
	

}
