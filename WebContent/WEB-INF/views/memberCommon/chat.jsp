<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<div class="outer">
		<br>
		<h1 align="center">채팅</h1>
		<br>
		<div id="msgContainer">

		</div>
		<input type="text" id="receiver" size="10" placeholder="받는사람">
		<input type="hidden" id="sender" size="10" value="${empty loginUser ? 'admin' : loginUser.userId}">
		<input type="text" id="msg" placeholder="전송할 메세지">
		<button onclick="sendMsg()">전송</button>
	</div>
	<script>
// 		웹소켓 서버에 연결하기
// 		WebSocket객체 생성하기 192.168.30.14
<%-- 		const socket = new WebSocket("ws://192.168.30.14:8083<%= request.getContextPath() %>/chatting.do"); --%>
<%-- 		const socket = new WebSocket("ws://192.168.30.14:8083<%= request.getContextPath() %>/chatting2.do"); --%>
		const socketAddress = new WebSocket("ws://localhost:9000<%= request.getContextPath() %>/chatting3.do");
		let socket = new WebSocket(socketAddress); 
// 		https://localhost:8083/~
// 		http -> ws:localhost:8083/~
// 		https -> wss:localhost:8083/~
		
// 		socket 설정
// 		1. 접속 후 실행되는 이벤트 핸들러 등록하기
		socket.onopen = function(e){
			console.log(e);
			console.log("웹 소켓 접속 성공");
		}
// 		2. 웹소켓 서버에서 sendText/sendobject메소드를 호출하면 실행되는 함수
		socket.onmessage = function(e){
			console.log('메세지 수신');
// 			수신된 데이터는 이벤트 객체의 data속성에 담겨있음
			console.log(e.data);
			const msg = JSON.parse(e.data); // jsonobject로 전달된 메세지 파싱
			if(msg["sender"] == $("#sender").val()){
				$("#msgContainer").append($("<p>").text("["+msg["sender"]+"]"+msg["msg"]).css("text-align","left"));
			} else {
				$("#msgContainer").append($("<p>").text("["+msg["sender"]+"]"+msg["msg"]).css("text-align","right"));
				
			}
		}
// 		4. 웹소켓세션이 종료될 때
		socket.onclose = function(e){
// 			웹소켓 재연결
			setTimeout(function(){
				socket = new WebSocket(socketAddress);
			}, 1000);
		}
				
// 		3. 웹소켓 서버에 메세지를 전송하는 함수
		const sendMsg = () => {
// 			전송할 메세지 세팅
// 			메세지를 전송하는 함수 : socket.send(데이터);
// 			발송자, 수신자, 메세지 내용
// 			const msg = {
// 					sender : $("#sender").val(),
// 					receiver : $("#receiver").val(),
// 					msg : $("#msg").val()
// 			};
			const msg = new Message($("#sender").val(), $("#receiver").val(), $("#msg").val());
			// 반드 시 문자열 형태로 전달하기위해 JSON객체로 변환 후 전송
			socket.send(JSON.stringify(msg));
		}
		
// 		function Message(sender, receiver, msg){
// 			this.sender = sender;
// 			this.receiver = receiver;
// 			this.msg = msg;
// 		}
		class Message {
			constructor(sender, recevier, msg){
				this.sender = sender;
				this.recevier = recevier;
				this.msg = msg;
			}
		}
		
		</script>

</body>
</html>