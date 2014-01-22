package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connectionInitiale
 */
@WebServlet("/connectionInitiale")
public class ConnectionInitiale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_MENU_PRINCIPAL       ="/WEB-INF/menuPrincipal.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionInitiale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher(VUE_MENU_PRINCIPAL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
