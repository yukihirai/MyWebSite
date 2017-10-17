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

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class BuyDetail
 */
@WebServlet("/BuyDetail")
public class BuyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuyDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int buyId = Integer.parseInt(request.getParameter("buyId"));
		try {
			ArrayList<ItemDataBeans> BuyItemList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
			request.setAttribute("buyItemList",BuyItemList);

			BuyDataBeans resultBdb = BuyDAO.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBdb",resultBdb);

			request.getRequestDispatcher(EcHelper.BUY_DETAIL_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
