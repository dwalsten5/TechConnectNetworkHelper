package main.java;

/**
 * This is a POJO class for the Retrofit Gson converter. Has to have these EXACT fields in order
 * to allow the GraphSONUtility convert from JSON to the Graph structure. This is specifically for Edge
 * @author doranwalsten
 *
 */
public class TCEdge {


	private String details;
	private String _id;
	private String _type;
	private String _outV;
	private String _inV;
	private String _label;
	
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
	return _type;
	}
	
	/**
	* 
	* @param type
	* The _type
	*/
	public void setType(String type) {
	this._type = type;
	}
	
	/**
	* 
	* @return
	* The outV
	*/
	public String getOutV() {
	return _outV;
	}
	
	/**
	* 
	* @param outV
	* The _outV
	*/
	public void setOutV(String outV) {
	this._outV = outV;
	}
	
	/**
	* 
	* @return
	* The inV
	*/
	public String getInV() {
	return _inV;
	}
	
	/**
	* 
	* @param inV
	* The _inV
	*/
	public void setInV(String inV) {
	this._inV = inV;
	}
	
	/**
	* 
	* @return
	* The label
	*/
	public String getLabel() {
	return _label;
	}
	
	/**
	* 
	* @param label
	* The _label
	*/
	public void setLabel(String label) {
	this._label = label;
	}

}
