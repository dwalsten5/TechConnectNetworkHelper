package main.java;


public class FlowChart {

private String id;
private String name;
private String description;
private String updateDate;
private String version;
private String author;
private Object graph; //Change this to a Graph Type at some point

/**
* 
* @return
* The id
*/
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(String id) {
this.id = id;
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
return author;
}

/**
* 
* @param author
* The author
*/
public void setAuthor(String author) {
this.author = author;
}

/**
* 
* @return
* The graph
*/
public Object getGraph() {
return graph;
}

/**
* 
* @param graph
* The graph
*/
public void setGraph(Object graph) {
this.graph = graph;
}

}
