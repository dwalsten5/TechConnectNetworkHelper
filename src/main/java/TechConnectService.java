package main.java;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Catalog;
import main.java.model.ChartComment;
import main.java.model.FlowChart;
import main.java.model.JsendResponse;
import main.java.model.LoginResponse;
import main.java.model.LoginAttempt;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TechConnectService {
	
	//Define all of the headers which are needed for the communication here
	//Initially defined as null
	@Headers({
		"X-Auth-Token: ",
		"X-User-Id: "
	})
	
	//Just want to get the catalog, no input needed
	@GET("api/v1/catalog") //CHANGE FOR THE REAL THING! This was for testing
	Call<JsendResponse> catalog();
	
	@GET("api/v1/chart/{id}")
	Call<JsendResponse> flowchart(@Path("id") String id); 
	
	@POST("api/v1/charts")
	Call<JsendResponse> flowcharts(@Body String[] ids);
	//This String ids is a comma separated list of the ids desired
	
	//Login the user
	@POST("api/v1/login")
	Call<JsendResponse> login(@Body LoginAttempt la);
	
	//Logout the user. I don't think that I need to pass in anything? Maybe the user?
	@POST("api/v1/logout")
	Call<JsendResponse> logout(@Header("X-Auth-Token") String auth_token, @Header("X-User-Id") String userId);
	
	//Attempts to post a comment onto a chart or node with id id.
	@POST("api/v1/chart/{id}/comment")
	Call<JsendResponse> comment(@Header("X-Auth-Token") String auth_token, @Header("X-User-Id") String userId, @Body ChartComment comment);

}
