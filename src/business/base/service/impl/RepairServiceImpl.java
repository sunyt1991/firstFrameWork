package business.base.service.impl;

import org.springframework.stereotype.Service;

import business.base.service.RepairService;


@Service("repairService")
public class RepairServiceImpl implements RepairService {

	@Override
	public void repair() {
		System.out.println("�����޸���ʼ������");
		System.out.println("�����޸���ϡ�����");
	}

	@Override
	public void deleteAndRepair() {

	}

}
