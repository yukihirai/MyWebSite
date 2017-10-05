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
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		UserDataBeans udb = (UserDataBeans) session.getAttribute("udb");

		if(!(udb == null)) {
			udb = (UserDataBeans) EcHelper.cutSession(session,"udb");
			String message = (String)EcHelper.cutSession(session,"message");
			request.setAttribute("udb",udb);
			request.setAttribute("message",message);
			request.getRequestDispatcher(EcHelper.USER_UPDATE_PAGE).forward(request, response);
		}

		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserDataBeans udbDate = UserDAO.getUserDataBeansByUserId(userId);

			request.setAttribute("udb",udbDate);
			request.getRequestDispatcher(EcHelper.USER_UPDATE_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}