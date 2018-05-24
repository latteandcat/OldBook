package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import entity.User;

public class JspAction extends ActionSupport{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	public String hello(){
		session.setAttribute("username", "");
		System.out.println("进入欢迎界面");
		return "hello";
	}
	
	public String login(){
		System.out.println("进入登录页面");
		return "login";
		
	}
	public String regist(){
		System.out.println("进入注册页面");
		return "regist";
	}
	public String mymes(){
		String username = (String)session.getAttribute("username");
		
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			System.out.println("进入我的信息页面");
			return "mymes";
		}
	}
	
	
	public String addbook(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			System.out.println("进入发布书评页面");
			return "addbook";
		}
	}
	
	public String updatemes(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			System.out.println("进入修改个人信息页面");
			return "updatemes";
		}
	}
	
	public String updatepsw(){
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			return "failed";
		}else{
			System.out.println("进入修改密码页面");
			return "updatepsw";
		}
	}

}
