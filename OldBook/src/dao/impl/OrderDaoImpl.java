package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.HibernateUtil;
import dao.OrderDao;
import entity.Book;
import entity.Order;


public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{
	@Override
	public List<Order> getMySaleOrder(String name) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Order o where o.salername='"+name+"' and status !='1'  ");
		List<Order> Orders = query.list();
		tx.commit();
		return Orders;
	}


	@Override
	public List<Order> getMyBuyOrder(String name) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Order o where o.buyername='"+name+"' and status !='1'  ");
		List<Order> r = query.list();
		System.out.println(r.size());
		tx.commit();
		return r;
	}


	@Override
	public void addOrder(Order order) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(order);
		tx.commit();
	}


	@Override
	public void ensureOrder(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Order or = getOrderById(id);
		or.setStatus("1");
		session.update(or);
		tx.commit();
	}


	@Override
	public void cancelOrder(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Order or = getOrderById(id);
		session.delete(or);
		tx.commit();
	}

	@Override
	public void payorder(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Order or = getOrderById(id);
		or.setMoneystatus("1");
		session.update(or);
		tx.commit();
	}

	@Override
	public Order getOrderById(int id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Order b where b.id='"+id+"'");
		List<Order> orders = query.list();  
		Order o=orders.get(0);
		return o;
	}


	@Override
	public List<Order> getMyOldSaleOrder(String name) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Order o where o.salername='"+name+"' and status ='1' and moneystatus= '1' ");
		List<Order> Orders = query.list();
		tx.commit();
		return Orders;
	}


	@Override
	public List<Order> getMyOldBuyOrder(String name) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		Query query = session.createQuery("from Order o where o.buyername='"+name+"' and status ='1' and moneystatus= '1' ");
		List<Order> r = query.list();
		System.out.println(r.size());
		tx.commit();
		return r;
	}


	
}
