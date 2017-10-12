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

/**
 * Servlet implementation class MasterItemDelete
 */
@WebServlet("/MasterItemDelete")
public class MasterItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int itemId = (int)session.getAttribute("itemId");

		if(!(itemId == 0)) {
			itemId = (int)EcHelper.cutSession(session,"itemId");

		}else {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		}

		try {
			ItemDataBeans idb = ItemDAO.getItemDataBeansByUserId(itemId);
			request.setAttribute("idb",idb);

			if(idb.getValue()==0) {
				request.setAttribute("message","この商品はまだ評価されていません。");
			}else {
				request.setAttribute("message","ユーザ評価　"+idb.getValue());
			}

			request.getRequestDispatcher(EcHelper.MASTER_ITEM_DELETE_PAGE).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
