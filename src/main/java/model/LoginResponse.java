package main.java.model;


public class LoginResponse {

	private String status;
	private Data data;
	private String message;

	/**
	* 
	* @return
	* The status
	*/
	public String getStatus() {
	return status;
	}
	
	/**
	* 
	* @param status
	* The status
	*/
	public void setStatus(String status) {
	this.status = status;
	}
	
	/**
	* 
	* @return
	* The data
	*/
	public Data getData() {
	return data;
	}
	
	/**
	* 
	* @param data
	* The data
	*/
	public void setData(Data data) {
	this.data = data;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String m) {
		this.message = m;
	}

}