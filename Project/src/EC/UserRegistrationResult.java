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
 * Servlet implementation class UserRegistrationResult
 */
@WebServlet("/UserRegistrationResult")
public class UserRegistrationResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {

			String inputName = request.getParameter("name");
			String inputLogin_id = request.getParameter("login_id");
			String inputAddress = request.getParameter("address");
			String inputBirth_date = request.getParameter("birth_date");
			String inputPassword = request.getParameter("password");

			UserDataBeans udb = new UserDataBeans();

			udb.setName(inputName);
			udb.setLogin_id(inputLogin_id);
			udb.setAddress(inputAddress);
			udb.setBirth_date(inputBirth_date);
			udb.setPassword(inputPassword);

			String confirmRegist = request.getParameter("confirm_button");

			switch(confirmRegist){
			case"cancel":
				session.setAttribute("udb",udb);
				response.sendRedirect("UserRegistration");
				break;

			case"regist":
				UserDAO.getInstance().insertUser(udb);
				request.setAttribute("udb",udb);
				request.getRequestDispatcher(EcHelper.USER_REGIST_RESULT_PAGE).forward(request, response);
				break;
			}

		}catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
		}
	}
}
