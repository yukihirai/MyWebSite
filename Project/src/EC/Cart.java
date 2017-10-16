package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ArrayList<ItemDataBeans>cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");
			if(cart == null) {
				cart = new ArrayList<ItemDataBeans>();
				session.setAttribute("cart",cart);
			}

			String message = "";

			if(cart.size() == 0) {
				message = "カートに商品がありません";
			}

			request.setAttribute("message",message);
			request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
