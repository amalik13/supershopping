package Website;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Website.WebsiteDB;
/**
 * Servlet implementation class Calculate
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	static int seq=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
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
		HttpSession session = request.getSession();
		WebsiteDB db = new WebsiteDB();
		
		float costProduct=0;
		float totalCost=0;
		String cost="";
		cost=(String) session.getValue("cost");
		String id=(String) session.getValue("id");
		String UserName=(String) session.getValue("UserName");
		String price=(String) session.getValue("Price");
		session.setAttribute("id", id);
		session.setAttribute("Price", price);
		
		
		String quantity=request.getParameter("Quantity");
		session.setAttribute("Quantity", quantity);
		
		
			float Quantity=Float.valueOf(quantity);
			float Price=Float.valueOf(price);	
			if(cost!=null)
			{
			totalCost=Float.valueOf(cost);
			}
			costProduct=Quantity*Price;
			 totalCost = totalCost+costProduct;
			 //cost=String.valueOf(totalCost);
			 
			 session.setAttribute("cost", String.valueOf(totalCost));
			 
			 
			
			 
			 
		
			 db.InsertRecords(UserName, String.valueOf(totalCost));
		
			
			 getServletContext()
				.getRequestDispatcher("/InsertProduct")
				.forward(request, response);
	}

}
