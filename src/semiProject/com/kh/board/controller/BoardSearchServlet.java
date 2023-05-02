package semiProject.com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiProject.com.kh.board.model.service.BoardService;
import semiProject.com.kh.board.model.vo.Board;
import semiProject.com.kh.board.model.vo.PageInfo;
import semiProject.com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/search.bo")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//공지사항도 넘겨줘야 하니깐
		ArrayList<Notice> nlist = new BoardService().selectNList();
		
		
		//검색내용을 스트링에 담아서 
		
		String searchWord = request.getParameter("search");
		
		
		//페이지랑 검색 내용을 함께 넘셔서 , 새로운 페이지로 넘겨서 받아보자 
		ArrayList<Board> searchBoard = new BoardService().searchWord(searchWord);
		
		
		if(!searchBoard.isEmpty() && !searchWord.equals(" "))
		{
			
			
			request.setAttribute("searchBoard", searchBoard);
			request.setAttribute("searchWord", searchWord);
			
			
			//VIEW 단으로 넘겨주는 객체들 
			request.setAttribute("nlist", nlist);
			
			request.setAttribute("msg",  " ");
			request.getRequestDispatcher("views/board/boardSearchList.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "검색된 결과가 없습니다. 다시 검색해 주세요");
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
