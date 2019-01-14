package xin.yangshuai;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello
 *
 * @author shuai
 * @date 2018/12/18
 */
public class Hello {
	public void info() {
		System.out.println("Hello World !");
	}

	public static void main(String[] args) throws ParseException {

		Locale locale = Locale.CHINA;
		Date date = new Date();
		System.out.println(date);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
		String format = dateFormat.format(date);
		System.out.println(format);
		String str = "2019-01-11 17:20:08";
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		Date parse = simpleDateFormat.parse(str);
		System.out.println(parse);

		locale = Locale.CHINA;
		double d = 123456789.123d;
		//格式化为数字字符串
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		String format1 = numberFormat.format(d);
		System.out.println(format1);
		//格式化为货币字符串
		NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
		String format2 = currencyInstance.format(d);
		System.out.println(format2);

		String str1 = "123,456,789.123";
		Double parse1 = (Double) numberFormat.parse(str1);
		System.out.println(parse1);
		str1 = "￥123,456,789.123";
		Double parse2 = (Double) currencyInstance.parse(str1);
		System.out.println(parse2);

		locale = Locale.CHINA;
		String str2 = "Date：{0}，Salary：{1}";
		Date date1 = new Date();
		double sal = 12345.12;
		String format3 = MessageFormat.format(str2, date1, sal);
		System.out.println(format3);
		DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		String format4 = dateInstance.format(date1);
		NumberFormat currencyInstance1 = NumberFormat.getCurrencyInstance(locale);
		String format5 = currencyInstance1.format(sal);
		format3 = MessageFormat.format(str2, format4, format5);
		System.out.println(format3);

		date1 = new Date();
		sal = 12345.12;
		locale = Locale.CHINA;
		ResourceBundle i18n = ResourceBundle.getBundle("i18n", locale);
		String dateLable = i18n.getString("date");
		String salLable = i18n.getString("salary");
		String str3 = "{0}：{1}，{2}：{3}";
		dateInstance = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		format4 = dateInstance.format(date1);
		currencyInstance1 = NumberFormat.getCurrencyInstance(locale);
		format5 = currencyInstance1.format(sal);
		format3 = MessageFormat.format(str3, dateLable, format4, salLable, format5);
		System.out.println(format3);
	}
}
