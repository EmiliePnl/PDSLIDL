package fr.pds.floralis.commons.bean.entity;

/**
 * Floor 
 * The entity made to map the Floor object and map it to JSON with the toJSON
 * 
 * @author alveslaura
 *
 */

public class Floor {
	
	private int id;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Floor() {

	}
	
	public Floor(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "{ \"id\" : " + id + ", \"name\" : \"" + name + "\"}";
	}

}
