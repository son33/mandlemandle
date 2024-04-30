package com.mm.message.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.mm.message.model.vo.Message;

public class JsonEncoder implements Text<Message>{

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public String encode(Message msg) throws EncodeException {
		return new Gson().toJson(msg);
	}
}
