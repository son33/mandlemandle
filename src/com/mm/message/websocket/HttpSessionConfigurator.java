package com.mm.message.websocket;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpSessionConfigurator extends Configurator{

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		super.modifyHandshake(sec, request, response);
		HttpSession session = (HttpSession)request.getHttpSession();
	    ServletContext context = session.getServletContext();
	    sec.getUserProperties().put("session", session);
	    sec.getUserProperties().put("context", context);
	}
}
