package hotsix.goodseller.admin.board.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotsix.goodseller.admin.board.report.service.ReportService;
import hotsix.goodseller.user.board.model.vo.ReqBoardPageData;



/**
 * Servlet implementation class BoardRegisterAllListServlet
 */
@WebServlet("/registerAdminAllList.do")
//여기 위에 적혀 있는걸 /registerAllList.do -> /registerAdminAllList.do
//으로 바꾸고 웹에서도 /registerAdminAllList.do 로 접근해야 해요 아 ! 네네 이것만 바꾸면 되는거에요 ?
//넵! 그러면 수고하세용 ^^감사합니다
public class ReportAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //관리자용 신고게시판 리스트 서블릿 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage; 
		String selectBox = request.getParameter("selectBox");
		String searchText = request.getParameter("searchText");
		
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//ReqBoardPageData result = new BoardService().selectRegisterAllListPage(currentPage,selectBox,searchText);
		ReqBoardPageData result = new ReportService().selectRegisterAllListPage(currentPage,selectBox,searchText);
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/register/boardRegisterList.jsp");
		request.setAttribute("pageData", result);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}