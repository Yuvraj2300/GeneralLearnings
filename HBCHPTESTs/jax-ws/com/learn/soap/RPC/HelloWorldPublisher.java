package com.learn.soap.RPC;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {
	public	static	void	main(String	args[]) {
		System.out.println("Starting service");
		System.out.println();
		Endpoint.publish("http://localhost:8080/ws/hello", new	HelloWorldImpl());
		System.out.println("Service started, check http://localhost:8080/ws/hello?wsdl for WSDL file...");
	}
}
