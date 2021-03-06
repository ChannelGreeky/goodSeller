package hotsix.goodseller.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import hotsix.goodseller.member.model.service.MemberService;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/idCheck.do")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String userIdCheck = request.getParameter("userIdCheck");
		String userId = new MemberService().idCheck(userIdCheck);
		
		JSONObject object = new JSONObject();
		if(userId == null)
		{
			object.put("result", "true");
		}else {
			object.put("result", "false");
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(object);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
