package hotsix.goodseller.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotsix.goodseller.common.JDBCTemplate;
import hotsix.goodseller.member.model.vo.Member;

public class MemberDAO {

	public int memberJoin(Connection conn, Member m) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		String query = "INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT,'N')";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPw());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserNick());
			pstmt.setString(5, m.getBirth());
			pstmt.setString(6, Character.toString(m.getGender()));
			pstmt.setString(7, m.getEmail());
			pstmt.setString(8, m.getPhone());
			pstmt.setString(9, m.getAddress());
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member memberLogin(Connection conn, String userId, String userPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;

		String query = "SELECT * FROM MEMBER WHERE USERID=? AND USERPW=? AND END_YN='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPw(rset.getString("USERPW"));
				m.setUserName(rset.getString("USERNAME"));
				m.setUserNick(rset.getString("USERNICK"));
				m.setBirth(rset.getString("BIRTH"));
				m.setGender(rset.getString("GENDER").charAt(0));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setReported(rset.getInt("REPORTED"));
				m.setCancellation(rset.getInt("CANCELLATION"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return m;
	}
	
	public String idCheck(Connection conn, String userIdCheck) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String userId = null;
	
		String query = "select * from member where userid=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userIdCheck);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				userId = rset.getString("userid");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return userId;
	}
	
	public String nickCheck(Connection conn, String userNickCheck) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String userNick = null;
	
		String query = "select * from member where userNick=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNickCheck);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				userNick = rset.getString("userNick");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return userNick;
	}

	public String phoneCheck(Connection conn, String checkPhone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String phone = null;
	
		String query = "select * from member where phone=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, checkPhone);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				phone = rset.getString("phone");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return phone;
	}
	
	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET END_YN='Y' WHERE userId=? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int memberUpdate(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		
		String query = "UPDATE MEMBER SET " + "userPw =?, " + "userNick = ?, " +
				 "email =?, " + "phone =?, " + "address = ? WHERE userid=?";

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserPw());
			pstmt.setString(2, m.getUserNick());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Member memberFindId(Connection conn, String method, String userName, String userInfo) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Member m=null;
		String query="";
		
		if(method.equals("email")) {
			query="SELECT * FROM MEMBER WHERE USERNAME=? AND EMAIL=? AND END_YN='N'";

		}
		else if(method.equals("phone")) {
			query="SELECT * FROM MEMBER WHERE USERNAME=? AND PHONE=? AND END_YN='N'";
		}
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userInfo);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				m=new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPw(rset.getString("USERPW"));
				m.setUserName(rset.getString("USERNAME"));
				m.setUserNick(rset.getString("USERNICK"));
				m.setBirth(rset.getString("BIRTH"));
				m.setGender(rset.getString("GENDER").charAt(0));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setReported(rset.getInt("REPORTED"));
				m.setCancellation(rset.getInt("CANCELLATION"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
		
		
	}

	public Member memberFindPw(Connection conn, String method, String userName, String userId, String userInfo) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Member m=null;
		String query="";
		
		if(method.equals("email")) {
			query="SELECT * FROM MEMBER WHERE USERNAME=? AND USERID=? AND EMAIL=? AND END_YN='N'";

		}
		else if(method.equals("phone")) {
			query="SELECT * FROM MEMBER WHERE USERNAME=? AND USERID=? AND PHONE=? AND END_YN='N'";
		}
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userId);
			pstmt.setString(3, userInfo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				m=new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPw(rset.getString("USERPW"));
				m.setUserName(rset.getString("USERNAME"));
				m.setUserNick(rset.getString("USERNICK"));
				m.setBirth(rset.getString("BIRTH"));
				m.setGender(rset.getString("GENDER").charAt(0));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setReported(rset.getInt("REPORTED"));
				m.setCancellation(rset.getInt("CANCELLATION"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
		
	}

	public int memberTempPw(Connection conn, String method, String userName, String userId, String userInfo, String userNewPw) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="";
		
		if(method.equals("email")) {
			query = "UPDATE MEMBER SET USERPW=? WHERE USERNAME=? AND USERID=? AND EMAIL=? and END_YN='N'";

		}
		else if(method.equals("phone")) {
			query = "UPDATE MEMBER SET USERPW=? WHERE USERNAME=? AND USERID=? AND phone=? and END_YN='N'";
		}
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userNewPw);
			pstmt.setString(2, userName);
			pstmt.setString(3, userId);
			pstmt.setString(4, userInfo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public Member adminLogin(Connection conn, String userId, String userPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member admin = null;

		String query = "SELECT * FROM MEMBER WHERE USERID=? AND USERPW=? AND END_YN='N' AND USERNO BETWEEN 1 AND 100";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				admin = new Member();
				admin.setUserNo(rset.getInt("USERNO"));
				admin.setUserId(rset.getString("USERID"));
				admin.setUserPw(rset.getString("USERPW"));
				admin.setUserName(rset.getString("USERNAME"));
				admin.setUserNick(rset.getString("USERNICK"));
				admin.setBirth(rset.getString("BIRTH"));
				admin.setGender(rset.getString("GENDER").charAt(0));
				admin.setEmail(rset.getString("EMAIL"));
				admin.setPhone(rset.getString("PHONE"));
				admin.setAddress(rset.getString("ADDRESS"));
				admin.setReported(rset.getInt("REPORTED"));
				admin.setCancellation(rset.getInt("CANCELLATION"));
				admin.setEnrollDate(rset.getDate("ENROLLDATE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return admin;
	}

	public Member selectWriterInfo(Connection conn, String writer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;

		String query = "SELECT * FROM MEMBER WHERE USERID=? AND END_YN='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPw(rset.getString("USERPW"));
				m.setUserName(rset.getString("USERNAME"));
				m.setUserNick(rset.getString("USERNICK"));
				m.setBirth(rset.getString("BIRTH"));
				m.setGender(rset.getString("GENDER").charAt(0));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setReported(rset.getInt("REPORTED"));
				m.setCancellation(rset.getInt("CANCELLATION"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return m;
	}
	
	public int buyCancel(Connection conn, String userId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		
		String query = "update member set CANCELLATION = CANCELLATION+1 where userid=?";

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
