package app16a.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handleRequest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse);
}
