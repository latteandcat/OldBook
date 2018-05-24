package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.UserService;
import service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import entity.User;

public class UserAction extends ActionSupport {
	
	private String username;
	private String password;
	private String newpassword;
	private String oldpassword;
	private String password2;
	private UserService userservice;
	private User u;
	private User up;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private String msg="";
	
	
	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUp() {
		return up;
	}

	public void setUp(User up) {
		this.up = up;
	}
	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String login(){
		System.out.println(username);
		System.out.println(password);
		System.out.println(userservice);
		if(username.equals("") ||username.equals(null) || password.equals("")||password.equals(null)){
			msg="用户名、密码不能为空！";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			boolean flag = userservice.login(username, password);
			if(flag){
				session.setAttribute("username", username);
				ActionContext a = ActionContext.getContext();
				ValueStack   vs = a.getValueStack();
				User user = userservice.getUserByUsername(username);
				vs.setValue("#session.user", user);
				return "success";
			}else{
				msg="登录失败！";
				session.setAttribute("msg", msg);
				return "input";
			}
		}
	}
	
	public String regist(){
		if(u.getUsername().equals("")|| u.getUsername().equals(null) || u.getPassword().equals("") ||u.getPassword().equals(null) || u.getEmail().equals("") ||u.getEmail().equals(null) ){
			msg="用户名、密码、邮箱不能为空";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			boolean flag = userservice.addUser(u);
			if(flag){
				return "success";
			}else{
				msg="注册失败！";
				session.setAttribute("msg", msg);
				return "input";
			}
		}
		
	}
	
	public String updatemes(){
		System.out.println(up.getUsername()+"dd");
		if(up.getUsername().equals(null) || up.getUsername().equals("") || up.getEmail().equals("") ||up.getEmail().equals(null) ){
			msg="修改后用户名、邮箱不能为空";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String name=(String) session.getAttribute("username");
			userservice.updateUser(name,up);
			session.setAttribute("username", up.getUsername());
			ActionContext a = ActionContext.getContext();
			ValueStack   vs = a.getValueStack();
			User user = userservice.getUserByUsername(up.getUsername());
			vs.setValue("#session.user", user);
			return "success";
		}
	}
	
	public String updatepsw(){
		String name = (String) session.getAttribute("username");
		User uu = userservice.getUserByUsername(name);
		System.out.println(uu.getPassword());
		System.out.println(oldpassword);
		System.out.println(newpassword);
		System.out.println(password2);
		if(oldpassword.equals("") || oldpassword.equals(null)){
			msg="原密码不能为空！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(uu.getPassword().equals(oldpassword)==false){
			msg="原密码错误！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(newpassword.equals("") || newpassword.equals(null) ){
			msg="新密码不能为空！";
			session.setAttribute("msg", msg);
			return "input";
		}else if(newpassword.equals(password2)==false){
			
			msg="两次输入密码不一致！";
			session.setAttribute("msg", msg);
			return "input";
		}else{
			userservice.updatePsw(name, newpassword);
			return "success";
		}
	}

	public String otherusermes() throws UnsupportedEncodingException{
		String name = request.getParameter("oname");
		String s = new String(name.getBytes("iso-8859-1"),"utf-8");
		System.out.println(s);
		User ou = userservice.getUserByUsername(s);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#request.ou", ou);
		return "success";
	}

}
