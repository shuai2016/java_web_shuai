package xin.yangshuai.javaweb.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ForEachTag
 *
 * @author shuai
 * @date 2019/1/4
 */
public class ForEachTag extends SimpleTagSupport {

	private Object items;
	private String var;

	public void setItems(Object items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println(var);
		System.out.println(items instanceof List);
		if (items instanceof List) {
			List items = (List) this.items;
			for (Object item : items) {
				System.out.println(item);
				getJspContext().setAttribute(var, item);
				getJspBody().invoke(null);
			}
		}
		if (items instanceof Map) {
			Map items = (Map) this.items;
			for (Object o : items.entrySet()) {
				System.out.println(o);
				getJspContext().setAttribute(var, o);
				getJspBody().invoke(null);
			}
		}
	}
}
