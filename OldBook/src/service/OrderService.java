package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	public void addOrder(Order order);
	public void cancelOrder(int id);
	public void ensureOrder(int id);
	public void payOrder(int id);
	public List<Order> getMySaleOrder(String  salername);
	public List<Order> getMyBuyOrder(String buyername);
	public Order getOrderById(int id);
	public List<Order> getMyOldSaleOrder(String  salername);
	public List<Order> getMyOldBuyOrder(String buyername);
}
