package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class MasterItemDeleteResult
 */
@WebServlet("/MasterItemDeleteResult")
public class MasterItemDeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemDeleteResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");
		String film_name = request.getParameter("film_name");
		String resultDelete = request.getParameter("result_button");

		ItemDataBeans idb = new ItemDataBeans();

		idb.setId(itemId);
		idb.setName(name);
		idb.setPrice(price);
		idb.setDetail(detail);
		idb.setFilm_name(film_name);

		try {
			switch(resultDelete){
			case"cancel":
				response.sendRedirect("MasterItemList");
				break;

			case"delete":
				ItemDAO.getInstance().itemDelete(itemId);

				request.setAttribute("idb",idb);
				request.getRequestDispatcher(EcHelper.MASTER_ITEM_DELETE_RESULT_PAGE).forward(request, response);
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
