package business.system.service;

import business.system.entity.Admin;

public interface AdminService {
	
	public Admin login(String username,String password);

	public void save(Admin admin);

	public void update(Admin admin);

	public void delete(String ids);

}
