package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.BookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import entity.Book;

public class BookAction extends ActionSupport{
	
	private Book b;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private String username = (String) session.getAttribute("username");
	private String msg="";
	private BookService bookservice;
	private Book up;
	
	public Book getBookById(int id){
		return bookservice.getBookById(id);
	}
	
	
	
	
	public Book getUp() {
		return up;
	}

	public void setUp(Book up) {
		this.up = up;
	}

	public BookService getBookservice() {
		return bookservice;
	}

	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String index(){
		System.out.println(username);
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			List<Book> allbooks = bookservice.getAllBooks(username);
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.setValue("#request.allbooks", allbooks);
			System.out.println("进入主界面");
			return "index";
		}
	}
	
	
	public String addbook(){
		String price = String.valueOf(b.getPrice());
		System.out.println(price);
		if(b.getBookname().equals("") || b.getBookname().equals(null)){
			msg="书名不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(b.getAuthor().equals("") || b.getAuthor().equals(null)){
			msg="作者名不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(b.getDamage().equals(null) || b.getDamage().equals("")){
			msg="破损度不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(price.equals("0.0") ||price.equals("") || price.equals(null)){
			msg="价格不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			b.setUsername(username);
			boolean flag = bookservice.addBook(b);
			if(flag==false){
				msg="你已经发布过这本书了！";
				session.setAttribute("msg", msg);
				return "input";
			}else{
				return "success";
			}
		}
	}
	public String mybooks(){
 		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			List<Book> mybooks = bookservice.getMyBooks(username);
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.setValue("#request.mybooks", mybooks);
			System.out.println("进入我的书库页面");
			return "mybooks";
		}
	}
	
	public String deletemybook(){
		String bid = request.getParameter("bid");
		System.out.println("要删除的书籍编号为："+bid);
		int id = Integer.parseInt(bid);
		Book b = getBookById(id);
		if(b.getStatus().equals("已卖出")){
			msg="该书已卖出，无法删除"
					+ "";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			bookservice.deleteBook(id);
			return "success";
		}
	}
	
	public String updatemybook(){
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			ValueStack vs = ActionContext.getContext().getValueStack();
			String upid = request.getParameter("upid");
			int id = Integer.parseInt(upid);
			Book b = bookservice.getBookById(id);
			vs.setValue("#session.upbook", b);
			vs.setValue("#session.upid",id);
			System.out.println("进入我的书库页面");
			return "success";
		}
	}
	
	public String updatebooksuccess(){
		String price = String.valueOf(up.getPrice());
		ValueStack vs = ActionContext.getContext().getValueStack();
		int id = (Integer) vs.findValue("#session.upid");
		Book b = bookservice.getBookById(id);
		if(up.getBookname().equals("") || up.getBookname().equals(null)){
			msg="书名不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(up.getAuthor().equals("") || up.getAuthor().equals(null)){
			msg="作者名不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(up.getDamage().equals(null) || up.getDamage().equals("")){
			msg="破损度不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(price.equals("") || price.equals(null)){
			msg="价格不能为空！请填写完整！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(b.getStatus().equals("已卖出")){
			msg="该书已卖出，无法修改";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			
			bookservice.updateBook(id, up);
			return "success";
		}
	}
	
	


	

}
