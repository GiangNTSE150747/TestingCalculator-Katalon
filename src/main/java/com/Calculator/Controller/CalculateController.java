package com.Calculator.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateController
 */
@WebServlet("/calculate")
public class CalculateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void Process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String firstNumber = request.getParameter("firstNumber");
		String secondNumber = request.getParameter("secondNumber");

		if (action != null && !action.equalsIgnoreCase("")) {
			double result = 0;
			if (checkValidNumber(firstNumber, secondNumber)) {
				double firNum = Double.parseDouble(firstNumber);
				double secNum = Double.parseDouble(secondNumber);

				switch (action) {
				case "+":
					result = sum(firNum, secNum);
					request.setAttribute("result", result);
					break;
				case "-":
					result = minus(firNum, secNum);
					request.setAttribute("result", result);
					break;
				case "*":
					result = multi(firNum, secNum);
					request.setAttribute("result", result);
					break;
				case "/":
					if (secNum == 0) {
						request.setAttribute("result", "Infinity");
					} else {
						result = divide(firNum, secNum);
						request.setAttribute("result", result);
					}
					break;
				default:
					request.setAttribute("result", "Not a operation");
				}

				keepUserInput(request, response, firstNumber, secondNumber);
			} else {				
				request.setAttribute("result", "Invalid input number");
				keepUserInput(request, response, firstNumber, secondNumber);
			}

		} else {
			doDisplay(request, response);
		}

	}

	private void keepUserInput(HttpServletRequest request, HttpServletResponse response, String firstNumber,
			String secondNumber) throws ServletException, IOException {
		request.setAttribute("firstNumber", firstNumber);
		request.setAttribute("secondNumber", secondNumber);
		doDisplay(request, response);
	}

	private double sum(double firstNum, double secondNum) {
		return firstNum + secondNum;
	}

	private double minus(double firstNum, double secondNum) {
		return firstNum - secondNum;
	}

	private double multi(double firstNum, double secondNum) {
		return firstNum * secondNum;
	}

	private double divide(double firstNum, double secondNum) {
		return firstNum / secondNum;
	}

	private boolean checkValidNumber(String a, String b) {

		try {
			Double.parseDouble(a);
			Double.parseDouble(b);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	protected void doDisplay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Process(request, response);
	}

}
