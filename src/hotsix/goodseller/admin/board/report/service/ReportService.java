package hotsix.goodseller.admin.board.report.service;

import java.sql.Connection;
import java.util.ArrayList;

import hotsix.goodseller.admin.board.report.dao.ReportDAO;
import hotsix.goodseller.admin.board.report.vo.ReportPost;
import hotsix.goodseller.common.JDBCTemplate;
import hotsix.goodseller.user.board.model.vo.Register;
import hotsix.goodseller.user.board.model.vo.ReqBoardPageData;

public class ReportService {
	ReportDAO registerDAO = new ReportDAO();

	public ReqBoardPageData selectRegisterAllListPage(int currentPage, String selectBox, String searchText) {
		Connection conn = JDBCTemplate.getConnection();
		int recordPerPage = 15; // 한 페이지당 몇개씩 게시물이 보이게 할 것인지를 정함.
		ArrayList<Register> list = registerDAO.selectRegisterAllListPage(conn, currentPage, recordPerPage, selectBox,
				searchText);

		// 네비바 만듬 12345> <678910> ...
		int naviCountPerPage = 5; // PageNavi 값이 몇개씩 보여줄 것인지
		String regGetpageNavi = registerDAO.regGetpageNavi(conn, currentPage, recordPerPage, naviCountPerPage);

		ReqBoardPageData bpd = new ReqBoardPageData();
		bpd.setList(list);
		bpd.setPageNavi(regGetpageNavi);

		JDBCTemplate.close(conn);
		return bpd;

	}

	public Register RegisterOneClick(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Register register = registerDAO.RegisterOneClick(conn, boardNo);

		JDBCTemplate.close(conn);
		
		return register;
	}

	// 신고게시판 댓글
	public int insertBoardComment(int boardNo, String comment, String userId) {
		Connection conn = JDBCTemplate.getConnection();

		int result = registerDAO.insertBoardComment(conn, boardNo, comment, userId);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	//신고게시판 댓글
	public ArrayList<ReportPost> selectCommentBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<ReportPost> list = ReportDAO.selectCommentBoard(conn,boardNo);
		
		JDBCTemplate.close(conn);
		return list;
		
	}
}