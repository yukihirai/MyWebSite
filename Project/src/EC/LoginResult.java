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
 * Servlet implementation class LoginResult
 */
@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		try {
			String login_id = request.getParameter("login_id");
			String password = request.getParameter("login_password");
			System.out.println(login_id);
			System.out.println(password);

			int userId = UserDAO.getUserId(login_id,password);

			if(userId !=0) {
				session.setAttribute("userId",userId);

				response.sendRedirect("Index");
			}else {
				session.setAttribute("login_id",login_id);
				session.setAttribute("message","ログインIDもしくはパスワードが正しくありません。");
				response.sendRedirect("Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}


}
