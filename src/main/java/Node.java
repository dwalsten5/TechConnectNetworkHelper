package main.java;

import java.util.ArrayList;
import java.util.List;
/**
 * This is a POJO class for the Retrofit Gson converter. Has to have these EXACT fields in order
 * to allow the GraphSONUtility convert from JSON to the Graph structure. This is specifically for Vertex
 * @author doranwalsten
 *
 */
public class Node {


	private String name;
	private String details;
	private List<String> resources = new ArrayList<String>();
	private List<String> images = new ArrayList<String>();
	private String _id;
	private String type;
	
	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
	return name;
	}
	
	/**
	* 
	* @param name
	* The name
	*/
	public void setName(String name) {
	this.name = name;
	}
	
	/**
	* 
	* @return
	* The details
	*/
	public String getDetails() {
	return details;
	}
	
	/**
	* 
	* @param details
	* The details
	*/
	public void setDetails(String details) {
	this.details = details;
	}
	
	/**
	* 
	* @return
	* The resources
	*/
	public List<String> getResources() {
	return resources;
	}
	
	/**
	* 
	* @param resources
	* The resources
	*/
	public void setResources(List<String> resources) {
	this.resources = resources;
	}
	
	/**
	* 
	* @return
	* The images
	*/
	public List<String> getImages() {
	return images;
	}
	
	/**
	* 
	* @param images
	* The images
	*/
	public void setImages(List<String> images) {
	this.images = images;
	}
	
	/**
	* 
	* @return
	* The id
	*/
	public String getId() {
	return _id;
	}
	
	/**
	* 
	* @param id
	* The _id
	*/
	public void setId(String id) {
	this._id = id;
	}
	
	/**
	* 
	* @return
	* The type
	*/
	public String getType() {
	return type;
	}
	
	/**
	* 
	* @param type
	* The _type
	*/
	public void setType(String type) {
	this.type = type;
	}
}