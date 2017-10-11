package EC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserSearch() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");

		String inputLogin_id = request.getParameter("login_id");
		String inputName = request.getParameter("name");
		String inputFromBirth = request.getParameter("fromBirth");
		String inputTobirth = request.getParameter("toBirth");

		try {
			ArrayList<UserDataBeans>udbList = (ArrayList<UserDataBeans>) UserDAO.getUserSearchResult(inputLogin_id,inputName,inputFromBirth,inputTobirth);
			request.setAttribute("udbList",udbList);
			request.setAttribute("userId",userId);
			request.getRequestDispatcher(EcHelper.USER_LIST_PAGE).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
