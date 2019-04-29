package com.lovo.boot.outController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lovo.boot.bean.PowerDto;
import com.lovo.boot.bean.PowerDtoReslut;
import com.lovo.boot.bean.PowerEntity;
import com.lovo.boot.bean.RoleEntity;
import com.lovo.boot.service.IPowerService;
import com.lovo.boot.util.JSONChange;


@RestController
public class OutPowerController {

	@Autowired
	private IPowerService  powerService;
	
	
	
	
	
	@RequestMapping("{userName}/{password}/getListPowerDto")
	public List<PowerDto> getListPowerDto(@PathVariable("userName") String userName,@PathVariable("password")String password,@PathVariable("sysTag")String sysTag){
		
		return powerService.findPowerDtoListByUserNameAndPassword(userName, password,sysTag);
	}
	
	@RequestMapping("{userName}/{password}/{sysTag}/PowerDtoReslut")
	public PowerDtoReslut getPowerDtoReslut(@PathVariable("userName") String userName,@PathVariable("password")String password,@PathVariable("sysTag")String sysTag){
		
		List<PowerDto> list=  powerService.findPowerDtoListByUserNameAndPassword(userName, password,sysTag);
		PowerDtoReslut pd=new PowerDtoReslut();
		pd.setDto(list);
		return pd;
	}
	
	@RequestMapping("{powerStr}/{sysTag}/savaPower")
	public PowerEntity savaPower(@PathVariable("powerStr") String powerStr,@PathVariable("sysTag")String sysTag) throws JsonParseException, JsonMappingException, IOException {
		PowerEntity power = new PowerEntity();
		power = (PowerEntity) JSONChange.jsonToObj(power, powerStr);
		PowerEntity u = powerService.savaPower(power);
		return u;
	}
	
	
	
	    //查询出拥有的权限
	       @RequestMapping("findAllPower")
			public String findAllPower()throws JsonProcessingException{
				List<PowerEntity> list= powerService.findAllListPower();
				String listJson = JSONChange.objToJson(list);
				System.out.println(listJson);
				
			
				   return listJson;
			}  
}
