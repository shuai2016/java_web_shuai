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
   2. 该对象代表当前WEB应用：

10. HTTP协议GET和POST请求

11. ServletRequest

12. ServletResponse

13. GenericServlet

14. HttpServlet

15. 小结及练习

16. JSP概述

17. JSP页面的9个隐含对象

18. JSP语法

19. 域对象的属性操作

20. 请求的转发和重定向

21. JSP小结（1）

22. page指令

23. include指令

24. JSP标签

25. 中文乱码问题

26. JSP小结（2）

27. MVC设计模式

28. MVC案例之查询

29. MVC案例之删除

30. MVC案例之架构分析

31. MVC案例之DAO层设计

32. MVC案例之DAO层实现

33. MVC案例之多个请求对应一个Servlet

34. MVC案例之（模糊）查询

35. MVC案例之删除操作

36. MVC案例之小结（1）

37. MVC案例之新增Customer

38. MVC案例之修改思路分析

39. MVC案例之修改代码实现

40. MVC案例之通过配置切换底层存储源

41. MVC案例之小结（2）

42. Cookie概述

43. 利用Cookie进行自动登录

44. 利用Cookie显示最近浏览的商品

45. 设置Cookie的作用路径

46. Cookie小结

47. HttpSession概述

48. HttpSession的生命周期

49. HttpSession常用方法示例

50. HttpSessionURL重写

51. HttpSession小结（1）

52. HttpSession之简易购物车

53. JavaWeb中的相对路径和绝对路径

54. HttpSession之表单的重复提交

55. HttpSession之验证码

56. HttpSession小结（2）

57. 使用JavaBean

58. EL语法

59. EL详解

60. 简单标签的HelloWorld

61. 带属性的自定义标签

62. 带标签体的自定义标签

63. 带父标签的自定义标签

64. EL自定义函数

65. 简单标签小结

66. JSTL表达式操作

67. JSTL流程控制操作

68. JSTL迭代操作

69. JSTL_URL操作

70. JSTL改写MVC案例

71. Filter概述

72. 创建HttpFilter

73. 理解多个Filter代码的执行顺序

74. 配置Filter的dispatcher节点

75. 禁用浏览器缓存的过滤器

76. 字符编码过滤器

77. 检查用户是否登录的过滤器

78. Filter小结（1）

79. 权限管理思路分析

80. 权限管理代码实现

81. 权限过滤思路分析

82. 权限过滤代码实现

83. HttpServletRequestWrapper

84. Filter小结（2）

85. 监听域对象创建和销毁的Listener

86. 通过Listener理解域对象生命周期

87. 其它的Servlet监听器

88. Servlet监听器小结

89. 文件上传基础

90. 使用fileupload组件

91. 文件上传案例_需求

92. 文件上传案例_JS代码

93. 文件上传案例_约束的可配置性

94. 文件上传案例_总体步骤分析

95. 文件上传案例_构建FileUploadBean集合

96. 文件上传案例_完成文件的上传

97. 文件上传案例_复习

98. 文件上传案例_校验及小结

99. 文件下载

100. 国际化之Locale

101. 国际化之DateFormat

102. 国际化之NumberFormat

103. 国际化之MessageFormat

104. 国际化之ResourceBundle

105. 国际化之fmt标签及小结

