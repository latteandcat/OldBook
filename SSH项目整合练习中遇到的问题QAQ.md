## SSH项目整合练习中遇到的问题QAQ

#### 一：用session存放用户信息的两种方法

```java
1、 用值栈存取值

//创建值栈对象           

ActionContext ctx = ActionContext.*getContext*(); 

ValueStack vs = ctx.getValueStack();

vs.setValue("#request.namename", "zzz");

vs.setValue("#session.zzzAge", 38); 

String name_request_vs = (String)vs.findValue("#request.namename");

int zzzAge = (Integer) vs.findValue("#session.zzzAge");

二、 用request存取值 

//利用工具类获得reqeust

HttpServletRequest request = ServletActionContext.*getRequest*();

//向session中存值

HttpSession session = request.getSession(); 

session.setAttribute("zswAge", 18);

//向request中存值

request.setAttribute("name", "zsw");

//从request中取值

String name_request = (String) request.getAttribute("name");

//从session中取值

int zswAge = (Integer) session.getAttribute("zswAge");
```

#### 二：SSH中JSP页面传值到action出现中文乱码的情况

客户端浏览器向服务器提交中文参数的时候，分为两种情况：点击href链接和提交表单。

1、点击href链接  
```
http://127.0.0.1/Test/test.jsp?name=黄河  
```

虽然在web.xml中进行配置的时候，使用了过滤器对编码进行转换，但是过滤器在这里并不起作用。

这就需要在JSP页面中进行转码。   
```
<a href='http://127.0.0.1/Test/test.jsp?name=<%= URLEncoder.encode("黄河","gb2312")%>' >链接</a>  
```

在服务器端进行接收的时候，需要对字符进行解码 (如果前台后台都已经设置为utf-8,即可使用这种方式转码获取中文即可)   

```java
String str = request.getParameter("name");    
String name = new String(str.getBytes("iso-8859-1"),"gb2312"); 
```

这样，System.out.println(name);输出的就是中文字符"黄河"

2、提交表单     对于文本框类型的表单组件提交中文参数的时候，使用web.xml中配置的过滤器就可以了。    
注意，form表单的提交方式必须是post方式，如果是get方式的话，即使经过了过滤器依然是乱码  


```html
<input type="text" name="name">中国</input>  
<select name="name2">
	<option value="中国" select="select">中国</option>
</select>  
```

在服务器端打印出的结果都是中文字符"中国"   
System.out.println(request.getParameter("name1"));   
System.out.println(request.getParameter("name3"));



####三：关于css 、JS  图片等静态内容被struts2拦截器拦截显示不出来的问题

网上大部分的解决方案都是在struts2的配置文件里加上下面这句话

plugins放所有静态文件的地方

```xml
<constant name="struts.action.excludePattern" value="/plugins/.*?" />
```

但我最终解决的时候好像这句话也没起到作用，仅供参考ouo

```html
<!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/plugins/bootstrap/css/bootstrap.min.css" 		rel="stylesheet">
<!-- css -->
    <link href="<%=request.getContextPath()%>/plugins/css/index.css" rel="stylesheet">
```

在路径里加上这句<%=request.getContextPath()%>也许会有奇效QAQ

背景图片显示不出来也加上

```html
<div style="background-image: url('<%=request.getContextPath()%>/plugins/image/jian.png');">
```



####四：关于strtus2和spring3的整合问题

我在整合这两个框架的时候出现了注入service之后还是空值的问题，在Action new 了一下发现可以正常运行，经过查找发现，将struts2交给spring        的配置文件托管需要在struts的配置文件里加上下面这句话

```
<constant name="struts.objectFactory" value="spring"/>
```

再次运行之后service果然不是空值了

加入这句话之后有两种整合方式

(1) 将Struts的业务逻辑控制器类配置在Spring的配置文件中，Action中引用的业务类一并注入。

(这样的处理，必须将action类的scope配置成prototype)

```
<bean id="LoginAction" class="yaso.struts.action.LoginAction">  
	<property name="loginDao" ref="LoginDao"/>  
</bean>   
```

接着，在struts.xml或者等效的Struts2配置文件中配置Action时，指定<action>的class属性为Spring配置文件中相应bean的id或者name值。示例如下： 

```
<action name=”LoginAction” class=”LoginAction”>  
	<result name=”success”>/index.jsp</result>  
</action>   

```



 (2) 业务类在Spring配置文件中配置，Action不需要配置，Struts2的Action像没有整合Spring之前一样配

置，<action>的class属性指定业务逻辑控制器类的全限定名。  Action中引用的业务类不需要自己去初始

化，Struts2的Spring插件会使用bean的自动装配将业务类注入进来，其实Action也不是Struts2创建的，

而是Struts2的Spring插件创建的。默认情况下，插件使用by name的方式装配，

可以通过增加Struts2常量来修改匹配方式：设置方式为：

struts.objectFactory.spring.autoWire = typeName，

可选的装配参数如下：

name:相当于spring配置的autowrie="byName"(默认)

type:相当于spring配置的autowrie="byType"

auto:相当于spring 配置的autowrie="autodetect"

constructor: 相当于spring配置的autowrie="constructor"

就到这里，学生党，总的来说大部分地方还是比较迷的，欢迎您的指教，谢谢
--------------------------

