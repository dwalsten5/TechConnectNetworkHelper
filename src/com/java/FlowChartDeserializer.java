package com.java;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.java.model.ChartComment;
import com.java.model.Edge;
import com.java.model.FlowChart;
import com.java.model.Graph;
import com.java.model.Vertex;
import com.java.model.FlowChart.ChartType;

public class FlowChartDeserializer implements JsonDeserializer<FlowChart> {
	
	@Override
	public FlowChart deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) {
		final JsonObject jsonObject = json.getAsJsonObject();
		Gson gson = new Gson(); //Need a Gson object to complete conversions if needed
		
		final String id = jsonObject.get("_id").getAsString();
		final String name = jsonObject.get("name").getAsString();
		final String desc = jsonObject.get("description").getAsString();
		final String upD = jsonObject.get("updatedDate").getAsString();
		final String v = jsonObject.get("version").getAsString();
		final String owner = jsonObject.get("owner").getAsString();
		
		//Now, getting the resources and comments fields
		final ArrayList<String> all_res = new ArrayList<String>();
		final ArrayList<ChartComment> comments = new ArrayList<ChartComment>();
		for (JsonElement j : jsonObject.get("all_res").getAsJsonArray()) {
			all_res.add(j.getAsString());
		}
		for (JsonElement j : jsonObject.get("comments").getAsJsonArray()) {
			comments.add(gson.fromJson(j,ChartComment.class));
		}
		
		//Adding the new fields which are relevant for devices/problems/other
		
		
		final ChartType type;
		switch (jsonObject.get("type").getAsString()) {
			case "device":
				type = ChartType.DEVICE;
				break;
			case "problem":
				type = ChartType.PROBLEM;
				break;
			default :
				type = ChartType.MISC;
		}
		
		//Now, set all of the fields of the FlowChart object
		final FlowChart flowchart = new FlowChart();
		flowchart.setId(id);;
		flowchart.setName(name);
		flowchart.setDescription(desc);
		flowchart.setUpdatedDate(upD);
		flowchart.setVersion(v);
		flowchart.setOwner(owner);
		flowchart.setAllRes(all_res);
		flowchart.setComments(comments);
		flowchart.setType(type);
		
		//Here are the nullable fields
		final JsonElement image = jsonObject.get("image");
		if (image != JsonNull.INSTANCE) {
			flowchart.setImage(image.getAsString());
		} else {
			flowchart.setImage(null);
		}
		
		final ArrayList<String> resources;
		if (jsonObject.has("resources")) {
			resources = new ArrayList<String>();
			for(JsonElement j : jsonObject.get("resources").getAsJsonArray()) {
				resources.add(j.getAsString());
			}
			flowchart.setResources(resources);
		}
		
		final Graph g;
		if (jsonObject.has("graph")) {
			JsonObject temp_graph = jsonObject.get("graph").getAsJsonObject();
			//This object should have 2 properties, vertices and edges
			JsonArray vertices = temp_graph.get("vertices").getAsJsonArray();
			JsonArray edges = temp_graph.get("edges").getAsJsonArray();
			ArrayList<Vertex> verts = new ArrayList<Vertex>();
			ArrayList<Edge> edg = new ArrayList<Edge>();
			for (JsonElement j: vertices) {
				verts.add(gson.fromJson(j, Vertex.class));
			}
			for (JsonElement j : edges) {
				edg.add(gson.fromJson(j,Edge.class));
			}
			
			g = new Graph(verts,edg);
			flowchart.setGraph(g);
		}
	
		return flowchart;
		
	}

}
