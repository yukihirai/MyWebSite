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
 * Servlet implementation class CartItemDelete
 */
@WebServlet("/CartItemDelete")
public class CartItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartItemDelete() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String [] deleteItemIdList = request.getParameterValues("delete_item_id_list");
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");

			String message = "";
			if (deleteItemIdList != null) {
			for (String deleteItemId : deleteItemIdList) {
				for (ItemDataBeans cartInItem : cart) {
					if (cartInItem.getId() == Integer.parseInt(deleteItemId)) {
						cart.remove(cartInItem);
						break;
					}
				}
			}
			message = "削除しました。";
		} else {
			message = "削除する商品が選択されていません。";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
