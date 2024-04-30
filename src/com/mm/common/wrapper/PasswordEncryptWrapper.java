package com.mm.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptWrapper extends HttpServletRequestWrapper{

	public PasswordEncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String value = "";
		if(name.equals("userPwd")) {
			value = getSHA512(super.getParameter(name));
		} else {
			value = super.getParameter(name);
		}
		return value;
	}
	private String getSHA512(String val) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(val.getBytes(Charset.forName("UTF-8")));
		return Base64.getEncoder().encodeToString(md.digest());
	}
}