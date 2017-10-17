package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeliveryMethodDataBeans;
import beans.ItemDataBeans;
import dao.DeliveryMethodDAO;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");

		try {
			if(cart.size() == 0) {
				request.setAttribute("message","購入する商品が選択されていません。");
				request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);
			}else {
				ArrayList<DeliveryMethodDataBeans>dmdbList = (ArrayList<DeliveryMethodDataBeans>) DeliveryMethodDAO.getAllDeliveryMethodData();
				request.setAttribute("dmdbList",dmdbList);
				request.getRequestDispatcher(EcHelper.BUY_PAGE).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
