package service.impl;

import java.util.List;

import dao.OrderDao;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderdao;

	public OrderDao getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(OrderDao orderdao) {
		this.orderdao = orderdao;
	}

	@Override
	public void addOrder(Order order) {
		orderdao.addOrder(order);
	}

	@Override
	public void cancelOrder(int id) {
		orderdao.cancelOrder(id);
	}

	@Override
	public void ensureOrder(int id) {
		orderdao.ensureOrder(id);
	}

	@Override
	public Order getOrderById(int id) {
		return orderdao.getOrderById(id);
	}

	@Override
	public List<Order> getMySaleOrder(String salername) {
		return orderdao.getMySaleOrder(salername);
	}

	@Override
	public List<Order> getMyBuyOrder(String buyername) {
		return orderdao.getMyBuyOrder(buyername);
	}

	@Override
	public List<Order> getMyOldSaleOrder(String salername) {
		return orderdao.getMyOldSaleOrder(salername);
	}

	@Override
	public List<Order> getMyOldBuyOrder(String buyername) {
		return orderdao.getMyOldBuyOrder(buyername);
	}

	@Override
	public void payOrder(int id) {
		orderdao.payorder(id);
	}

}
