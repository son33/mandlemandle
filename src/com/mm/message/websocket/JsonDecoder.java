package com.mm.message.websocket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder.Text;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.mm.message.model.vo.Message;

public class JsonDecoder implements Text<Message>{

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public Message decode(String msg) throws DecodeException { // 클라이언트가 send를 보내면 decode 시킴
		return new Gson().fromJson(msg, Message.class);
	}

	@Override
	public boolean willDecode(String msg) {
		return true;
	}
}
