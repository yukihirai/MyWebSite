package controller.user;

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
import controller.main.EcHelper;
import dao.UserDAO;

@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		int userId = (int)session.getAttribute("userId");

		try {
			ArrayList<UserDataBeans>udbList = (ArrayList<UserDataBeans>) UserDAO.getAllUserDate();
			request.setAttribute("udbList",udbList);
			request.setAttribute("userId",userId);
			request.getRequestDispatcher(EcHelper.USER_LIST_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
