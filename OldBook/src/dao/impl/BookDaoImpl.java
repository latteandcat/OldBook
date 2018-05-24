package dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.HibernateUtil;
import dao.BookDao;
import entity.Book;
import entity.User;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao{
	

	@Override
	public List<Book> getAllBooks(String username) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Book b where b.username!='"+username+"' and status = '未卖出'");
		List<Book> books = query.list();
		tx.commit();
		return books;
	}

	@Override
	public List<Book> getMyBooks(String username) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Book b where b.username='"+username+"'");
		List<Book> books = query.list();
		tx.commit();
		return books;
	}

	@Override
	public boolean addBook(Book book) {
		String bookname = book.getBookname();
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Book b where b.bookname='"+bookname+"' and username= '"+book.getUsername()+"'");
		List<Book> books = query.list(); 
		boolean flag=false;
		if(books.size()>0){  
			tx.commit();
        	flag = false;
        }else{
        	Book b = new Book();
        	b.setBookname(bookname);
        	b.setAuthor(book.getAuthor());
        	b.setDamage(book.getDamage());
        	b.setContent(book.getContent());
        	b.setPrice(book.getPrice());
        	b.setAddtime(new Date());
        	b.setUsername(book.getUsername());
        	b.setStatus("未卖出");
        	session.save(b);
        	tx.commit();
        	flag = true;
        } 
		return flag; 
	}

	@Override
	public void deleteBook(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Book book = getBookById(id);
		session.delete(book);
		tx.commit();
	}

	@Override
	public Book getBookById(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Book b where b.id='"+id+"'");
		List<Book> books = query.list();  
		Book b=books.get(0);
		return b;
	}

	@Override
	public void updateBook(int id, Book up) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Book b = getBookById(id);
		b.setBookname(up.getBookname());
    	b.setAuthor(up.getAuthor());
    	b.setDamage(up.getDamage());
    	b.setContent(up.getContent());
    	b.setPrice(up.getPrice());
    	session.update(b);
    	tx.commit();
	}
	@Override
	public void updateBook2(int id, Book up) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Book b = getBookById(id);
		b.setBookname(up.getBookname());
    	b.setAuthor(up.getAuthor());
    	b.setDamage(up.getDamage());
    	b.setContent(up.getContent());
    	b.setPrice(up.getPrice());
    	session.update(b);
	}

}
