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
import dao.ItemDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		try {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		ItemDataBeans idb = ItemDAO.getItemDataBeansByUserId(itemId);

		ArrayList<ItemDataBeans>cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<ItemDataBeans>();
		}
		cart.add(idb);
		session.setAttribute("cart",cart);
		request.setAttribute("message","商品を追加しました。");
		request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
