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
import dao.ReviewDAO;

/**
 * Servlet implementation class ReviewDelete
 */
@WebServlet("/ReviewDelete")
public class ReviewDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReviewDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));

		try {
			ReviewDataBeans rdb = ReviewDAO.getReviewrDataBeansByReviewId(reviewId);
			request.setAttribute("rdb",rdb);
			request.getRequestDispatcher(EcHelper.REVIEW_DELETE_PAGE).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
