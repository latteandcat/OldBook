package proxy;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.aop.MethodBeforeAdvice;

import action.JspAction;

public class EnsureUserSession implements MethodBeforeAdvice{
	

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username.equals("") || username.equals(null)){
			System.out.println("当前用户为非法登录！");
		}else{
			System.out.println("当前登录用户为："+username);
		}
	}

}
