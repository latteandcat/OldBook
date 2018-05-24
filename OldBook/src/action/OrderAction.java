package action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.OrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import dao.impl.BookDaoImpl;
import entity.Book;
import entity.Order;

public class OrderAction extends ActionSupport{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private String username = (String) session.getAttribute("username");
	private String msg="";
	private Order o;
	private OrderService orderservice;
	private BookDaoImpl bookdao = new BookDaoImpl();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Order getO() {
		return o;
	}
	public void setO(Order o) {
		this.o = o;
	}
	public OrderService getOrderservice() {
		return orderservice;
	}
	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}
	
	public String addorder(){
		String bid = request.getParameter("bid");
		int b_id = Integer.parseInt(bid);
		Book b = bookdao.getBookById(b_id);
		b.setStatus("已卖出");
		bookdao.updateBook(b_id, b);
		Order o = new Order();
		o.setBuyername(username);
		o.setSalername(bookdao.getBookById(b_id).getUsername());
		o.setStatus("0");
		o.setMoneystatus("0");
		o.setOrdertime(new Date());
		o.setBook(bookdao.getBookById(b_id));
		orderservice.addOrder(o);
		return "success";
	}
	
	public String myorder(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			ValueStack vs = ActionContext.getContext().getValueStack();
			List<Order> buy = orderservice.getMyBuyOrder(username);
			vs.setValue("#request.mybuy", buy);
			System.out.println("进入我的订单页面");
			return "myorder";
		}
	}
	
	public String mysale(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			ValueStack vs = ActionContext.getContext().getValueStack();
			List<Order> sale = orderservice.getMySaleOrder(username);
			vs.setValue("#request.mysale", sale);
			System.out.println("进入我卖的书页面");
			return "mysale";
		}
	}
	
	public String oldorder(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			ValueStack vs = ActionContext.getContext().getValueStack();
			List<Order> buy = orderservice.getMyOldBuyOrder(username);
			vs.setValue("#request.myoldbuy", buy);
			System.out.println("进入历史订单页面");
			return "oldorder";
		}
		
	}
	
	public String myoldsale(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			ValueStack vs = ActionContext.getContext().getValueStack();
			List<Order> sale = orderservice.getMyOldSaleOrder(username);
			vs.setValue("#request.myoldsale", sale);
			System.out.println("进入我以前卖的书页面");
			return "myoldsale";
		}
	}
	
	public String overorder(){
		String oid = request.getParameter("oid");
		int id = Integer.parseInt(oid);
		Order o = orderservice.getOrderById(id);
		String mo = o.getMoneystatus();
		if(mo.equals("0")){
			msg="您尚未支付，不能确认订单！请先进行支付！";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			orderservice.ensureOrder(id);
			return "success";
		}
		
	}
	
	public String cancelorder(){
		String oid = request.getParameter("oid");
		int id = Integer.parseInt(oid);
		Order o = orderservice.getOrderById(id);
		Book b = o.getBook();
		int bid = b.getId();
		b.setStatus("未卖出");
		orderservice.cancelOrder(id);
		bookdao.addBook(b);
		return "success";
	}
	
	public String payorder(){
		String oid = request.getParameter("oid");
		int id = Integer.parseInt(oid);
		orderservice.payOrder(id);
		return "success";
	}
	

}
