package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>connectionInitiale est une servlet permettant d'arriver sur le menu principal.
 *  C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */
@WebServlet("/connectionInitiale")


public class ConnectionInitiale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * VUE_MENU_PRINCIPAL    constante donnant l url de la page du menu principal
	 */
	public static final String VUE_MENU_PRINCIPAL       ="/WEB-INF/menuPrincipal.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionInitiale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * En cas de requete de type GET, permet d'afficher la page du menu principal
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
