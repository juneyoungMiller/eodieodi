package semiProject.com.kh.course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiProject.com.kh.course.model.service.CourseService;
import semiProject.com.kh.course.model.vo.Course;
import semiProject.com.kh.place.model.service.PlaceService;

/**
 * Servlet implementation class CourseDeleteServlet
 */
@WebServlet("/cDelete.co")
public class CourseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int result = new CourseService().delectCourse(cNo);
		if(result >0)
		{
			response.sendRedirect("list.co");
			
		}
		else
		{
			request.setAttribute("msg", "코스 삭제에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
