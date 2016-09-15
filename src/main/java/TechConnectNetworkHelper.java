package main.java;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import main.java.model.FlowChart;
import main.java.model.Login;
import main.java.model.LoginAttempt;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class TechConnectNetworkHelper {
	
	//First, I need  a Retrofit object which is able to understand JSON
	
	public static final String BASE_URL = "http://127.0.0.1:8000"; //This is the base url of the directory we will talk to
	
	private Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
			addConverterFactory(GsonConverterFactory.create()).build();
	private TechConnectService service = retrofit.create(TechConnectService.class);
	
	//Default constructor
	public TechConnectNetworkHelper() {
		
	}
	
	public List<FlowChart> getCatalog() throws IOException {
		//Call and get a response 
		List<FlowChart> flowcharts = service.catalog().execute().body().getFlowCharts();
		return flowcharts;
	}
	
	public FlowChart getChart(int id) throws IOException {
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
	public List<FlowChart> getCharts(int[] ids) throws IOException {
		String query = "";
		for (int i = 0; i < ids.length - 1 ; i++) {
			query = query + String.format("%d,", ids[i]);
		}
		query = query + String.format("%d", ids[ids.length - 1]);
		return service.flowcharts(query).execute().body();
		
		
	}
	
	//I have no clue how this should be done at all just threw something together.
	public boolean login(LoginAttempt l, Login user) throws IOException {
		Response<Login> resp = service.login(l).execute();
		user = resp.body();
		return resp.isSuccessful();
	}
	
	public boolean logout() throws IOException {
		Response<Login> resp = service.logout().execute();
		return resp.isSuccessful();
	}



}
