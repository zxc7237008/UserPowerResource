package com.lovo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lovo.boot.BootMain;
import com.lovo.boot.bean.PowerEntity;
import com.lovo.boot.bean.RoleEntity;
import com.lovo.boot.bean.UserBean;
import com.lovo.boot.bean.UserEntity;
import com.lovo.boot.service.IPowerService;
import com.lovo.boot.service.IRolePowerService;
import com.lovo.boot.service.IRoleService;
import com.lovo.boot.service.IRoleUserService;
import com.lovo.boot.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BootMain.class)
public class T {

	/*@Autowired
	private IUserService userService;
	@Autowired
	private IPowerService powerService;
	
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IRoleUserService roleUserService;
	@Autowired
	private IRolePowerService rolePowerService;
	
	@Autowired
	UserBean userBean;

	@Test
	public void test(){
		System.out.println(userBean.getUserName());
		 List<UserEntity> list=	userService.findAllUser();
		 for (UserEntity u : list) {
			System.out.println(u.getUname());
		}
	}
	@Test
	public void roleUserList(){
		//根据角色ID查询出拥有的用户
				List<UserEntity> listUser=	userService.getUserListByRoleId("4028815e6a05fb5d016a05fbc94d0000");
				List<UserEntity> nolistUser=		userService.getNOUserListByRoleId(listUser);
				System.out.println(nolistUser.size());
	}

	@Test
	public void savaUser(){
    UserEntity user=new UserEntity();
       user.setUname("张三");
       user.setUpasss("123456");
       user.setUtel("18200121227");
       user.setUmaildox("1084@qq.com");
        userService.savaUser(user);
       
     }*/
	/*@Test
	public void getUser() {
		 UserEntity  u=	userService.getUserById("1");
		 System.out.println(u.getUsername());
	}
	@Test
	public void getRole() {
			RoleEntity  u1=	roleService.getRoleById("1");
		 System.out.println(u1.getRname());
	}*/

	/*@Test
	public void savaPower(){
		PowerEntity power=new PowerEntity();
		power.setPname("管理员");
		power.setSysTag("1");
		power.setPuri("/add");
		powerService.savaPower(power);
  }
	
	
	@Test
	public void savaRole(){
		RoleEntity role=new RoleEntity();
		role.setRoleName("周经理");
		role.setRoleDescribe("管理人员");
		roleService.savaRole(role);
  }*/
	
	/*@Test
	public void findAllUser(){
		List<UserEntity> list=	userService.findAllUser();
		 for (UserEntity u : list) {
			System.out.println(u.getUname());
		}
		
	}

	@Test
	public void getPowerList(){
		 List<PowerEntity>list=	powerService.getPowerList();
		 for (PowerEntity p : list) {
			System.out.println(p.getPname());
		}
		
	}*/
	
/*
	@Test
	public void findAllListRole(){
		 List<RoleEntity>list=roleService.findAllListRole();
		 for (RoleEntity r : list) {
			System.out.println(r.getRoleName());
		}
		
	}
	@Test
	public void savaRoleUser(){
		roleUserService.andUserList("1,2,3,", "1");
		
     }
	 @Test
	 //根据角色ID添加出拥有的权限
	public void savaRolePower(){
		rolePowerService.savaRolePower("2", "1,2,3,4,");
		
     }*/
	
	
	/*
	@Test
	//根据角色ID查询出拥有的用户
	 public void roleUserList(){
	   List<UserEntity> listUser=userService.getUserListByRoleId("2");
	   List<UserEntity> nolistUser=		userService.getNOUserListByRoleId(listUser);
		System.out.println(nolistUser.size());
	}
	*/
	/*@Test
	//根据角色ID查询出拥有的用户
	 public void delroleUser(){
	   List<UserEntity> listUser=userService.getUserListByRoleId("2");
	   List<UserEntity> nolistUser=		userService.getNOUserListByRoleId(listUser);
		System.out.println(nolistUser.size());
	}*/
	
	
	/*@Test
	 //根据角色ID删除出拥有的权限
	public void delRolePower(){
		rolePowerService.delRolePower("2", "1,2,3");
		
     }*/
}
