package business.system.service;

import java.util.List;

import plug.PageData;
import plug.RequestPage;
import business.system.entity.Admin;
import business.system.entity.Role;

public interface AdminService {
	
	public Admin login(String username,String password);

	public Admin save(Admin admin);

	public void update(Admin admin);

	public void delete(String ids);
	
	public PageData<Admin> list(Admin admin);
	
	public List<Role> getRoles(int adminId);
	
	public void setRole(Role role);
		
	public Admin getById(Integer id);

}
