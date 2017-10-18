package EC;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.ItemDataBeans;
import dao.ItemDAO;

@WebServlet("/MasterItemRegistrationConfirm")
@MultipartConfig(location="C:\\Users\\yuki\\Documents\\MyWebSite\\Project\\WebContent\\pic", maxFileSize=1048576)
public class MasterItemRegistrationConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemRegistrationConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String inputName = request.getParameter("name");
		int inputPrice = Integer.parseInt(request.getParameter("price"));
		String inputDetail = request.getParameter("detail");

		Part part = request.getPart("file_name");
		String film_name = EcHelper.getFileName(part);
		part.write(film_name);

		ItemDataBeans idb = new ItemDataBeans();

		idb.setName(inputName);
		idb.setDetail(inputDetail);
		idb.setPrice(inputPrice);
		idb.setFilm_name(film_name);


		try {
			ItemDAO.getInstance().insertItem(idb);
			request.setAttribute("idb",idb);
			request.getRequestDispatcher(EcHelper.MASTER_ITEM_REGISTRATION_CONFILM_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
