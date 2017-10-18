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
import dao.ItemDAO;

@WebServlet("/ItemSearch")
public class ItemSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemSearch() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String searchWord = request.getParameter("searchWord");

		try {
			ArrayList<ItemDataBeans>idbList = (ArrayList<ItemDataBeans>) ItemDAO.getSearchItemDate(searchWord);
			request.setAttribute("idbList",idbList);
			request.getRequestDispatcher(EcHelper.MASTER_ITEM_LIST_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
