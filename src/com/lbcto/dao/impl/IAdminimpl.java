package com.lbcto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lbcto.dao.IAdmin;
import com.lbcto.entity.Level;
import com.lbcto.entity.User;
import com.lbcto.util.DBHelper;
import com.lbcto.vo.UserInfoVO;

/**
 * 
 * @描述   用一句话描述一下这个类或方法
 * @作者 lubiao
 * @时间 2017年8月3日-上午10:04:28
 *
 */
public class IAdminimpl implements IAdmin{

	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement preparedStatement = null;
	private static Connection connection=DBHelper.getConnection();
	
	

	@Override
	public Integer getLogin(String name, String password) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		Integer count = null;
		try {
			String sql = "select count(1) from admin where loginId =? and loginPwd=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				count=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(preparedStatement!=null){
						preparedStatement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
	}
	
	@Override
	public List<User> getUserInfo() {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		List<User> list = new ArrayList<>();
		try {
			statement=connection.createStatement();
			String sql = "select * from userInfo";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				User user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserPsw(resultSet.getString("userPwd"));
				user.setUserLevelId(resultSet.getInt("levelId"));
				user.setEmail(resultSet.getString("email"));
				user.setOnlineDay(resultSet.getInt("onLineDay"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(statement!=null){
						statement.close();
					}
					if(resultSet!=null){
						resultSet.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	@Override
	public Integer updateOnlineDayById(int userId,int newday) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		Integer count = null;
		try {
			String sql = "update userInfo set onLineDay = ? where userId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newday);
			preparedStatement.setInt(2, userId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(preparedStatement!=null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return count;
		
		
		
	}

	@Override
	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		Integer count = null;
		try {
			String sql = "insert into userInfo values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserPsw());
			preparedStatement.setInt(3, user.getUserLevelId());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getOnlineDay());
			
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(statement!=null){
					statement.close();
				}
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return count;
		
	}

	@Override
	public Integer updateLevelByOnlineDay(int onlineday) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		
		
		
		
		
		return null;
	}

	@Override
	public Integer deleteUserInfoById(int userId) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		Integer count = null;
		
		try {
			String sql = "delete from userInfo where userId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(statement!=null){
					statement.close();
				}
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return count;
	}

	@Override
	public Level getLevelNameById(int levelId) {
		// TODO Auto-generated method stub
		if(connection==null){
			return null;
		}
		Level level = new Level();
		try {
			String sql = "select * from level where levelId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, levelId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				level.setLevelId(levelId);
				level.setLevelName(resultSet.getString("levelName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(statement!=null){
					statement.close();
				}
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return level;
	}
	
	


	@Override
	public List<UserInfoVO> getUserInfoVOList() {
		// TODO Auto-generated method stub
		List<UserInfoVO> list = new ArrayList<>();
		for(int i =0;i<getUserInfo().size();i++){
			UserInfoVO userInfoVO = new UserInfoVO();
			userInfoVO.setId(getUserInfo().get(i).getUserId());
			userInfoVO.setName(getUserInfo().get(i).getUserName());
			userInfoVO.setLevel(getLevelNameById(getUserInfo().get(i).getUserLevelId()).getLevelName());
			userInfoVO.setEmail(getUserInfo().get(i).getEmail());
			userInfoVO.setOnlineDay(getUserInfo().get(i).getOnlineDay());
			list.add(userInfoVO);
		}
		return list;
	}
	
	

	//测试
	public static void main(String[] args) {
		IAdmin iadmin = new IAdminimpl();
		/*for (UserInfoVO UserInfoVO : iadmin.getUserInfoVOList()) {
			System.out.println(UserInfoVO);
		}*/
		
		System.out.println(iadmin.deleteUserInfoById(3));
		
	}

}
