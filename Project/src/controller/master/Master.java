package controller.master;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.main.EcHelper;

@WebServlet("/Master")
public class Master extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Master() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(EcHelper.MASTER_PAGE).forward(request, response);
	}


}
