package dao;

import java.util.List;

import entity.Order;

public interface OrderDao {
	public void addOrder(Order order);
	public void cancelOrder(int id);
	public void ensureOrder(int id);
	public void payorder(int id);
	public List<Order> getMySaleOrder(String name);
	public List<Order> getMyBuyOrder(String name);
	public Order getOrderById(int id);
	public List<Order> getMyOldSaleOrder(String name);
	public List<Order> getMyOldBuyOrder(String name);

}
