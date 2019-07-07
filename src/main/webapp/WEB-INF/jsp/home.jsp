<%--
  Created by IntelliJ IDEA.
  User: kuro
  Date: 2019-06-18
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String wsPath = "ws://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = (String) request.getSession().getAttribute("WEBSOCKET_USERNAME");
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    This is a WebSocket demo!
</h1>
<div id="message">
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sockjs.min.js"></script>

<textarea id="toUser" placeholder="请输入发送到那个人的id"></textarea>
<textarea id="messageInput"></textarea>
<input id="send" type="submit" value="发送">
<script type="text/javascript">
    $(function(){
        //通过HTTP协议自动建立socket连接，服务端对"/socketServer"和"/sockjs/socketServer"进行拦截
        var sock;
        if ('WebSocket' in window) {
            sock = new WebSocket("<%=wsPath%>socketServer");
        } else if ('MozWebSocket' in window) {
            sock = new MozWebSocket("<%=wsPath%>socketServer");
        } else {
            sock = new SockJS("<%=basePath%>sockjs/socketServer");
        }

        $("#send").click(function (e) {
            sock.send("{\"fromUser\":<%=username%>,\"toUser\":"+$("#toUser").val()+",\"message\":"+$("#messageInput").val()+"}");

        });

        sock.onopen = function (e) {
            console.log(e);
        };
        sock.onmessage = function (e) {
            console.log(e);
            $("#message").append("<p><font color='red'>"+e.data+"</font>");
            $("#message").append("<p><font color='red'><%=wsPath%></font>");
        };
        sock.onerror = function (e) {
            console.log(e);
        };
        sock.onclose = function (e) {
            console.log(e);
        }
    });
</script>
</body>
</html>