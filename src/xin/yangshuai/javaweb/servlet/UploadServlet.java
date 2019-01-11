package xin.yangshuai.javaweb.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * UploadServlet
 *
 * @author shuai
 * @date 2019/1/10
 */
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UploadServlet's...");

		File yourTempDirectory = new File("E:\\tempDirectory");

		Integer yourMaxMemorySize = 1024 * 500;

		Integer yourMaxRequestSize = 1024 * 1024 * 5;

		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置临时文件夹
		factory.setRepository(yourTempDirectory);
		//设置内存中最多可以存放的上传文件大小，若超出则把文件写到一个临时文件夹中，以byte 为单位
		factory.setSizeThreshold(yourMaxMemorySize);

		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置上传文件的总的大小，也可以设置单个文件的大小
		upload.setSizeMax(yourMaxRequestSize);
		int index = 1;
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					System.out.println("***********************"+index++ +" 普通表单组件start******************************");
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name + " : " + value);
					System.out.println("***********************普通表单组件end******************************");
				} else {
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(isInMemory);
					System.out.println(sizeInBytes);


					InputStream in = item.getInputStream();

					byte[] buffer = new byte[1024];
					int len = 0;

					//fileName = "E:\\tempDirectory\\" + fileName;
					System.out.println(getServletContext().getRealPath("/file/"));
					fileName = getServletContext().getRealPath("/file") + "/" + fileName;
					System.out.println(fileName);

					OutputStream out = new FileOutputStream(fileName);

					while ((len = in.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
