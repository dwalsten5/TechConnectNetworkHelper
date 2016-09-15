package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a POJO class for the Retrofit Gson converter. Has to have these EXACT fields in order
 * to allow the GraphSONUtility convert from JSON to the Graph structure. This is for the Graph interface
 * @author doranwalsten
 *
 */
public class TCGraph {

	private String mode;
	private List<Node> vertices = new ArrayList<Node>();
	private List<TCEdge> edges = new ArrayList<TCEdge>();
	
	/**
	* 
	* @return
	* The mode
	*/
	public String getMode() {
	return mode;
	}
	
	/**
	* 
	* @param mode
	* The mode
	*/
	public void setMode(String mode) {
	this.mode = mode;
	}
	
	/**
	* 
	* @return
	* The vertices
	*/
	public List<Node> getVertices() {
	return vertices;
	}
	
	/**
	* 
	* @param vertices
	* The vertices
	*/
	public void setVertices(List<Node> vertices) {
	this.vertices = vertices;
	}
	
	/**
	* 
	* @return
	* The edges
	*/
	public List<TCEdge> getEdges() {
	return edges;
	}
	
	/**
	* 
	* @param edges
	* The edges
	*/
	public void setEdges(List<TCEdge> edges) {
	this.edges = edges;
	}

}