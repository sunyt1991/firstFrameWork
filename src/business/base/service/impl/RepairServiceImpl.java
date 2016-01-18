package business.base.service.impl;

import org.springframework.stereotype.Service;

import business.base.service.RepairService;


@Service("repairService")
public class RepairServiceImpl implements RepairService {

	@Override
	public void repair() {
		System.out.println("数据修复开始。。。");
		System.out.println("数据修复完毕。。。");
	}

	@Override
	public void deleteAndRepair() {

	}

}
