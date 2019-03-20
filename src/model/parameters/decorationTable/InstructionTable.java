package model.parameters.decorationTable;

import java.util.ArrayList;

public class InstructionTable {
	private String step;
	private String after;
	private ArrayList<Guard> guards;
	private ArrayList<Update> updates;
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getAfter() {
		return after;
	}
	public void setAfter(String after) {
		this.after = after;
	}
	public ArrayList<Guard> getGuards() {
		return guards;
	}
	public void setGuards(ArrayList<Guard> guards) {
		this.guards = guards;
	}
	public ArrayList<Update> getUpdates() {
		return updates;
	}
	public void setUpdates(ArrayList<Update> updates) {
		this.updates = updates;
	}
	@Override
	public String toString() {
		return "( \n" + step + ", " +  after + ", " + guards + ", " + updates
				+ ")";
	}
	

}
