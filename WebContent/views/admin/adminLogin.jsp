<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- css -->
<link rel="stylesheet" type="text/css" href="/resources/css/login.css" />
</head>
<body>
 <div id="wrap"> <!-- 전체 틀-->
        <div id="contents">
            <div class="container">
                <div id="core-contents-1" class="row">
                   <div class="col-12" style="height: 50px; text-align: left;  background-color: gray; color: white; font-size: 12px;">
                          <img src="/resources/images/logo.png" style="width: 80px;">
                          웹 사이트 관리
                       </div>
                        <div class="col-4" style="margin: 0px auto;">
                        <img class="m-2" src="/resources/images/logo.png" style="width: 300px">
                            <p>goodSeller 관리자 로그인 페이지 입니다.</p>
                        	<form action="/adminLogin.do" method="post">
                            <input type="text" name="userId" placeholder="아이디">
                            <input type="password" name="userPw" placeholder="비밀번호">
                            <input type="submit" class="btn btn-dark" value="로그인" />
                            </form>
                            <div class="col-12">
                               
                            </div>
                            <hr>
                            
                        </div>

                    <div  class="col-12" style="height: 60px; background-color: gray; color: white; font-size: 12px;">
                          사업자 등록번호 : 123-45-678910   서울특별시 영등포구<br>
                          @HotSixMarket Inc.<br>
                          Since 2020.12.24. © HotSix
                       </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>