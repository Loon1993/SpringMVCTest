package app16a.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16a.controller.InputProductController;
import app16a.controller.SaveProductController;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/product_input.action")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dispatcher!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void process(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String uri = request.getRequestURI();
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		String dispatcherUrl = null;
		if(action.equals("product_input.action")){
			InputProductController controller = new InputProductController();
			dispatcherUrl = controller.handleRequest(request, response);
		}else if(action.equals("product_save.action")){
			SaveProductController controller = new SaveProductController();
			dispatcherUrl = controller.handleRequest(request, response);
		}
		
		if(dispatcherUrl != null){
			RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
			rd.forward(request, response);
		}
	}
	
}

