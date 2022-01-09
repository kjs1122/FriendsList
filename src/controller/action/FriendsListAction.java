package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.saeyan.dao.FriendsDAO;
import com.saeyan.dto.FriendsVO;

public class FriendsListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendsDAO fDao = FriendsDAO.getInstance();
		List<FriendsVO> friendsList = fDao.selectFreinds();
		
		request.setAttribute("friendsList", friendsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/friendsList.jsp");
		dispatcher.forward(request, response);
	}

}
