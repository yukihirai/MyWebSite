package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.DeliveryMethodDataBeans;
import beans.ItemDataBeans;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class BuyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuyConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			int userId = (int)session.getAttribute("userId");
			int DeliveryMethodId = Integer.parseInt(request.getParameter("delevary_method_id"));
			System.out.println(DeliveryMethodId);
			DeliveryMethodDataBeans dmdb = DeliveryMethodDAO.getDeliveryMethodDataBeansByDeliveryMethodId(DeliveryMethodId);
			ArrayList<ItemDataBeans>cartIdbList = (ArrayList<ItemDataBeans>)session.getAttribute("cart");

			int totalPrice = EcHelper.getTotalitemPrice(cartIdbList);

			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUser_id(userId);
			bdb.setTotal_price(totalPrice);
			bdb.setDelivery_method_id(DeliveryMethodId);
			bdb.setDelivery_method_name(dmdb.getName());
			bdb.setDelivery_method_price(dmdb.getPrice());

			session.setAttribute("bdb",bdb);
			request.getRequestDispatcher(EcHelper.BUY_CONFIRM_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
