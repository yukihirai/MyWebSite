package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;

/**
 * Servlet implementation class UserUpdateResult
 */
@WebServlet("/UserUpdateResult")
public class UserUpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String login_id = request.getParameter("login_id");
			String inputName = request.getParameter("name");
			String inputAddress = request.getParameter("address");
			String inputBirth_date = request.getParameter("birth_date");
			String inputPassword = request.getParameter("password");

			UserDataBeans udb = new UserDataBeans();

			udb.setId(userId);
			udb.setLogin_id(login_id);
			udb.setName(inputName);
			udb.setAddress(inputAddress);
			udb.setBirth_date(inputBirth_date);
			udb.setPassword(inputPassword);

			String confirmUpdate = request.getParameter("confirm_button");

			switch(confirmUpdate) {
			case"cancel":
				session.setAttribute("udb",udb);
				response.sendRedirect("UserUpdate");

			case"update":

			}

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
