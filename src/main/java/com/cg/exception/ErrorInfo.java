package com.cg.exception;

public class ErrorInfo 
{
	String url;
	String message;
	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ErrorInfo(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorInfo [url=" + url + ", message=" + message + "]";
	}
}
