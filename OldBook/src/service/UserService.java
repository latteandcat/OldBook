package service;

import java.util.List;

import entity.Book;
import entity.Order;
import entity.User;

public interface UserService {
	public boolean addUser(User user);  
    public boolean login(String username,String password);
    public void updateUser( String username,User user);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public void updatePsw(String username,String password);
}
