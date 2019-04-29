package com.lovo.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lovo.boot.bean.PowerDto;
import com.lovo.boot.bean.PowerEntity;
import com.lovo.boot.dao.PowerDao;
import com.lovo.boot.service.IPowerService;
@Service("powerService")
public class PowerServiceImpl implements IPowerService {

	@Autowired
	private PowerDao powerDao;

	public PowerEntity savaPower(PowerEntity power) {
		 return powerDao.save(power);
	}

	
	public List<PowerEntity> getPowerList() {
		
		return (List<PowerEntity>) powerDao.findAll();
	}


	@Override
	public List<PowerEntity> findPowerListByRoleId(String roleId) {
		
		return powerDao.findPowerListByRoleId(roleId);
	}


	@Override
	public List<PowerEntity> noFindPowerListByRoleId(List<PowerEntity> listRolePower,
			List<PowerEntity> allListRolePower) {
		//集合必须要有内容
		 if(null!=listRolePower&&!listRolePower.isEmpty()){
			 //不拥有=所有-拥有
			 for(int i=0;i<listRolePower.size();i++){
				 String pid=listRolePower.get(i).getPid();
				 for(int j=0;j<allListRolePower.size();j++){
					 String allPid=allListRolePower.get(j).getPid();
					 if(pid.equals(allPid)){
						 allListRolePower.remove(j);
						 break;
					 }
				 }
			 }
		 }
		
		return allListRolePower;
	}


	@Override
	public List<PowerDto> findPowerDtoListByUserNameAndPassword(String userName, String password,String sysTag) {
		List<Object[]> list=	powerDao.findPowerDtoListByUserNameAndPassword(userName, password,sysTag.trim());
		
		List<PowerDto>  listdto=null;
		if(null!=list&&!list.isEmpty()){
		       listdto=new ArrayList<>();
		     for (Object[] objs : list) {
				PowerDto dto=new PowerDto();
				dto.setUserName(objs[0].toString());
				dto.setPowerUri(objs[1].toString());
				//把List<Object[]> 数据放入到List<PowerDto>
				listdto.add(dto);
			}  
		       
		}
		return listdto;
	}


	@Override
	public List<PowerEntity> findAllListPower() {
		// TODO Auto-generated method stub
		return (List<PowerEntity>) powerDao.findAll();
	}

	
	@Transactional
	@Override
	public void delPower(String pid) {
		// TODO Auto-generated method stub
		
		powerDao.delete(pid);
		
	}

	
	
}
