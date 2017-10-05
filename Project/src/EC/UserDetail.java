package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class UserDetail
 */
@WebServlet("/UserDetail")
public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int userId = Integer.parseInt(request.getParameter("userId"));

		try {
			UserDataBeans udb = UserDAO.getUserDataBeansByUserId(userId);

			request.setAttribute("udb",udb);
			request.getRequestDispatcher(EcHelper.USER_DETAIL_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}


}