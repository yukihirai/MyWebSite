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
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String resultDelete = request.getParameter("result_button");

		try {
			switch(resultDelete){
			case"cancel":
				session.setAttribute("itemId",itemId);
				response.sendRedirect("MasterItemDelete");
				break;

			case"delete":
				ItemDataBeans idb = ItemDAO.getItemDataBeansByUserId(itemId);
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
