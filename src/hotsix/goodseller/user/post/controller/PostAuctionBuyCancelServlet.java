package hotsix.goodseller.user.post.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotsix.goodseller.auction.model.service.AuctionService;
import hotsix.goodseller.member.model.service.MemberService;
import hotsix.goodseller.member.model.vo.Member;
import hotsix.goodseller.user.post.model.service.PostService;
import hotsix.goodseller.user.post.model.vo.Post;

/**
 * Servlet implementation class PostAcutionBuyCanceeServlet
 */
@WebServlet("/buyCancel.do")
public class PostAuctionBuyCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAuctionBuyCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Member buyer = (Member)session.getAttribute("member");
	
		
		String userId = request.getParameter("userId");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		Post p = new PostService().auctionDetail(postNo);
		new PostService().updateHit(postNo);
		
		//판매자 닉네임, 신고당한횟수 가져오기
		Member m = new MemberService().selectWriterInfo(p.getWriter());
		
		//판매자 거래내역 가져오기
		String auctionCount = new AuctionService().selectTransactionInfo(p.getWriter());
		
		//판매자 올린 게시물 갯수 가져오기
		String postCount = new PostService().selectPostNum(p.getWriter());
		
		
		//날짜 D-DAY 계산
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar day = Calendar.getInstance();
		Calendar d_day = Calendar.getInstance();
				
		int year = day.get(Calendar.YEAR);
		int month = day.get(Calendar.MONTH)+1;
		int date = day.get(Calendar.DATE)-1;
		
		day.set(year, month, date);
		
		//오늘날짜 시간으로계산
		//System.out.println(day.getTimeInMillis());
		
		//endDate 가져오기
		String[] arr = sdf.format(p.getEndDate()).split("-");
		int d_year = Integer.parseInt(arr[0]);
		int d_month = Integer.parseInt(arr[1]);
		int d_date = Integer.parseInt(arr[2]);
		
		d_day.set(d_year, d_month, d_date);
		
		//d_day날짜 시간으로 계산
		//System.out.println(d_day.getTimeInMillis());
		
		long diff = d_day.getTimeInMillis() - day.getTimeInMillis();
		long d_diff = diff / (24 * 60 * 60 * 1000);
		
		int result = new MemberService().buyCancle(userId);
		
		if(result > 0) {
			buyer.setCancellation(buyer.getCancellation()+1);
			
			response.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html; charset=UTF-8");
			
			RequestDispatcher view = request.getRequestDispatcher("/views/auction/auctionDetailPage.jsp");
			request.setAttribute("post", p);
			request.setAttribute("writer", m);
			request.setAttribute("postCount", postCount);
			request.setAttribute("auctionCount", auctionCount);
			request.setAttribute("d_day", d_diff);
			view.forward(request, response);
			
		
		} else {
			
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
