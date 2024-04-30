//package com.mm.message.websocket;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.EncodeException;
//import javax.websocket.EndpointConfig;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//
//import com.mm.member.model.vo.Member;
//import com.mm.message.model.vo.Message;
//
////	일반클래스를 웹소켓 서버로 등록하기 위한 방법
//@ServerEndpoint(value="/chatting3.do", decoders = {JsonDecoder.class},
//										encoders = {JsonEncoder.class},
//										configurator = HttpSessionConfigurator.class)
//public class ChattingServer {
////	내부에 클라이언트가 웹소켓 요청하는 내용을 처리하는 메소드 등록
//	private static Map<String, Session> clients = new HashMap(); // 클라이언트 정보 저장
//	
//	@OnOpen
//	public void open(Session session, EndpointConfig config) {
//		HttpSession httpSession = (HttpSession)config.getUserProperties().get("session");
//		Member m = (Member)httpSession.getAttribute("loginUser");
//		System.out.println(m);
//		if(m != null) {
//			session.getUserProperties().put("loginUser", m);
//		}
//		System.out.println("클라이언트 접속..."+session.getId());
//	}
//	
//	@OnMessage
//	public void message(Session session, Message msg) {
//		
//		session.getUserProperties().put("msg", msg);
//		session.getOpenSessions();
//		Set<Session> clients = session.getOpenSessions();
//		for(Session s : clients) {
//			Message clientData = (Message)s.getUserProperties().get("msg");
//			Member loginUser = (Member) s.getUserProperties().get("loginUser");
//			System.out.println(loginUser);
//			if(clientData != null) {
//				String userId = clientData.getSender();
//				if(userId.equals(msg.getReceiver()) || userId.equals(msg.getSender())) {
//					try {
//						s.getBasicRemote().sendObject(msg);
//					} catch (IOException e) {
//						e.printStackTrace();
//					} catch (EncodeException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//	}
//}
