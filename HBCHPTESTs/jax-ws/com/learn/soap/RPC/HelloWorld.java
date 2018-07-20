package com.learn.soap.RPC;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface HelloWorld {

	/*@WebMethod
	public	String	getHelloWorldMessage();*/
	
	@WebMethod
	public	String	getHelloWorldMessage(String	name);
	
}
