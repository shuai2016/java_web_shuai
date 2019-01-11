package xin.yangshuai.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * DownloadServlet
 *
 * @author shuai
 * @date 2019/1/11
 */
public class DownloadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DownloadServlet's...");
		response.setContentType("application/x-msdownload");

		String fileName = "图片.jpg";

		/**
		 * 如果是火狐,解决火狐中文名乱码问题
		 */
		if (getBrowser(request).equals("FF")) {
			fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		} else {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

		String realPath = getServletContext().getRealPath("/file/wallhaven-697055.jpg");

		ServletOutputStream out = response.getOutputStream();

		InputStream in = new FileInputStream(realPath);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}

		in.close();
	}

	/**
	 * 判断浏览器种类的方法
	 *
	 * @param request
	 * @return
	 */
	private String getBrowser(HttpServletRequest request) {
		String UserAgent = request.getHeader("USER-AGENT").toLowerCase();
		if (UserAgent != null) {
			if (UserAgent.indexOf("msie") >= 0) {
				return "IE";
			}
			if (UserAgent.indexOf("firefox") >= 0) {
				return "FF";
			}

			if (UserAgent.indexOf("safari") >= 0) {
				return "SF";
			}
		}
		return null;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
