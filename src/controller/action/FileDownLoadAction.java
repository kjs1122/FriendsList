package controller.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownLoadAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file_name");
		String path = "upload";
		ServletContext context = request.getServletContext();
		String filePath = context.getRealPath(path);
		String downloadPath = filePath + "\\" + fileName;
	
		
		byte buffer[] = new byte[4096];
		
		FileInputStream in = new FileInputStream(downloadPath);
		
		String mimeType = request.getServletContext().getMimeType(downloadPath);
		
		if(mimeType == null) {
			mimeType = "application.octec-stream";
		}
		
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", "attachment; filename = " + fileName);
		ServletOutputStream out = response.getOutputStream();
		
		int numRead;
		while((numRead = in.read(buffer, 0, buffer.length)) != -1) {
			out.write(buffer,0,numRead);
		}
		
		out.flush();
		out.close();
		in.close();	
	
	}

}
