package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class MasterItemRegistrationConfirm
 */
@WebServlet("/MasterItemRegistrationConfirm")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class MasterItemRegistrationConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemRegistrationConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputName = request.getParameter("name");
//		int inputPrice = Integer.parseInt(request.getParameter("price"));
//		String inputDetali = request.getParameter("detail");

		Part part = request.getPart("file_name");
		String name = inputName + "jpg";
		part.write(getServletContext().getRealPath("/pic") + "/" + name);

	}

}
