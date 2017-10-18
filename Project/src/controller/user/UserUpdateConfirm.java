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

@WebServlet("/UserUpdateConfirm")
public class UserUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserUpdateConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

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

		if(!inputPassword.equals(inputPassword_confirm)) {
			session.setAttribute("udb",udb);
			session.setAttribute("message","パスワードをもう一度確認してください。");
			response.sendRedirect("UserUpdate");

		}else if(inputPassword.length()==0){
			request.setAttribute("udb",udb);
			request.setAttribute("message","変更なし");
			request.getRequestDispatcher(EcHelper.USER_UPDATE_CONFIRM_PAGE).forward(request, response);
		}else {
			udb.setPassword(inputPassword);
			request.setAttribute("udb",udb);
			request.getRequestDispatcher(EcHelper.USER_UPDATE_CONFIRM_PAGE).forward(request, response);
		}
	}

}
