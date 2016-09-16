package main.java;

import java.io.IOException;
import java.util.List;


import main.java.model.Data;
import main.java.model.FlowChart;
import main.java.model.LoginAttempt;
import main.java.model.LoginResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class TechConnectNetworkHelper {
	
	//First, I need  a Retrofit object which is able to understand JSON
	
	//public static final String BASE_URL = "http://127.0.0.1:8000"; //This is the base url of the directory we will talk to
	public static final String BASE_URL = "http://localhost:3000/";
	private Data user; 
	
	private Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	private TechConnectService service = retrofit.create(TechConnectService.class);
	
	
	
	//Default constructor
	public TechConnectNetworkHelper() {
		
	}
	
	public List<FlowChart> getCatalog() throws IOException {
		//Call and get a response 
		List<FlowChart> flowcharts = service.catalog().execute().body().getFlowCharts();
		return flowcharts;
	}
	
	public FlowChart getChart(String id) throws IOException {
		return service.flowchart(id).execute().body();
	}
	
	/**
	 * This function is used to get a list of specific charts. This list must be sent to
	 * Retrofit as a comma separated list of ids as a String. This converts from a list of integers
	 * for now. May not want that format in the future, but it's a place to start.
	 * @param ids
	 * @return
	 * @throws IOException
	 */
	public List<FlowChart> getCharts(String ids) throws IOException {
		return service.flowcharts(ids).execute().body();
		
		
	}
	
	//I have no clue how this should be done at all just threw something together.
	public boolean login(LoginAttempt l) throws IOException {
		Response<LoginResponse> resp = service.login(l).execute();
		System.out.println("HERE!");
		if (resp.isSuccessful()) {
			user = resp.body().getData();
		} 
		return resp.isSuccessful();
	}
	
	public boolean logout() throws IOException {
		//Logout, using the current authroization keys
		if (user != null) {
			Response<LoginResponse> resp = service.logout(user.getAuthToken(),user.getUserId()).execute();
			return resp.isSuccessful();
		}
		return false;
		
	}



}
