package EC;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import dao.ItemDAO;

@WebServlet("/MasterItemDelete")
public class MasterItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		ItemDataBeans idb = (ItemDataBeans)session.getAttribute("idb");

		if(!(idb == null)) {
			idb = (ItemDataBeans)EcHelper.cutSession(session,"idb");
			request.setAttribute("idb",idb);

			request.getRequestDispatcher(EcHelper.MASTER_ITEM_DELETE_PAGE).forward(request, response);


		}else {
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			try {
				idb = ItemDAO.getItemDataBeansByUserId(itemId);
				request.setAttribute("idb",idb);

				request.getRequestDispatcher(EcHelper.MASTER_ITEM_DELETE_PAGE).forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
			}
		}
	}
}
