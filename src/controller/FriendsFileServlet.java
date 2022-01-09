package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.FriendsDAO;
import com.saeyan.dto.FriendsVO;

import controller.action.Action;

/**
 * Servlet implementation class FriendsFileServlet
 */
@WebServlet("/FriendsFileServlet")
public class FriendsFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "upload";
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(path);
		int limitSize = 20 * 1024 * 1024;
		String encType = "UTF-8";
		
		
		MultipartRequest multi = new MultipartRequest(request,
				uploadPath,
				limitSize,
				encType,
				new DefaultFileRenamePolicy());
		
		String command = multi.getParameter("command");
		String name = multi.getParameter("name");
		String age = multi.getParameter("age");
		String gender = multi.getParameter("gender");
		String relation = multi.getParameter("relation");
		String job = multi.getParameter("job");
		String birth = multi.getParameter("birth");
		String phone = multi.getParameter("phone");
		String picture = multi.getFilesystemName("picture");
		String girlfriend = multi.getParameter("girlfriend");
		FriendsVO fVo = new FriendsVO();	
		FriendsDAO fDao = FriendsDAO.getInstance();
		fVo.setName(name);
		fVo.setAge(Integer.parseInt(age));
		fVo.setGender(gender);
		fVo.setRelation(relation);
		fVo.setJob(job);
		fVo.setBirth(birth);
		fVo.setPhone(phone);
		fVo.setGirlfriend(girlfriend);
		if(picture == null) {
			picture = "noImg.jpg";
		}
		fVo.setPicture(picture);
		
		if(command.equals("friends_insert")) {
			fDao.insertFriends(fVo);
		} else if(command.equals("friends_update")){
			fDao.updateFriends(fVo);
		} 
		
		response.sendRedirect("FriendsServlet?command=friends_list");

	}

}
