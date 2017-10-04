package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;

/**
 * Servlet implementation class UserUpdateConfirm
 */
@WebServlet("/UserUpdateConfirm")
public class UserUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String login_id = request.getParameter("login_id");
		String inputName = request.getParameter("name");
		String inputAddress = request.getParameter("address");
		String inputBirth_date = request.getParameter("birth_date");
		String inputPassword = request.getParameter("password");
		String inputPassword_confirm = request.getParameter("password_confirm");

		UserDataBeans udb = new UserDataBeans();

		udb.setId(userId);
		udb.setLogin_id(login_id);
		udb.setName(inputName);
		udb.setAddress(inputAddress);
		udb.setBirth_date(inputBirth_date);
		udb.setPassword(inputPassword);

		if(!inputPassword.equals(inputPassword_confirm)) {
			request.setAttribute("udb",udb);
			request.setAttribute("message","パスワードが同一ではありません。");
			request.getRequestDispatcher(EcHelper.USER_UPDATE_PAGE).forward(request, response);

		}else {
			request.setAttribute("udb",udb);
			request.getRequestDispatcher(EcHelper.USER_UPDATE_CONFIRM_PAGE).forward(request, response);
		}
	}

}
