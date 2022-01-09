package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.FriendsDAO;

public class FriendsDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		FriendsDAO fDao = FriendsDAO.getInstance();
		fDao.deleteFriends(name);
	
		new FriendsListAction().execute(request, response);

	}

}
