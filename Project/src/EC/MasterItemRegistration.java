package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MasterItemRegistration")
public class MasterItemRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(EcHelper.MASTER_ITEM_REGISTRATION_PAGE).forward(request, response);
	}


}
