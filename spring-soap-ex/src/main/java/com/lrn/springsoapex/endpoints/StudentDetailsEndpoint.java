package com.lrn.springsoapex.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost._8080.students.GetStudentDetailsRequest;
import localhost._8080.students.GetStudentDetailsResponse;
import localhost._8080.students.StudentDetails;

@Endpoint
public class StudentDetailsEndpoint {

	@PayloadRoot(namespace = "http://localhost:8080/students", localPart = "GetStudentDetailsRequest")
	@ResponsePayload
	public GetStudentDetailsResponse processDetailsReq(@RequestPayload GetStudentDetailsRequest request) {
		GetStudentDetailsResponse response = new GetStudentDetailsResponse();

		StudentDetails details = new StudentDetails();
		details.setId(request.getId());
		details.setName("John");
		details.setPassportNumber("E232RE321");
		response.setStudentDetails(details);

		return response;
	}
}
