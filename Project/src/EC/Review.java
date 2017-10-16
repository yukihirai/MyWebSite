package EC;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReviewDataBeans;
import beans.UserDataBeans;
import dao.ItemDAO;
import dao.ReviewDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Review() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		int userId = (int)session.getAttribute("userId");

		String user_name = null;

		try {
			UserDataBeans udb = UserDAO.getUserDataBeansByUserId(userId);
			user_name = udb.getName();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String head_comment = (String)request.getParameter("head_comment");
		String review = (String)request.getParameter("review");
		int item_value = Integer.parseInt(request.getParameter("item_value"));

		ReviewDataBeans rdb = new ReviewDataBeans();
		rdb.setUser_id(userId);
		rdb.setUser_name(user_name);
		rdb.setItem_id(itemId);
		rdb.setHead_comment(head_comment);
		rdb.setReview(review);
		rdb.setItem_value(item_value);

		try {
			ReviewDAO.getInstance().insertReview(rdb);
			double conAllVa = ReviewDAO.getItemValue(itemId);
			ItemDAO.getInstance().insertValue(conAllVa, itemId);
			session.setAttribute("rdb",rdb);
			response.sendRedirect("ItemDetail");
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
	}
	}
}
