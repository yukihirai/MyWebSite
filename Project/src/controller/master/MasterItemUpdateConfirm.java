package controller.master;

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
import controller.main.EcHelper;
import dao.ItemDAO;

@WebServlet("/MasterItemUpdateConfirm")
@MultipartConfig(location="C:\\Users\\yuki\\Documents\\MyWebSite\\Project\\WebContent\\pic", maxFileSize=1048576)
public class MasterItemUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemUpdateConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String inputName = request.getParameter("name");
		int inputPrice = Integer.parseInt(request.getParameter("price"));
		String inputDetail = request.getParameter("detail");

		Part part = request.getPart("file_name");
		System.out.println(part);
		String film_name = EcHelper.getFileName(part);
		part.write(film_name);

		ItemDataBeans idb = new ItemDataBeans();

		idb.setId(itemId);
		idb.setName(inputName);
		idb.setDetail(inputDetail);
		idb.setPrice(inputPrice);
		idb.setFilm_name(film_name);

		try {
			ItemDAO.itemUpdate(idb);
			request.setAttribute("idb",idb);
			request.getRequestDispatcher(EcHelper.MASTER_ITEM_UPDATE_CONFIRM_PAGE).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
