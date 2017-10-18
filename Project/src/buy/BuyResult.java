package buy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.BuyDetailDataBeans;
import beans.ItemDataBeans;
import controller.main.EcHelper;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class BuyResult
 */
@WebServlet("/BuyResult")
public class BuyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuyResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");
		BuyDataBeans bdb = (BuyDataBeans) EcHelper.cutSession(session,"bdb");

		try {

			int buyId = BuyDAO.insertBuyData(bdb);

			for(ItemDataBeans cartItem : cart) {
				BuyDetailDataBeans bddb = new BuyDetailDataBeans();
				bddb.setBuy_id(buyId);
				bddb.setItem_id(cartItem.getId());
				BuyDetailDAO.insertBuyDetail(bddb);
			}

			BuyDataBeans resultBdb = BuyDAO.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBdb",resultBdb);

			ArrayList<ItemDataBeans> BuyItemList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);

			request.setAttribute("buyItemList",BuyItemList);

			request.getRequestDispatcher(EcHelper.BUY_RESULT_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
