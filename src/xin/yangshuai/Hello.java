package xin.yangshuai;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Hello
 *
 * @author shuai
 * @date 2018/12/18
 */
public class Hello {
	public void info(){
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

	}
}
