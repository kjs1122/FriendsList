package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.FriendsDAO;
import com.saeyan.dto.FriendsVO;

public class FriendsViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		FriendsDAO fDao = FriendsDAO.getInstance();
		FriendsVO fVo = fDao.selectFriendsByName(name);
		
		request.setAttribute("friend", fVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/friendsView.jsp");
		dispatcher.forward(request, response);
	}

}
