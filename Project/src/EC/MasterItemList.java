package EC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class MasterItemList
 */
@WebServlet("/MasterItemList")
public class MasterItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ArrayList<ItemDataBeans>idbList = (ArrayList<ItemDataBeans>) ItemDAO.getAllItemDate();
			request.setAttribute("idbList",idbList);
			request.getRequestDispatcher(EcHelper.MASTER_ITEM_LIST_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}