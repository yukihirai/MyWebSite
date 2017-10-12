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
 * Servlet implementation class UserRegistrationConfirm
 */
@WebServlet("/UserRegistrationConfirm")
public class UserRegistrationConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {

			String inputLogin_id = request.getParameter("login_id");
			String inputName = request.getParameter("name");
			String inputAddress = request.getParameter("address");
			String inputBirth_date = request.getParameter("birth_date");
			String inputPassword = request.getParameter("password");
			String inputConfirmPassword = request.getParameter("confirm_password");

			UserDataBeans udb = new UserDataBeans();

			udb.setLogin_id(inputLogin_id);
			udb.setName(inputName);
			udb.setAddress(inputAddress);
			udb.setBirth_date(inputBirth_date);
			udb.setPassword(inputPassword);

			String message = "";

			if(!inputPassword.equals(inputConfirmPassword)) {
				message += "パスワードをもう一度確認してください。<br>";
			}

			if(!EcHelper.isLoginIdValidation(inputLogin_id)) {
				message += "半角英数とハイフン、アンダースコアのみ使用可能です。";
			}

			if(UserDAO.getInstance().isOverLapLoginId(inputLogin_id)) {
				message +="このログインIDは、すでに使用されています。";
			}

			if(message.length() == 0) {
				request.setAttribute("udb",udb);
				request.getRequestDispatcher(EcHelper.USER_REGIST_CONFIRM_PAGE).forward(request, response);
			}else {
				session.setAttribute("udb",udb);
				session.setAttribute("message",message);
				response.sendRedirect("UserRegistration");
			}
		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
