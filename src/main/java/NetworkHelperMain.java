package main.java;

import java.io.IOException;
import java.util.List;

public class NetworkHelperMain {

	public static void main(String[] args) throws IOException {
		TechConnectNetworkHelper dude = new TechConnectNetworkHelper();
		
		List<FlowChart> flowcharts = dude.getCatalog();
		System.out.println(flowcharts.get(0).getId());
		System.out.println(flowcharts.get(0).getDescription());

	}

}
