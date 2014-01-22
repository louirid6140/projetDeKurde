package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecuperationListeUtilisateurs
 */
@WebServlet("/RecuperationListeUtilisateurs")
public class ListerUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String ATT_CREATION = "creation";
	 public static final String ATT_FORM     = "form";
	 
	 public static final String VUE        = "listerUtilisateur.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerUtilisateurs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* � la r�ception d'une requ�te GET, affichage de la liste
		des clients */
		        this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}