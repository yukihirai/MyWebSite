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
 * Servlet implementation class UserRegist
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegistration() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDataBeans udb = (UserDataBeans) session.getAttribute("udb");

		if(!(udb == null)) {
			udb = (UserDataBeans) EcHelper.cutSession(session,"udb");
			String message = (String)EcHelper.cutSession(session,"message");

			request.setAttribute("udb",udb);
			request.setAttribute("message",message);
		}
		request.getRequestDispatcher(EcHelper.USER_REGIST_PAGE).forward(request, response);

	}

}
