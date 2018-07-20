package com.learn.soap.RPC;

import javax.jws.WebService;

@WebService(endpointInterface = "com.learn.soap.RPC.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldMessage(String name) {
		// TODO Auto-generated method stub
		return "Hello from " + name;
	}

}
