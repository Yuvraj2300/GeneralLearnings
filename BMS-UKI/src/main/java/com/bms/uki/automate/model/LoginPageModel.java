package com.bms.uki.automate.model;

public class LoginPageModel {
	private static	String username;
	private	static 	String resultsLocation;
	private static	String reportLink;

	public String getResultsLocation() {
		return resultsLocation;
	}

	public void setResultsLocation(String resultsLocation) {
		LoginPageModel.resultsLocation = resultsLocation;
	}

	public String getReportLink() {
		return reportLink;
	}

	public void setReportLink(String reportLink) {
		LoginPageModel.reportLink = reportLink;
	}

	public LoginPageModel() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		LoginPageModel.username = username;
	}

}
