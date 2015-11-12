package Website;

import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Productdetail;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/NewInsertProduct")
public class NewInsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager em = Website.DBUtil.getEmFactory().createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewInsertProduct() {
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
		WebsiteInterface WI = new WebsiteInterface();
		ArrayList<Productdetail> ProductsList= new ArrayList<Productdetail>();
		
		ProductsList= WI.pullProduct();
		String tableinfo = "";
		Productdetail pd = new Productdetail();
		
		 
		 
		 
		
		for(int i=0;i<ProductsList.size();i++)
		{
			pd=ProductsList.get(i);
			System.out.println(pd.getProductname());
			String id1=pd.getProductid();
			tableinfo += "<tr><td>" + pd.getProductid()+"</td><td>" + pd.getProductname()+"</td><td>" + pd.getPrice()+"</td><td> <a href=\"ProductDetail?id="+id1+"\">" + "ClickForDetails"+"</td></tr>";
			
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/NewProductList.jsp")
		.forward(request, response);
		
		
		
	}

}
