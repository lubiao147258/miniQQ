package com.lbcto.dao;

import java.util.List;

import com.lbcto.entity.Level;
import com.lbcto.entity.User;
import com.lbcto.vo.UserInfoVO;

public interface IAdmin {
	
	Integer getLogin(String name,String password);//判断用户登录

	List<User> getUserInfo();  //获取用户的信息
	
	Integer updateOnlineDayById(int userId,int newday);   //根据ID修改用户在线天数
	
	Integer addUser(User user);	//添加用户
	
	Integer updateLevelByOnlineDay(int onlineday);  //通过判断用户在线天数自动更新用户等级
	
	Integer deleteUserInfoById(int userId);		//根据删除用户
	
	Level getLevelNameById(int levelId);			//通过ID返回admin对象
	
	List<UserInfoVO> getUserInfoVOList();
	
}
