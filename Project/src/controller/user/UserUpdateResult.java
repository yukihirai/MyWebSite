package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import controller.main.EcHelper;
import dao.UserDAO;

@WebServlet("/UserUpdateResult")
public class UserUpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserUpdateResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		UserDataBeans udb = new UserDataBeans();

		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String inputLogin_id = request.getParameter("login_id");
			String inputName = request.getParameter("name");
			String inputAddress = request.getParameter("address");
			String inputBirth_date = request.getParameter("birth_date");
			String inputPassword = request.getParameter("password");

				udb.setId(userId);
				udb.setLogin_id(inputLogin_id);
				udb.setName(inputName);
				udb.setAddress(inputAddress);
				udb.setBirth_date(inputBirth_date);
				if(!inputPassword.equals("noUpdate")) {
					udb.setPassword(inputPassword);
				}else {
					udb.setPassword("noUpdate");
				}

			String confirmUpdate = request.getParameter("confirm_button");

			switch(confirmUpdate) {
			case"cancel":
				session.setAttribute("udb",udb);
				response.sendRedirect("UserUpdate");
				break;

			case"update":
				UserDAO.userUpdate(udb);
				request.setAttribute("udb",udb);
				request.getRequestDispatcher(EcHelper.USER_UPDATE_RESULT_PAGE).forward(request, response);

			}

		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error");
		}
	}

}
