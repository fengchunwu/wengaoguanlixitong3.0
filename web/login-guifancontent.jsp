<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>能力规范文稿管理系统</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style type="text/css">
        .header-wrap{
            width:100%;
            height: 50px;
        }

        /*头文件*/
        .header{
            width:1120px;
            margin:0 auto;
            background-color:#cae5ca;
            text-align:center;
            height: 130px;
        }
        .header p{
            font-size:30px;
            line-height: 130px;
        }
        /*登录*/
        .header-login{
        	text-align: right;
            height: 60px;
            width: 1118px;
            margin: 0 auto;
            border:1px solid #ccc;
        	margin-bottom: 20px;

        }
        .user-info{
        	line-height: 60px;
        	font-size: 18px;
        }
        .user-info a{
        	display: inline-block;
        	margin-right: 10px;
        }
        .user-info p{
        	display: inline-block;
        }
        .content{
        	width: 1118px;
        	margin: 0 auto;
        	border-top: none;
        }
        .content-left{
        	width: 260px;
        	height: 680px;
        	display: inline-block;
        }
        .content-right{
        	width: 840px;
        	display: inline-block;
        	float: right;

        }
		.content-left a{
			display: block;
			border:1px solid #C9C9C9;
			height: 50px;
			line-height: 50px;
			font-size: 18px;
			padding-left: 25px;
		}
		.content-left a:hover{
			background-color:#5FB878; 
			color: white;
		}
		.left-a{
			border-top: none;
		}
		.active{
			background-color:#5FB878; 
			color: white;
		}
		.content-right h3{
			height: 40px;
			line-height: 40px;
			border:1px solid #ccc;
			font-size: 16px;
			padding-left: 15px;
		}
		.content-main{
			width: 778px;
			min-height: 620px;
			border:1px solid #ccc;
			border-top: none;
			position: relative;
			padding: 20px 30px 0px 30px;"
		}
		.content-main ul{
			padding-top: 70px;
		}
		.content-main ul li{
			font-size: 20px;
			margin-bottom: 15px;
			margin-left: 150px;
		}
		.content-main li>div{
			display: inline-block;
		}
		.content-main li div:first-child{
			font-size: 18px;
			width: 150px;

		}
		.main-content h2{
			font-size: 30px;
			text-align: center;

		}
		.author-time{
			margin-top: 15px;
			text-align: center;
		}
		.author-time .author{
			font-size: 16px;
		}
	    .author-time .time{
	    	padding-left: 13px;
			font-size: 16px;
		}
		.content-write{
			margin-top: 25px;
			font-size: 16px;
			line-height: 1.7;
			margin-bottom: 30px;
		}
        /*footer*/
        .footer{
            width: 1120px;
            margin: 0 auto;
        }
        .footer p{
            color: black;
            line-height: 50px;
            text-align: center;

        }
    </style>
</head>
<body>
	    <div class="header-wrap">
	        <div class="header">
	            <p>能力规范文稿管理系统</p>
	        </div>
	        <div class="header-login">
				<div class="user-info">
					<p>欢迎您</p>
					<%
					out.println((String)session.getAttribute("name"));
					%>
					<p>!</p>
					<a href="logout.jsp" class="layui-btn layui-btn-nomal">注销</a>
				</div>
	        </div>
	        <div class="content">
	        	<div class="content-left">
					<%@include file="include-left-group.jsp"%>
	        	</div>
	        	<div class="content-right">
	        		<h3>规范详情</h3>
	        		<div class="content-main main-content" >
						<%
							String id = request.getParameter("id");
						%>
						<h2><%out.println( DBHelper.SelectDate("Table_rule","ID",id,"name") );%></h2>
						<div class="author-time">
							<span class="author">作者:<%out.println( DBHelper.SelectDate("Table_rule","ID",id,"author") );%></span>
							<span class="time">时间:<%out.println( DBHelper.SelectDate("Table_rule","ID",id,"time") );%></span>
						</div>
						<div class="content-write" >
							<p><%out.println( DBHelper.SelectDate("Table_rule","ID",id,"essay") );%></p>
						</div>
	        		</div>
	        	</div>
	        </div>
			<div class="footer" style="float:left;width: 100%;">
        		<p>2018-软工导论小学期</p>
   		    </div>	
	    </div>

</body>
</html>