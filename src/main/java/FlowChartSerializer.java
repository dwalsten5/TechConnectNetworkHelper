package main.java;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import main.java.model.ChartComment;
import main.java.model.FlowChart;
import main.java.model.Vertex;

//This class is needed in order to write this information, so let's get this shit going
public class FlowChartSerializer implements JsonSerializer<FlowChart> {

	public JsonElement serialize(FlowChart flowchart, Type typeOfId, JsonSerializationContext context) {
		Gson myGson = new Gson();
		final JsonObject jsonObject = new JsonObject();//This is the new object which will be written to the file
		jsonObject.addProperty("_id", flowchart.getId());
		jsonObject.addProperty("name", flowchart.getName());
		jsonObject.addProperty("description", flowchart.getDescription());
		jsonObject.addProperty("updatedDate", flowchart.getUpdatedDate());
		jsonObject.addProperty("version", flowchart.getVersion());
		jsonObject.addProperty("owner", flowchart.getOwner());
	
		//Determine type
		switch(flowchart.getType()) {
			case DEVICE:
				jsonObject.addProperty("type", "device");
				break;
			case PROBLEM:
				jsonObject.addProperty("type", "problem");
			default :
				jsonObject.addProperty("type", "misc");
		}
		
		//Now, we get to have fun with the other objects
		//Resources
		final JsonArray all_res = new JsonArray();
		
		//Comments
		final JsonArray comments = new JsonArray();
		if (flowchart.getComments() != null) {
			for (ChartComment c : flowchart.getComments()) {
				comments.add(myGson.toJson(c));
			}
			jsonObject.add("comments", comments);
		}
		
		//Now, we have to convert the TinkerGraph, which is beautiful
		JsonObject graph = new JsonObject();
		JsonArray vertices = new JsonArray();
        //JsonArray edges = new JsonArray();
        for (Vertex v : flowchart.getGraph().getVertices()) {
        	for (String res : v.getResources()) {
        		all_res.add(res);
        	}
        	vertices.add(myGson.toJson(v,Vertex.class));
        }
        //Now that I've parsed over the graph, I'll have the resources! What a concept!
		jsonObject.add("all_res", all_res);
        graph.add("vertices", vertices);
        graph.add("edges", myGson.toJsonTree(flowchart.getGraph().getEdges())); //Trying a more direct call
        jsonObject.add("graph", graph);
        
        //Checking to see if there any of the optional fields are present
        if (flowchart.getImage() != null) {
        	jsonObject.addProperty("image", flowchart.getImage());
        }
        if(flowchart.getResources() != null) {
        	JsonElement res = myGson.toJsonTree(flowchart.getResources());
        	jsonObject.add("resources", res); //Just to try it out, haha!
        }
		return jsonObject;
	}
}
