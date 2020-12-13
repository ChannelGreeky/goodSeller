<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="hotsix.goodseller.member.model.vo.Member"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
	
<!-- css -->
<link rel="stylesheet" type="text/css" href="/resources/css/header.css" />
</head>
<body>
	<div id="header">
		<div class="container">
			<div id="core-header" class="row">
				<div class="col-1 col-md-3 col-lg-2">
					<div id="main-navi">
						<a href="#" id="menu-navi-tag"><img
							src="/resources/images/main_menu.png" id="main-navi-img" /></a> <a
							href="/index.jsp"><img class="d-none d-md-block"
							src="/resources/images/logo.png" id="logo-img" /></a>
					</div>
				</div>
				<!--                    여기가 메뉴-->
				<ul id="main-menu">
					<li><a id="home" href="/views/auction/auctionMain.jsp">&nbsp;&nbsp;&nbsp;&nbsp;Home</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;의류 브랜드 패션</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;생활 건강</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;가구 가전</a></li>
					<li><a href="/views/auction/auctionDigital.jsp">&nbsp;&nbsp;&nbsp;&nbsp;디지털 컴퓨터</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;도서 문구</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;뷰티 잡화</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;스포츠 레저</a></li>
				</ul>
				<span id="tooltiptext-main">카테고리</span>



				<div class="col-6 col-md-5 col-lg-7">
					<div id="search-box">
						<div class="mb-3">
							<form id="searchForm" action="#">
								<fildset> <input type="text" id="search-input"
									placeholder="  검색" class="menu-none"/>
								<button type="submit" id="search-btn">
									<img src="/resources/images/searchImg.png" id="search-img">
								</button>
								</fildset>
							</form>
							<span id="tooltiptext-search">검색</span> <span
								id="tooltiptext-side">고객센터</span>
							<!--  <span id="tooltiptext-user">마이페이지</span> -->
						</div>
					</div>
				</div>
				<div class="col-5 col-md-4 col-lg-3">
					<div id="side-navi" class="container">
						<a href="#"><img
							src="/resources/images/iconmonstr-menu-2-240.png" id="menu-img2" /></a>
						<%
							Member m = (Member) session.getAttribute("member");
							if (m != null) {
						%>
<!-- 						<div class="btn-group btn-group-sm ml-3" role="group" aria-label="Basic example">
							<a href="/memberLogout.do" class="btn btn-outline-secondary">로그아웃</a>
							<a href="#" class="btn btn-outline-secondary">마이페이지</a>
						</div> -->
                            <a href="/views/member/memberInfo.jsp"><div class="btn btn-outline-dark" id="join">마이페이지</div></a>
                            <a href="/memberLogout.do"><div class="btn btn-outline-dark" id="login">로그아웃</div></a>
						<!--

						<span id="tooltiptext-user">마이페이지</span> -->
						<%
							} else {
						%>
<!-- 						<div class="btn-group btn-group-sm ml-3" role="group" aria-label="Basic example">
							<a href="/views/member/memberLogin.jsp" class="btn btn-outline-secondary">로그인</a>
							<a href="/views/member/memberJoin.jsp" class="btn btn-outline-secondary">회원가입</a>
						</div> -->
                            <a href="/views/member/memberLogin.jsp"><div class="btn btn-outline-dark" id="login">로그인</div></a>
                            <a href="/views/member/memberJoin.jsp"><div class="btn btn-outline-dark" id="join">회원가입</div></a>
						<%
							}
						%>
					</div>
					<ul id="side-menu">
						<li><a href="/views/board/boardMain.jsp">&nbsp;&nbsp;&nbsp;&nbsp;Q & A</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;신고게시판</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;이용안내</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--    자바 스크립트    -->
	<script type="text/javascript" src="/resources/js/header.js"></script>
</body>
</html>