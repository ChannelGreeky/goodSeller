<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "hotsix.goodseller.user.board.model.vo.Register" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/resources/css/boardMain.css?ver=1.8" />
<style>

#container{
height: 60%;
width: 60%;
}

.col-md-2 {
	border-right: 1px solid gray;
	height: 50px;
	text-align: center;
}

.input-sty {
	width: 90%;
	line-height: 3;
}

.row {
	border-top: 1px solid gray;
}

#rowBtn {
	text-align: center;
}

#note {
	height: 600px;
}

#noteText {
	height: 100%;
	width: 100%;
}

.btn-outline-secondary {
	height: 50px;
}
</style>
<body>

						<%
							Register r = (Register) request.getAttribute("register");
						%>
						

	<div id="wrapper">
	<%@ include file="/views/common/header&footer/header.jsp"%>
	

	<form action="/boardRegisterOneClick.do" method="post">
		<div id="content">
			<div id="container">
					<h1 style="text-align : center;">사용자신고 게시판</h1><br>
				<div class="row">
					<div class="col-md-2">제목</div>
					<div class="col-md-10">
						<%=r.getSubject() %></div>
				</div>

				<div class="row">
					<div class="col-md-2">작성자</div>
					<div class="col-md-10"><%=r.getUserId() %></div>
				</div>

				<div class="row">
					<div class="col-md-2">신고자</div>
					<div class="col-md-10">
						<input type="text" class="input-sty" name="reguserId" value="<%=r.getReguserId() %>" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-2" id="note">내용</div>
					<div class="col-md-10" style="padding: 20px;">
						<textarea name="content" style="height: 100%; width: 100%;"><%=r.getContent() %></textarea>

					</div>
				</div><br>

				<div class="row" id="rowBtn">
					<div class="col-md-12"><br><br>

						<input id="Btn" type="submit" class="btn btn-outline-secondary"
							value="등록" /> <input id="Btn" type="button"
							class="btn btn-outline-secondary" value="취소" /><br>
					</div>
				</div>
			</div>
		</div>
	</form>
	

	<%@ include file="/views/common/header&footer/footer.jsp"%>
	</div>