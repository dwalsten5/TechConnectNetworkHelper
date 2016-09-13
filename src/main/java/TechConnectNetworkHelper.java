package main.java;

import java.io.IOException;
import java.util.List;

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



}
