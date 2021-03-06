package controller.master;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import controller.main.EcHelper;
import dao.ItemDAO;

@WebServlet("/MasterItemUpdate")
public class MasterItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int itemId = Integer.parseInt(request.getParameter("itemId"));

		try {
			ItemDataBeans idb = ItemDAO.getItemDataBeansByUserId(itemId);
			request.setAttribute("idb",idb);
			request.getRequestDispatcher(EcHelper.MASTER_ITEM_UPDATE_PAGE).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
