<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

div {
	box-sizing: border-box;
}
.contentWrapper
{
margin:0px;
width: 100%;
}

    #navigation>ul>li>a {
	text-decoration: none;
	color: black;
	width:100%;
	height: 100%;
	display: block;
	}

    #navigation>ul>li>aa:hover {
	border-bottom: 2px solid #5B5AFF;
	color: #5B5AFF;
	}

    #navigation {
        padding: 0px;
        margin: 0px;
        width:100%;
        height:100%;
        background-color: ghostwhite;
    }
    
    #navigation>ul {
        padding: 0px;
        margin: 0px;
        width:100%;
    }
    
    
    #navigation>ul>li {
        list-style-type: none;
        text-align: left;
        color: black;
        padding: 10px;
    }
    
     #navigation>ul>li:hover {
        background-color: whitesmoke;
        color: black;
    }
    
    .menu>a:hover {
       color: black;
    }
    
    .hide {
        display: none;
        list-style-type: none;
        margin-top: 10px;
    }
    
    .hide>li {
        padding: 1px;
    }
    #fixedNavi
    {   
        display: inline-block;
  		position: sticky;
  		top:0px;
    }
</style>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
     $(document).ready(function(){
        // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
        $(".menu>a").click(function(){
            var submenu = $(this).next("ul");
 
            // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
    });
</script>

            <div id="naviContents" class="row m-0" style="height: 100%;">
                <div id="navigation">
                    <ul id="fixedNavi">
                        <li class="menu">
                           <a>회원관리</a>
                            <ul class="hide">
                                <li >전체 회원 관리</li><hr>
                                <li>탈퇴 회원 관리</li><hr>
                                <li>관리자</li>
                            </ul>
                        </li><hr>
                        <li><a href="/admincsBoardAllPageList.do">게시물 관리</a></li><hr>
                        <li><a href="/adminReportAllPageList.do">신고 관리</a></li><hr>
                        <li>QnA</li><hr>
                        <li class="menu">
                          <a>통계</a>
                            <ul class="hide">
                                <li>수익현황</li>
                            </ul>
                        </li>
                        
                    </ul>
                </div>
            </div>
</body>
</html>