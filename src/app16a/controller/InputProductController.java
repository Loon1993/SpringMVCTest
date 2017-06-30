package app16a.controller;

import javax.servlet.http.*;

public class InputProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

}
