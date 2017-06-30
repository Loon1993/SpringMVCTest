package app16a.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16a.domain.Product;
import app16a.form.ProductForm;

public class SaveProductController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ProductForm productForm = new ProductForm();
		
		productForm.setName(httpServletRequest.getParameter("name"));
		productForm.setDescription(httpServletRequest.getParameter("description"));
		productForm.setPrice(httpServletRequest.getParameter("price"));
		
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		product.setPrice(Float.parseFloat(productForm.getPrice()));
		
		httpServletRequest.setAttribute("product", product);
		return "/WEB-INF/jsp/ProductDetails.jsp";
	}

}
