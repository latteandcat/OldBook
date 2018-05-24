package dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.HibernateUtil;
import dao.UserDao;
import entity.Book;
import entity.Order;
import entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public boolean addUser(User user) {
		String username=user.getUsername();
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from User u where u.username='"+username+"'");
		List<User> users = query.list(); 
		boolean flag=false;
		if(users.size()>0){  
        	flag = false;
        }else{
        	User u = new User();
        	u.setUsername(user.getUsername());
        	u.setPassword(user.getPassword());
        	u.setEmail(user.getEmail());
        	u.setContent(user.getContent());
        	u.setRegister_date(new Date());
        	session.save(u);
        	flag = true;
        } 
		tx.commit();
		return flag; 
	}


	@Override
	public boolean login(String username, String password) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from User u where u.username='"+username+"' and u.password= '"+password+"'");
		List<User> user = query.list();  
        //判断是否有查询结果，换句话说就是判断用户是否存在  
		boolean flag=false;
        if(user.size()>0){  
        	flag = true;
        }else{
        	flag = false;
        } 
        tx.commit();
        return flag;
	}


	@Override
	public void updateUser(String username,User user) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		User u = getUserByUsername(username);
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setContent(user.getContent());
		session.update(u);
		Query query = session.createQuery("from Book b where b.username='"+username+"'");
		List<Book> books = query.list(); 
		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);
			b.setUsername(user.getUsername());
			BookDaoImpl bookdao = new BookDaoImpl();
			bookdao.updateBook2(b.getId(), b);
		}
		tx.commit();
	}


	@Override
	public User getUserByUsername(String username) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from User u where u.username='"+username+"'");
		List<User> users = query.list();  
		User u=users.get(0);
		return u;
	}


	@Override
	public User getUserById(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from User u where u.id='"+id+"'");
		List<User> users = query.list();  
		User u=users.get(0);
		return u;
	}


	@Override
	public void updatePsw(String username, String password) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		User u = getUserByUsername(username);
		u.setPassword(password);
		session.update(u);
		tx.commit();
	}



}
