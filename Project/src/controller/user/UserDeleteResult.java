package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.main.EcHelper;
import dao.UserDAO;

@WebServlet("/UserDeleteResult")
public class UserDeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDeleteResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int userId = Integer.parseInt(request.getParameter("userId"));

		try {
			String confirmDelete = request.getParameter("confirm_button");

			switch(confirmDelete) {
			case"cancel":
				response.sendRedirect("UserList");
				break;

			case"delete":
				UserDAO.getInstance().userDelete(userId);
				request.getRequestDispatcher(EcHelper.USER_DELETE_RESULT_PAGE).forward(request, response);

			}

		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error");
		}
	}

}
