package service.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.Book;
import entity.Order;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userdao ; //= new UserDaoImpl() 
	
	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public boolean addUser(User user) {
		return userdao.addUser(user); 
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return userdao.login(username, password); 
	}

	@Override
	public void updateUser(String username,User user) {
		userdao.updateUser(username,user);
	}

	@Override
	public User getUserById(int id) {
		return userdao.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userdao.getUserByUsername(username);
	}

	@Override
	public void updatePsw(String username, String password) {
		userdao.updatePsw(username, password);
	}



}
