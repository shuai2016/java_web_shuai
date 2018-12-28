1. JavaWeb应用的概念

   1. JavaWeb应用由一组Servlet、HTML页、类、以及其它可以被绑定的资源构成。它可以在各种供应商提供的实现Servlet规范的Servlet容器中运行

2. Servlet容器的概念

   1. Servlet容器为JavaWeb应用提供运行时环境，它负责管理Servlet和JSP的生命周期，以及管理他们的共享数据

3. Tomcat的安装和配置

   1. 由于有了Sun的参与和支持，最新的Servlet和JSP规范总是能在Tomcat中得到体现

   2. 配置java_home或jre_home

   3. 任意目录都能启动关闭

      1. startup.bat的文件目录加path
      2. 创建catalina_home，值为tomcat根目录
      3. 使用`catalina run`在当前窗口启动，ctrl+c关闭

   4. tomcat管理程序：tomcat manager

   5. 加载其它路径应用程序

      1. Tomcat根目录\conf\Catalina\localhost下创建xml文件（hello.xml）

         ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <Context path="/test" docBase="实际的物理路径" reloadable="true"></Context>
         ```

      2. 实际访问路径：localhost:8080/hello/hello.jsp

         1. Tomcat5.5开始，在\conf\Catalina\localhost目录下创建XML配置文件来配置Web应用程序，Tomcat将以XML文件的文件名作为Web应用程序的上下文路径，因此在配置`<Context>`元素时，可以不使用path属性

4. JavaWeb开发的目录结构

   ```properties
   Hello
   |---WEB-INF
   |---|---classes
   |---|---|---包
   |---|---|---|---.class文件
   |---|---lib
   |---|---|---.jar文件
   |---|---web.xml
   |---index.jsp
   
   ```

5. 使用Eclipse开发JavaWeb项目

6. 第一个Servlet

   1. Servlet简介
      1. Java Servlet是和平台无关的服务器端组件，它运行在Servlet容器中。Servlet容器负责Servlet和客户的通信以及调用Servlet的方法，Servlet和客户的通信采用“请求/响应”的模式。
   2. Servlet可以完成的功能
      1. 创建并返回基于客户请求的动态HTML页面
      2. 创建可嵌入现有HTML页面中的部分HTML页面（HTML片段）
      3. 与其它服务器资源（如数据库或基于Java的应用程序）进行通信

7. Servlet的配置及生命周期方法

   1. Servlet的配置

      1. 创建一个Servlet接口的实现类

         ```java
         public class HelloServlet implements Servlet {
            @Override
            public void init(ServletConfig servletConfig) throws ServletException {
               System.out.println("init");
            }
            @Override
            public ServletConfig getServletConfig() {
               System.out.println("getServletConfig");
               return null;
            }
            @Override
            public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
               System.out.println("service");
            }
            @Override
            public String getServletInfo() {
               System.out.println("getServletInfo");
               return null;
            }
            @Override
            public void destroy() {
               System.out.println("destroy");
            }
         }
         ```

      2. 在web.xml中配置和映射

         ```xml
         <!-- 配置和映射Servlet -->
         <servlet>
             <!--Servlet 注册的名字-->
             <servlet-name>helloServlet</servlet-name>
             <!--Servlet 的全类名-->
             <servlet-class>xin.yangshuai.javaweb.servlet.HelloServlet</servlet-class>
         </servlet>
         <servlet-mapping>
             <!--需要和某一个servlet 节点的 servlet-name 字节点的文本节点一致-->
             <servlet-name>helloServlet</servlet-name>
             <!--映射具体的访问路径：/ 代表当前 WEB 应用的根目录-->
             <url-pattern>/hello</url-pattern>
         </servlet-mapping>
         ```

   2. Servlet容器的作用

      1. 可以创建Servlet，并调用Servlet 的相关生命周期方法
      2. JSP、Filter、Listener、Tag ... 相关的生命周期方法都是由Servlet容器来调用

   3. Servlet 生命周期的方法：都是由Servlet容器负责调用

      1. 构造器：第一次请求Servlet时，创建Servlet 的实例，调用构造器
         1. 这说明Servlet是单实例的
      2. init 方法：只被调用一次，在创建好实例后立刻被调用，用于初始化当前Servlet
      3. service：被多次调用，每次请求都会调用service方法，实际用于响应请求
      4. destroy：只被调用一次，在当前Servlet所在的 WEB 应用被卸载前调用，用于释放当前Servlet所占用的资源

   4. load-on-startup参数

      1. 配置在servlet节点中

         ```xml
         <servlet>
             <servlet-name>helloServlet</servlet-name>
             <servlet-class>xin.yangshuai.javaweb.servlet.HelloServlet</servlet-class>
             <load-on-startup>2</load-on-startup>
         </servlet>
         ```

      2. load-on-startup可以指定Servlet被创建的时机

         1. 若为负数，则在第一次请求时被创建
         2. 若为0或正数，则在当前WEB应用被Servlet容器加载时创建实例，且数值越小越早被创建

   5. Servlet容器响应客户请求的过程

      1. Servlet引擎检测是否已经装载并创建了该Servlet的实例对象。如果是，则直接执行第4步，否则，执行第2步
      2. 装载并创建该Servlet的一个实例对象：调用该Servlet的构造器
      3. 调用Servlet实例对象的init()方法
      4. 创建一个用于封装请求的ServletRequest对象和一个代表响应消息的ServletResponse对象，然后调用Servlet的service()方法并将请求和响应对象作为参数传递进去
      5. WEB应用程序被停止或重新启动之前，Servlet引擎将卸载Servlet，并在卸载之前调用Servlet的destory()方法

   6. Servlet的注册与运行

      1. Servlet程序必须通过Servlet容器来启动运行，并且储存目录有特殊要求，需要存储在<WEB应用程序目录>\WEB-INF\classes\目录中
      2. Servlet程序必须在WEB应用程序的web.xml文件中进行注册和映射其访问路径，才可以被Servlet引擎加载和被外界访问
      3. 一个\<servlet>元素用于注册一个Servlet，它包含有两个主要的子元素：\<servlet-name>和\<servlet-class>，分别用于设置Servlet的注册名称和Servlet的完整类名
      4. 一个\<servlet-mapping>元素用于映射一个已注册的Servlet的一个对外访问路径，它包含有两个子元素：\<servlet-name>和\<url-pattern>，分别用于指定Servlet的注册名称和Servlet的对外访问路径

   7. Servlet映射的细节

      1. 同一个Servlet可以被映射到多个URL上，即多个\<servlet-mapping>元素的\<servlet-name>子元素的设置值可以是同一个Servlet的注册名
      2. 在Servlet映射到的URL中也可以使用\*通配符，但是只能有两种固定的格式：
         1. 一种格式是“\*.扩展名”，
         2. 另一种格式是以正斜杠（/）开头并以“/*”结尾
         3. 注意：/\*.action不合法（既带斜杆又有扩展名的不合法）

8. ServletConfig对象

   1. 封装了Servlet的配置信息，并且可以获取ServletContext对象

   2. 配置Servlet的初始化参数

      ```xml
      <!-- 配置和映射Servlet -->
      <servlet>
          <!--Servlet 注册的名字-->
          <servlet-name>helloServlet</servlet-name>
          <!--Servlet 的全类名-->
          <servlet-class>xin.yangshuai.javaweb.servlet.HelloServlet</servlet-class>
          <!--配置Servlet的初始化参数-->
          <init-param>
              <!--参数名-->
              <param-name>user</param-name>
              <!--参数值-->
              <param-value>root</param-value>
          </init-param>
          <init-param>
              <param-name>password</param-name>
              <param-value>1230</param-value>
          </init-param>
          <load-on-startup>1</load-on-startup>
      </servlet>
      ```

      1. 要放到load-on-startup标签前面使用

   3. 获取初始化参数

      ```java
      @Override
      public void init(ServletConfig servletConfig) throws ServletException {
         System.out.println("HelloServlet's init");
      
         Enumeration<String> names = servletConfig.getInitParameterNames();
         while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println(name + " : " + value);
         }
      }
      ```

      1. getInitParameter(String var1)：获取指定参数名的初始化参数
      2. getInitParameterNames()：获取参数名组成的Enumeration\<String> 对象

   4. 获取Servlet的配置名称

      ```java
      String servletName = servletConfig.getServletName();
      System.out.println(servletName);
      ```

9. ServletContext

   1. 可以由ServletConfig获取

   2. 该对象代表当前WEB应用：可以认为ServletContext是当前WEB应用的一个大管家，可以从中获取到当前WEB应用的各个方面的信息

   3. ServletContext常用的方法

      1. 获取 WEB应用的初始化参数

         1. 配置当前WEB应用的初始化参数，可以为所有的Servlet所获取

            ```xml
            <!--配置当前WEB应用的初始化参数-->
            <context-param>
                <param-name>driver</param-name>
                <param-value>com.mysql.jdbc.Driver</param-value>
            </context-param>
            
            <context-param>
                <param-name>jdbcUrl</param-name>
                <param-value>jdbc:mysql:///test</param-value>
            </context-param>
            ```

         2. 获取 WEB应用的初始化参数

            ```java
            ServletContext servletContext = servletConfig.getServletContext();
            
            Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
            while (initParameterNames.hasMoreElements()){
                String name = initParameterNames.nextElement();
                String value = servletContext.getInitParameter(name);
                System.out.println("ServletContext, " + name + " : " + value);
            }
            ```

      2. 获取当前WEB应用的某一文件在服务器上的绝对路径，而不是部署前的路径

         ```java
         String realPath = servletContext.getRealPath("/test.txt");
         System.out.println("realPath :" + realPath);
         ```

         1. 实际该文件不一定真正存在

      3. 获取当前WEB应用的名称

         ```java
         String contextPath = servletContext.getContextPath();
         System.out.println("contextPath : " + contextPath);
         ```

      4. 获取当前WEB应用的某一个文件对应的输入流

         ```java
         InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
         System.out.println(resourceAsStream);
         ```

         1. 参数为以当前	WEB 应用根路径（“/”）开始路径

10. HTTP协议GET和POST请求

  1. HTTP简介
     1. WEB浏览器也WEB服务器之间的一问一答的交互过程必须遵循一定的规则，这个规则就是HTTP协议
     2. 超文本传输协议的简写，是TCP/IP协议集中的一个应用层协议，用于定义WEB浏览器与WEB服务器之间交换数据的过程以及数据本身的格式。
  2. GET请求
     1. 在浏览器地址输入某个URL地址或单击网页上的一个超链接时，浏览器发出的HTTP请求方式是GET
     2. 如果网页中的\<form>表单元素的method属性被设置为了“GET”，浏览器提交这个FORM表单时生成的HTTP请求消息的请求方式也为GET。
     	. 使用GET请求方式给WEB服务器传递参数的格式：  	http:/xxx/xx?name=lc&password=123
     4. 使用GET方式传送的数据量一般限制在1KB以下。
  3. POST请求
     1. POST请求方式主要用于向WEB服务器端程序提交FORM表单中的数据：form表单的method置为POST
     2. POST方式将各个表单字段元素及其数据作为HTTP消息的实体内容发送给WEB服务器，传送的数据量要比使用GET方式传送的数据量大得多。  

11. ServletRequest和ServletResponse

    1. 这个两个接口的实现类都是服务器给予实现的，并在服务器调用service方法时传入

12. ServletRequest

    1. 封装了请求信息，可以从中获取到任何的请求信息

    2. 获取请求参数：

       1. `String getParameter(String var1);`：根据请求参数的名字获取请求值
          1. 若请求参数有多个值（例如多选checkbox），该方法只能取到第一个提交的值，应使用getParameterValues方法
       2. `String[] getParameterValues(String var1);`：根据请求参数的名字，返回请求参数对应的字符串数组
       3. `Enumeration<String> getParameterNames();`：返回参数名对应的Enumeration对象，类似与ServletConfig（或ServletContext）的getInitParameterNames()方法
       4. `Map<String, String[]> getParameterMap();`：返回请求参数的键值对

    3. HttpServletRequest：是ServletRequest的子接口，针对于HTTP请求所定义，里边包含了大量获取HTTP请求相关的方法。

       ```java
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
       //获取请求的URI
       String requestURI = httpServletRequest.getRequestURI();
       //获取请求方法
       String method = httpServletRequest.getMethod();
       //若是一个GET请求，获取请求参数对应的那个字符串，即 ? 后的那个字符串。
       String queryString = httpServletRequest.getQueryString();
       //获取请求的Servlet的映射路径
       String servletPath = httpServletRequest.getServletPath();
       ```

13. ServletResponse

    1. 封装了响应信息，如果想给用户什么响应，具体可以是该接口的方法实现

    2. 常用方法

       ```java
       servletResponse.setContentType("application/msword");
       PrintWriter writer = servletResponse.getWriter();
       writer.print("Hello World !");
       ```

       1. `getWriter()`：返回PrintWriter 对象，调用该对象的print()方法，将把print()中的参数直接打印到客户的浏览器上
       2. `setContentType("application/msword");`：设置响应内容类型

    3. HttpServletResponse

       1. `void sendRedirect(String var1) `：请求重定向

14. GenericServlet

    1. 是一个Servlet，是Servlet接口和ServletConfig 接口的实现类，但是一个抽象类，其中的service方法为抽象方法
    2. 如果新建的Servlet程序直接继承GenericServlet会使开发更简洁
    3. 具体实现
       1. 在GenericServlet中声明了一个ServletConfig类型的成员变量，在`init(ServletConfig config) `方法中对其进行了初始化
       2. 利用servletConfig成员变量的方法实现了ServletConfig接口的方法
       3. 还定义了一个init()方法，在`init(ServletConfig config) `中对其进行调用，子类可以直接覆盖init()在其中实现对Servlet的初始化
       4. 不建议直接覆盖`init(ServletConfig config) `，因为如果忘记编写super.init(ServletConfig)，而且用了ServletConfig接口的方法，则会出现空指针异常。
       5. 新建的init()并非Servlet的生命周期方法，而init(ServletConfig)使生命周期相关的方法

15. HttpServlet

    1. 是一个Servlet，继承自GenericServlet，针对于HTTP协议所定制
    2. 在service()方法中直接把ServletRequest和ServletResponse转为HttpServletRequest和HttpServletResponse，并调用了重载的service(HttpServletRequest,HttpServletResponse)，在重载的service(HttpServletRequest,HttpServletResponse)方法中获取了请求方式：request.getMethod()，根据请求方式又创建了doXxx()方法（比如doGet，doPost）
    3. 实际开发中，直接继承HttpServlet，并根据请求方式覆写doXxx()方法即可。
    4. 好处：直接有针对性的覆盖doXxx()方法；直接使用HttpServletRequest和HttpServletResponse，不再需要强转

16. 小结及练习

17. JSP概述

18. JSP页面的9个隐含对象

19. JSP语法

20. 域对象的属性操作

21. 请求的转发和重定向

    1. 代码

       1. 转发

          ```java
          /**
           * 请求转发
           * 1. 调用 HttpServletRequest 的 getRequestDispatcher 方法获取 RequestDispatcher 对象
           * 2. 调用 RequestDispatcher 的 forward(request,response) 方法进行请求的转发
           */
          RequestDispatcher dispatcher = request.getRequestDispatcher("/second");
          dispatcher.forward(request,response);
          ```

       2. 重定向

          ```java
          /**
           * 请求重定向
           * 直接调用 response 的 sendRedirect 方法
           */
          response.sendRedirect("second");
          ```

    2. 本质区别

       1. 请求的转发值发出了一次请求，而重定向则发出了两次请求

    3. 具体区别

       1. 地址栏
          1. 转发：地址栏是初次发出请求的地址
          2. 重定向：地址栏不再是初次发出的请求地址，地址栏为最后响应的那个地址
       2. request对象
          1. 转发：在最终的Servlet中，request对象和中转的那个request是同一个对象
          2. 重定向：在最终的Servlet中，request对象和中转的那个request不是同一个对象
       3. 请求资源
          1. 转发：只能转发给当前WEB应用的资源
          2. 重定向：可以重定向到任何资源
       4. “/”
          1. 转发：/ 代表的是当前WEB应用的根目录
          2. 重定向：/ 代表的是当前WEB站点的根目录

22. JSP小结（1）

23. page指令

24. include指令

25. JSP标签

26. 中文乱码问题

27. JSP小结（2）

28. MVC设计模式

29. MVC案例之查询

30. MVC案例之删除

31. MVC案例之架构分析

32. MVC案例之DAO层设计

33. MVC案例之DAO层实现

34. MVC案例之多个请求对应一个Servlet

35. MVC案例之（模糊）查询

36. MVC案例之删除操作

37. MVC案例之小结（1）

38. MVC案例之新增Customer

39. MVC案例之修改思路分析

40. MVC案例之修改代码实现

41. MVC案例之通过配置切换底层存储源

42. MVC案例之小结（2）

43. Cookie概述

    1. 提出问题
       1. HTTP协议是一种无状态的协议
       2. 作为WEB服务器，必须能够采用一种机制来唯一地标识一个用户，同时记录该用户的状态

    2. 会话和会话状态

       1. 借助会话状态，WEB服务器能够把属于同一会话中的一系列的请求和响应过程关联起来

    3. 实现有状态的会话
       1. 浏览器对其发出的每个请求消息都进行标识，同一个会话中的请求消息都附带同样的标识号，这个标识号称之为会话ID（SessionID）
       2. 在Servlet规范中，常用以下两种机制完成会话跟踪
          1. Cookie
          2. Session

    4. Cookie机制
       1. 在客户端保持HTTP状态信息的方案
       2. Cookie是在浏览器访问WEB服务器的某个资源时，由WEB服务器在HTTP响应消息头中附带传送给浏览器的一个小文本文件
       3. 每次访问该WEB服务器时，都会在HTTP请求头中将这个Cookie回传给WEB服务器
       4. 底层实现原理：WEB服务器通过在HTTP响应消息中增加Set-Cookie响应头字段将Cookie信息发送给浏览器，浏览器则通过在HTTP请求消息中增加Cookie请求头字段将Cookie回传给WEB服务器
       5. 一个Cookie只能标识一种信息，它至少含有一个标识信息的名称（NAME）和设置值（VALUE）
       6. 一个WEB站点可以给一个WEB浏览器发送多个Cookie，一个WEB浏览器也可以存储多个WEB站点提供的Cookie
       7. 浏览器一般只允许存放300个Cookie，每个站点最多存放20个Cookie，每个Cookie的大小限制为4KB

    5. Cookie的发送

       1. 创建Cookie对象
       2. 设置最大时效
       3. 将Cookie放入到HTTP相应报头
          1. 默认是一个会话级别的cookie，存储在浏览器的内存中，用户退出浏览器后被删除
          2. 若希望浏览器将该cookie存储在磁盘上，则需要使用maxAge，并给出一个以秒为单位的时间。将最大时效设为0则表示浏览器立即删除该cookie，若为负数，表示不储存该Cookie
          3. HttpServletResponse的addCookie方法，将cookie插入到一个Set-Cookie HTTP响应报头中。由于这个方法并不修改任何之前指定的Set-Cookie报头，而是创建新的报头，因此将这个方法称为是addCookie，而非setCookie

    6. 会话cookie和持久cookie的区别

       1. 会话cookie，不设置过期时间，会话cookie一般不保存在硬盘上而保存在内存里。
       2. 如果设置里过期时间，浏览器会把cookie保存到硬盘上，关闭后再次打开浏览器，这些cookie依然有效直到超过设定的过期时间
       3. 存储在硬盘上的cookie可以在不同的浏览器进程间共享，比如两个IE窗口。而对于保存在内存的cookie，不同的浏览器有不同的处理方式

    7. Cookie相关的API

       ```java
       //1. 创建一个Cookie对象
       Cookie cookie = new Cookie("name","cookie001");
       //2. setMaxAge：单位：秒，值为0，表示立即删除；值为负数，表示不储存该Cookie；值为正数，表示该Cookie的存储时间
       cookie.setMaxAge(30);
       //3. 设置Cookie 的作用范围
       cookie.setPath(request.getContextPath());
       //4. 调用response的一个方法把Cookie传给客户端
       response.addCookie(cookie);
       //5. 从浏览器读取Cookie
       Cookie[] cookies = request.getCookies();
       ```

44. 利用Cookie进行自动登录

45. 利用Cookie显示最近浏览的商品

46. 设置Cookie的作用路径

    1. Cookie的默认作用范围
       1. 可以作用当前目录和当前目录的子目录，但不能作用于当前目录的上一级目录

    2. 设置Cookie的作用范围

       ```java
       Cookie cookie = new Cookie("cookiepath","cookiepathvalue");
       cookie.setPath(request.getContextPath());
       response.addCookie(cookie);
       ```

       1. 可以通过setPath方法来设置Cookie的作用范围
       2. setPath设置为项目应用的根目录时，注意要有项目名

47. Cookie小结

48. HttpSession概述

49. HttpSession的生命周期

50. HttpSession常用方法示例

51. HttpSessionURL重写

52. HttpSession小结（1）

53. HttpSession之简易购物车

54. JavaWeb中的相对路径和绝对路径

55. HttpSession之表单的重复提交

56. HttpSession之验证码

57. HttpSession小结（2）

58. 使用JavaBean

59. EL语法

60. EL详解

61. 简单标签的HelloWorld

62. 带属性的自定义标签

63. 带标签体的自定义标签

64. 带父标签的自定义标签

65. EL自定义函数

66. 简单标签小结

67. JSTL表达式操作

68. JSTL流程控制操作

69. JSTL迭代操作

70. JSTL_URL操作

71. JSTL改写MVC案例

72. Filter概述

73. 创建HttpFilter

74. 理解多个Filter代码的执行顺序

75. 配置Filter的dispatcher节点

76. 禁用浏览器缓存的过滤器

77. 字符编码过滤器

78. 检查用户是否登录的过滤器

79. Filter小结（1）

80. 权限管理思路分析

81. 权限管理代码实现

82. 权限过滤思路分析

83. 权限过滤代码实现

84. HttpServletRequestWrapper

85. Filter小结（2）

86. 监听域对象创建和销毁的Listener

87. 通过Listener理解域对象生命周期

88. 其它的Servlet监听器

89. Servlet监听器小结

90. 文件上传基础

91. 使用fileupload组件

92. 文件上传案例_需求

93. 文件上传案例_JS代码

94. 文件上传案例_约束的可配置性

95. 文件上传案例_总体步骤分析

96. 文件上传案例_构建FileUploadBean集合

97. 文件上传案例_完成文件的上传

98. 文件上传案例_复习

99. 文件上传案例_校验及小结

100. 文件下载

101. 国际化之Locale

102. 国际化之DateFormat

103. 国际化之NumberFormat

104. 国际化之MessageFormat

105. 国际化之ResourceBundle

106. 国际化之fmt标签及小结

