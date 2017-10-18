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

@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		UserDataBeans udb = (UserDataBeans) session.getAttribute("udb");

		if(!(udb == null)) {
			udb = (UserDataBeans) EcHelper.cutSession(session,"udb");
			String message = (String)EcHelper.cutSession(session,"message");
			request.setAttribute("udb",udb);
			request.setAttribute("message",message);

			if(message != null || udb != null) {
				request.setAttribute("defaultMessage","パスワードが空欄の場合は変更されません。");
			}

			request.getRequestDispatcher(EcHelper.USER_UPDATE_PAGE).forward(request, response);
		}

		try {
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserDataBeans udbDate = UserDAO.getUserDataBeansByUserId(userId);

			request.setAttribute("defaultMessage","パスワードが空欄の場合は変更されません。");
			request.setAttribute("udb",udbDate);
			request.getRequestDispatcher(EcHelper.USER_UPDATE_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error");
		}
	}
}
