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
		
		int page = 1;
		int limit = 10;
		int listCount = fDao.getListCount();
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int startPage = page > 10 ? ((int)(page / 10)) * 10 + 1 : page / 10 + 1;
 		int endPage = startPage + limit - 1;
		int maxPage = listCount % 10 == 0 ? listCount / limit : listCount / 10 + 1;
		
		
		List<FriendsVO> friendsList = fDao.selectFriendsPage(page, limit);
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("nowPage", page);
		
		
		
		request.setAttribute("friendsList", friendsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/friendsList.jsp");
		dispatcher.forward(request, response);
	}

}
