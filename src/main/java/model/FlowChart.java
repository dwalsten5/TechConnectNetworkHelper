package main.java.model;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;

public class FlowChart {

private String _id;
private String name;
private String description;
private String updateDate;
private String version;
private String owner;
private TCGraph graph; //Change this to a Graph Type at some point

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
* The id
*/
public void setId(String id) {
this._id = id;
}

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
* The description
*/
public String getDescription() {
return description;
}

/**
* 
* @param description
* The description
*/
public void setDescription(String description) {
this.description = description;
}

/**
* 
* @return
* The updateDate
*/
public String getUpdateDate() {
return updateDate;
}

/**
* 
* @param updateDate
* The updateDate
*/
public void setUpdateDate(String updateDate) {
this.updateDate = updateDate;
}

/**
* 
* @return
* The version
*/
public String getVersion() {
return version;
}

/**
* 
* @param version
* The version
*/
public void setVersion(String version) {
this.version = version;
}

/**
* 
* @return
* The author
*/
public String getAuthor() {
return owner;
}

/**
* 
* @param author
* The author
*/
public void setAuthor(String author) {
this.owner = author;
}

/**
* 
* @return
* The graph
*/
public TCGraph getGraph() {
return graph;
}

/**
* 
* @param graph
* The graph
*/
public void setGraph(TCGraph graph) {
	this.graph = graph;
}

}
