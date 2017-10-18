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

@WebServlet("/MasterItemDetail")
public class MasterItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MasterItemDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int itemId = Integer.parseInt(request.getParameter("itemId"));

		try {
			ItemDataBeans idb = ItemDAO.getItemDataBeansByUserId(itemId);
			if(idb.getValue()==0) {
				request.setAttribute("message","この商品はまだ評価されていません。");
			}else {
				request.setAttribute("message","ユーザ評価　"+idb.getValue());
			}
			request.setAttribute("idb",idb);
			request.getRequestDispatcher(EcHelper.MASTER_ITEM_DETAIL_PAGE).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}
}
