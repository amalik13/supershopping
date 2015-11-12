package Website;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adminproduct;
import model.Productdetail;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em = Website.DBUtil.getEmFactory().createEntityManager();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
		
		
	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebsiteDB WDB = new WebsiteDB();
		ArrayList<Adminproduct> users= new ArrayList<Adminproduct>();
		
		users= WDB.getAllUsers();
		String tableinfo = "";
		Adminproduct pd = new Adminproduct();
		
		 
		 
		 
		
		for(int i=0;i<users.size();i++)
		{
			pd=users.get(i);
			System.out.println(pd.getUsername());
			
			tableinfo += "<tr><td>" + pd.getUsername()+"</td><td>" + pd.getTotalprice()+"</td></tr>";
			
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/AdminTransationList.jsp")
		.forward(request, response);
		
		
	}
	
	}

