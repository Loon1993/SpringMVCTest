package app16a.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16a.domain.Product;
import app16a.form.ProductForm;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name = "ControllerServlet", urlPatterns={
		"/product_input.action","/product_save.action"
})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1579L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        System.out.println("Servlet Initial");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	private void process(HttpServletRequest request, 
			HttpServletResponse response) throws IOException,ServletException{
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		if(action.equals("product_input")){
			System.out.println("Product Input");
		}
		
		if(action.equals("product_input.action")){
			System.out.println("product_input.action");
		}else if(action.equals("product_save.action")){
			ProductForm productForm = new ProductForm();
			productForm.setName(request.getParameter("name"));
			productForm.setDescription(request.getParameter("description"));
			productForm.setPrice(request.getParameter("price"));
			
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			request.setAttribute("product", product);
		}
		String dispatchUrl = null;
		if(action.equals("product_input.action")){
			dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
		}else if(action.equals("product_save.action")){
			dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
		}
		
		if(dispatchUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}

}
