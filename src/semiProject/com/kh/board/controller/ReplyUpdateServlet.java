package semiProject.com.kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semiProject.com.kh.board.model.service.BoardService;
import semiProject.com.kh.board.model.vo.Reply;
import semiProject.com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ReplyUpdateServlet
 */
@WebServlet("/updateReply.bo")
public class ReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("replyContent");
		int rno = Integer.parseInt(request.getParameter("replyNo"));
	

		Reply r = new Reply();
		r.setReplyContent(content.replaceAll("\n", "<br>"));
		r.setReplyNo(rno);

		
		new BoardService().updateReply(r);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
