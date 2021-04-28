package com.callor.welcome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ws2")
public class TestControllerB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String strNum1 = req.getParameter("num1");
		String strNum2 = req.getParameter("num2");
		
		Integer num1 = Integer.valueOf(strNum1);
		Integer num2 = Integer.valueOf(strNum2);
		
		Integer sum = num1 + num2;
		
		ServletContext sContext = this.getServletContext();
		
		sContext.setAttribute("num1", num1);
		sContext.setAttribute("num2", num2);
		sContext.setAttribute("sum", sum);
		
		RequestDispatcher rd = sContext.getRequestDispatcher("/resultEx.jsp");
		rd.forward(req, resp);
	}
}
