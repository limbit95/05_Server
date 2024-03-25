package edu.kh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/loop")
public class JSTLLoopController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book("자바의 정석", "남궁성", 30000));
		bookList.add(new Book("노인과 바다", "헤밍웨이", 40000));
		bookList.add(new Book("전쟁과 평화", "톨스토이", 50000));
		bookList.add(new Book("불변의 법칙", "모건 하우절", 60000));
		
		req.setAttribute("bookList", bookList);
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp");
		
		dis.forward(req, resp);
		
	}
	
}