package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.FriendsDAO;
import com.saeyan.dto.FriendsVO;

public class SuccessCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String checkName = request.getParameter("checkName");
		String url = "board/checkForm.jsp";
		
		if(name.equals(checkName)) {
			request.setAttribute("name", name);
			url = "board/successName.jsp";
		} else {
			request.setAttribute("message", "이름이 맞지 않습니다");
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
