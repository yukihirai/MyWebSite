package EC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import beans.ReviewDataBeans;
import dao.ItemDAO;
import dao.ReviewDAO;

/**
 * Servlet implementation class ItemDetail
 */
@WebServlet("/ItemDetail")
public class ItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		ReviewDataBeans rdb = (ReviewDataBeans)session.getAttribute("rdb");
		int itemId = 0;

		if(!(rdb == null)) {
			rdb = (ReviewDataBeans) EcHelper.cutSession(session,"rdb");
			itemId = rdb.getItem_id();
		}else {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		}

		try {
			ItemDataBeans idb = ItemDAO.getItemDataBeansByUserId(itemId);
			ArrayList<ReviewDataBeans>rdbList = (ArrayList<ReviewDataBeans>)ReviewDAO.getAllReviewData(itemId);
			request.setAttribute("rdbList",rdbList);
			request.setAttribute("idb",idb);
			request.getRequestDispatcher(EcHelper.ITEM_DETAIL_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
