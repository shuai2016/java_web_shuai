package xin.yangshuai;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * Customer
 *
 * @author shuai
 * @date 2019/1/9
 */
public class Customer implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {

	private static final long serialVersionUID = 1054819286381698920L;

	private String name;
	private Integer age;

	public Customer(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("绑定到session：");
		System.out.println(httpSessionBindingEvent.getName());
		System.out.println(httpSessionBindingEvent.getValue());
		System.out.println("---------------------------------------------------");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("从session中解除绑定：");
		System.out.println(httpSessionBindingEvent.getName());
		System.out.println(httpSessionBindingEvent.getValue());
		System.out.println("---------------------------------------------------");

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
		System.out.println(httpSessionEvent.getSession());
		System.out.println("从内存中写到磁盘上...");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println(httpSessionEvent.getSession());
		System.out.println("从磁盘中读取出来...");
	}
}
