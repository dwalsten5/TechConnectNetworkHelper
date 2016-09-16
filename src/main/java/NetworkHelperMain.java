package main.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.gson.Gson;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONReader;

import main.java.model.FlowChart;
import main.java.model.LoginAttempt;
import main.java.model.TCGraph;

public class NetworkHelperMain {
	//Need to use this guy to make major operations
	public static Gson gson = new Gson();

	public static void main(String[] args) throws IOException {
		TechConnectNetworkHelper dude = new TechConnectNetworkHelper();
		
		Graph real_graph = new TinkerGraph();
		GraphSONReader reader = new GraphSONReader(real_graph);
		
		//Try out logging in to the site
		LoginAttempt la = new LoginAttempt();
		la.setEmail("dwalste1@jhu.edu");
		la.setPassword("dwalsten");
		if (dude.login(la) ) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("Failure");
		}
		
		//Test out the capabilities of Retrofit to read the catalog - FUNCTIONAL!
		
		List<FlowChart> flowcharts = dude.getCatalog();
		System.out.println(flowcharts.get(0).getId());
		System.out.println(flowcharts.get(0).getDescription());
		
		
		//Test the simple flowchart get method - FUNCTIONAL!
		
		FlowChart important = dude.getChart("testchart99999999");
		System.out.println(important.getName());
		System.out.println(important.getDescription());
		//Convert TCGraph to the TinkerGraph
		convertToGraphSON(reader,important.getGraph());
		
		for(Vertex v : real_graph.getVertices()) {
			//Use the GraphSONUtility to convert and add each vertex the graph?
			for (String key: v.getPropertyKeys()) {
				System.out.println(v.getProperty(key).toString());
			}
		}
		for(Edge e: real_graph.getEdges()) {
			System.out.println(e.getLabel());
			System.out.println(e.getVertex(Direction.OUT));
			System.out.println(e.getVertex(Direction.IN));
		}
		
		
		
		
		//Then logout
		if (dude.logout()) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}
		
		

	}
	
	/**
	 * This function is used to convert between our graph representation and that of 
	 * GraphSON in the blueprints library (in case we decide to stick with it)
	 * @param g1 - The GraphSONReader object which we will write to to generate the graph
	 * Note: This read must have been initialized with the target graph before this function call
	 * in order for the inputGraph call to work
	 * @param g2 - The TCGraph object we created initially and will be converting
	 */
	private static void convertToGraphSON(GraphSONReader reader, TCGraph g2) throws IOException {
		InputStream stream = new ByteArrayInputStream(gson.toJson(g2).getBytes());
		reader.inputGraph(stream);
	}

}
