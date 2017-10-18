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

@WebServlet("/ReviewDeleteResult")
public class ReviewDeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReviewDeleteResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		ReviewDataBeans rdb = new ReviewDataBeans();
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		try {
			rdb = ReviewDAO.getReviewrDataBeansByReviewId(reviewId);

			String resultDelete = request.getParameter("confirm_button");

			switch(resultDelete){
			case"cancel":
				session.setAttribute("rdb",rdb);
				response.sendRedirect("ItemDetail");
				break;

			case"delete":
				ReviewDAO.getInstance().reviewDelete(reviewId);
				double conAllVa = ReviewDAO.getItemValue(rdb.getItem_id());
				ItemDAO.getInstance().insertValue(conAllVa, rdb.getItem_id());
				rdb.setAll_value(conAllVa);

				request.setAttribute("rdb",rdb);
				request.getRequestDispatcher(EcHelper.REVIEW_DELETE_RESULT_PAGE).forward(request, response);
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
