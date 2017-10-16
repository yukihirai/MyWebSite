package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class UserDeleteResult
 */
@WebServlet("/UserDeleteResult")
public class UserDeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
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
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
