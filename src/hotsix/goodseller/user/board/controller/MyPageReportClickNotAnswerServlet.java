package hotsix.goodseller.user.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotsix.goodseller.admin.board.report.service.ReportService;
import hotsix.goodseller.admin.board.report.vo.ReportAnswer;
import hotsix.goodseller.user.board.model.vo.Report;

/**
 * Servlet implementation class MyPageReportClickNotAnswerServlet
 */
@WebServlet("/myPageReportNOTANSClick.do")
public class MyPageReportClickNotAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReportClickNotAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이전 페이지에서 넘어온 값 저장
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		ReportAnswer rAnswer = null;
		
		//System.out.println("게시글번호"+reportNo);
		
		//비즈니스 로직 처리 
		Report r = new ReportService().postOneClick(reportNo);
		
		
		if(r!=null) {
		RequestDispatcher view = request.getRequestDispatcher("/views/myPage/reportPostClickNOTANS.jsp");
		request.setAttribute("report", r);
		view.forward(request, response);
		}else {
			response.sendRedirect("/views/admin/reportBoard/reportPostReadFail.jsp");
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
