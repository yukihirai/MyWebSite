package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String inputLogin_id = (String) session.getAttribute("login_id");

		if(!(inputLogin_id == null)) {
			inputLogin_id = (String) EcHelper.cutSession(session,"inputLogin_id");
			String message = (String)EcHelper.cutSession(session,"message");

			request.setAttribute("inputLogin_id",inputLogin_id);
			request.setAttribute("message",message);
		}
		request.getRequestDispatcher(EcHelper.LOGIN_PAGE).forward(request, response);
	}


}
