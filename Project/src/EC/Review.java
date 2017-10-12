package EC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReviewDataBeans;
import dao.ItemDAO;
import dao.ReviewDAO;

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
		int userId = (int)session.getAttribute("userId");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String head_comment = (String)request.getParameter("head_comment");
		String review = (String)request.getParameter("review");
		int item_evaluation = Integer.parseInt(request.getParameter("item_evaluation"));

		ReviewDataBeans rdb = new ReviewDataBeans();
		rdb.setUser_id(userId);
		rdb.setItem_id(itemId);
		rdb.setHead_comment(head_comment);
		rdb.setReview(review);
		rdb.setItem_value(item_evaluation);

		try {
			ReviewDAO.getInstance().insertReview(rdb);
			double conAllVa = ReviewDAO.getItemValue(itemId);
			ItemDAO.getInstance().insertValue(conAllVa, itemId);
			session.setAttribute("itemId",itemId);
			response.sendRedirect("itemDetail");
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
	}
	}
}
