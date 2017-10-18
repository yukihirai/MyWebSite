package EC;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReviewDataBeans;
import dao.ItemDAO;
import dao.ReviewDAO;

@WebServlet("/ReviewEditResult")
public class ReviewEditResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReviewEditResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String head_comment = (String)request.getParameter("head_comment");
		String review = (String)request.getParameter("review");
		int item_value = Integer.parseInt(request.getParameter("item_value"));
		int itemId = Integer.parseInt(request.getParameter("itemId"));

		ReviewDataBeans rdb = new ReviewDataBeans();
		rdb.setId(reviewId);
		rdb.setHead_comment(head_comment);
		rdb.setReview(review);
		rdb.setItem_value(item_value);
		rdb.setItem_id(itemId);

		try {
			ReviewDAO.reviewUpdate(rdb);
			double conAllVa = ReviewDAO.getItemValue(itemId);
			ItemDAO.getInstance().insertValue(conAllVa, itemId);
			rdb.setAll_value(conAllVa);
			request.setAttribute("rdb",rdb);
			request.getRequestDispatcher(EcHelper.REVIEW_EDIT_RESULT_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("Error");
		}
	}

}
