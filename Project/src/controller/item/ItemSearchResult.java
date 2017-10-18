package controller.item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import controller.main.EcHelper;
import dao.ItemDAO;

@WebServlet("/ItemSearchResult")
public class ItemSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final static int PAGE_MAX_ITEM_COUNT = 8;

    public ItemSearchResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {

		String searchWord = request.getParameter("searchWord");

		int pageNum = Integer.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
		session.setAttribute("searchWord", searchWord);
		ArrayList<ItemDataBeans> searchResultItemList = ItemDAO.getInstance().getItemsByItemName(searchWord, pageNum, PAGE_MAX_ITEM_COUNT);

		double itemCount = ItemDAO.getItemCount(searchWord);
		int pageMax = (int) Math.ceil(itemCount / PAGE_MAX_ITEM_COUNT);

		request.setAttribute("itemCount",(int)itemCount);
		request.setAttribute("pageMax",pageMax);
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("itemList",searchResultItemList);
		request.getRequestDispatcher(EcHelper.ITEM_SEARCH_RESULT_PAGE).forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
