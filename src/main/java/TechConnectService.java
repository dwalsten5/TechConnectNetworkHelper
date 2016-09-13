package main.java;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TechConnectService {
	//Just want to get the catalog, no input needed
	@GET("api/v1/catalog.json")
	Call<Catalog> catalog();

}
