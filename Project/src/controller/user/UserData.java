package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.UserDataBeans;
import controller.main.EcHelper;
import dao.BuyDAO;
import dao.UserDAO;

@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		int userId = (int)session.getAttribute("userId");

		try {
			UserDataBeans udb = UserDAO.getUserDataBeansByUserId(userId);
			ArrayList<BuyDataBeans> bdbList = (ArrayList<BuyDataBeans>)BuyDAO.getBuyDataBeansByUserId(userId);

			request.setAttribute("bdbList",bdbList);
			request.setAttribute("udb",udb);
			request.getRequestDispatcher(EcHelper.USER_DATA_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error");
		}
	}

}
