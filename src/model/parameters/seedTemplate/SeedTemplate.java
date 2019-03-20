package model.parameters.seedTemplate;

import java.util.ArrayList;

public class SeedTemplate {
	private String name;
	private String startingState;
	private ArrayList<String> states;
	private ArrayList<Arc> links;
	private int nodeDistance;
	
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartingState() {
		return startingState;
	}

	public void setStartingState(String startingState) {
		this.startingState = startingState;
	}

	public ArrayList<String> getStates() {
		return states;
	}

	public void setStates(ArrayList<String> states) {
		this.states = states;
	}

	public ArrayList<Arc> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Arc> links) {
		this.links = links;
	}

	public int getNodeDistance() {
		return nodeDistance;
	}

	public void setNodeDistance(int nodeDistance) {
		this.nodeDistance = nodeDistance;
	}

	@Override
	    public String toString() {
	        return "SeedTemplate( " +
	                "\n name='" + name + '\'' +
	                ", \n startingState='" + startingState + '\'' +
	                ", \n states=" + states +
	                ", \n links=" + links +
	                ", \n nodeDistance=" + nodeDistance +
	                "\n )";
	    }
}
