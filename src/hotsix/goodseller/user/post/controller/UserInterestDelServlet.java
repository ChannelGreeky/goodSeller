package hotsix.goodseller.user.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotsix.goodseller.member.model.vo.Member;
import hotsix.goodseller.user.post.model.service.PostService;
import hotsix.goodseller.user.post.model.vo.InterestProduct;
import hotsix.goodseller.user.post.model.vo.Post;

/**
 * Servlet implementation class UserInterestDelServlet
 */
@WebServlet("/userInterestDel.do")
public class UserInterestDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInterestDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");	// 데이터를 보낼 때 
		response.setContentType("text/html; charset=UTF-8");	//페이지를 보낼때
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		PrintWriter out = response.getWriter();
		Post p = null;
		
		if(m!=null) {
			String userId = m.getUserId();
			int result = new PostService().deleteInterestPost(userId, postNo);
			if(result>0) {
				RequestDispatcher view = request.getRequestDispatcher("/userInterestList.do");
				view.forward(request, response);
			}else {
				out.print("<script>alert('관심목록이 삭제되지 않았습니다.'); </script>");
				out.print("<script>history.back(-1);</script>");
			}
			
		} else {
			out.print("<script>alert('세션 만료. 다시 로그인하여 주십시오'); </script>");
			out.print("<script>location.href ='/index.do';</script>");
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
