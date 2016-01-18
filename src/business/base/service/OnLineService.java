package business.base.service;

public interface OnLineService {
	
	public void saveOrUpdateTonlineByLoginNameAndIp(String loginName, String ip);

	public void deleteTonlineByLoginNameAndIp(String loginName, String ip);


}
