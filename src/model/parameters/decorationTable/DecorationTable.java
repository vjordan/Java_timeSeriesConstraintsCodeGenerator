package model.parameters.decorationTable;

import java.util.ArrayList;

public class DecorationTable {
	private String name;
	private ArrayList<InstructionInit> instructionsInit;
	private ArrayList<InstructionFinal> instructionsFinal;
	private ArrayList<InstructionTable> instructionsTable;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<InstructionInit> getInstructionsInit() {
		return instructionsInit;
	}
	public void setInstructionsInit(ArrayList<InstructionInit> instructionsInit) {
		this.instructionsInit = instructionsInit;
	}
	public ArrayList<InstructionFinal> getInstructionsFinal() {
		return instructionsFinal;
	}
	public void setInstructionsFinal(ArrayList<InstructionFinal> instructionsFinal) {
		this.instructionsFinal = instructionsFinal;
	}
	public ArrayList<InstructionTable> getInstructionsTable() {
		return instructionsTable;
	}
	public void setInstructionsTable(ArrayList<InstructionTable> instructionsTable) {
		this.instructionsTable = instructionsTable;
	}
	@Override
	public String toString() {
		return "DecorationTable ( \n name=" + name + ", \n instructionsInit=" + instructionsInit + ", \n instructionsFinal="
				+ instructionsFinal + ",\n instructionsTable=" + instructionsTable + "\n  )";
	}

	
	
	

}
