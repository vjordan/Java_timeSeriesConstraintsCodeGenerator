package model.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.FunctionParam;
import model.parameters.decorationTable.Guard;
import model.parameters.decorationTable.InstructionTable;
import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieResults {
	private SeedTemplate seedTemplate;
	private String indentation;
	private DecorationTable decorationTable;

	public GeneratorTimeSerieResults(SeedTemplate seedTemplate, DecorationTable decorationTable) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
		this.decorationTable = decorationTable;
	}

	public void append(StringBuffer generateCodeBuffer) {

		boolean isFirstIf = true;

		generateCodeBuffer.append(this.indentation+"//Code timeSerie results \n");
		for(InstructionTable instruction : this.decorationTable.getInstructionsTable()){

			if (isFirstIf) {
				if(instruction.getAfter() != null){
					generateCodeBuffer.append(this.indentation+"\tif(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\") && this.after =="+instruction.getAfter()+"){ \n");
				}else{
					generateCodeBuffer.append(this.indentation+"\tif(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
				}
				isFirstIf = false;
			} else {
				if(instruction.getAfter() != null){
					generateCodeBuffer.append(this.indentation+"\telse if(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")&& this.after =="+instruction.getAfter()+"){ \n");
				}else{
					generateCodeBuffer.append(this.indentation+"\telse if(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
				}
			}
			if(instruction.getGuards() != null){
				for(Guard guard : instruction.getGuards()){
					if(guard.getUseOther() != null && guard.getUseOther()){
						generateCodeBuffer.append(this.indentation+"\t\tif(this.timeSerieResults.get(\""+guard.getValue()+"\") != null ){ \n");
						if(guard.getAddValue() != null){
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")); \n");
						}
						generateCodeBuffer.append(this.indentation+"\t\t} \n");

					}else if(guard.getFunction() != null && guard.getFunction()){
						if(guard.getValue().equals("phi")){
							generateCodeBuffer.append(this.indentation+"\t\t\tif (this.currentValueIndex >0) {\n");
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature,"+getParameter(guard.getFunparam().get(0),false)+","+getParameter(guard.getFunparam().get(1),false)+")); \n");
							generateCodeBuffer.append(this.indentation+"\t\t\t} else {\n");
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature,"+getParameter(guard.getFunparam().get(0),true)+","+getParameter(guard.getFunparam().get(1),true)+")); \n");
							generateCodeBuffer.append(this.indentation+"\t\t\t}\n");
						}else{
							if(guard.getAddValue() != null){
								generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)"+guard.getAddValue()+"); \n");
							}else{
								generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)); \n");
							}
						}
					}
				}
				for(Guard guard : Reversed.reversed(instruction.getGuards())){
					if(guard.getAddValue() == null){
						if(guard.getUseOther() != null && guard.getUseOther()){
							generateCodeBuffer.append(this.indentation+"\t\tif(this.timeSerieResults.get(\""+guard.getValue()+"\") != null ){ \n");
							if(guard.getAddValue() != null){
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
							}else{
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")); \n");
							}
							generateCodeBuffer.append(this.indentation+"\t\t} else { \n");
							if(guard.getAddValue() != null){
								generateCodeBuffer.append(this.indentation+"\t\tif (this.currentValueIndex >0) {\n");
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentValueIndex-1)"+guard.getAddValue()+"); \n");
								generateCodeBuffer.append(this.indentation+"\t\t} else {\n");
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.initCounters.get(\""+guard.getValue()+"\")"+guard.getAddValue()+"); \n");
								generateCodeBuffer.append(this.indentation+"\t\t}\n");
							}else{
								generateCodeBuffer.append(this.indentation+"\t\tif (this.currentValueIndex >0) {\n");
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentValueIndex-1)); \n");
								generateCodeBuffer.append(this.indentation+"\t\t} else {\n");
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.initCounters.get(\""+guard.getValue()+"\")); \n");
								generateCodeBuffer.append(this.indentation+"\t\t}\n");
							}
							generateCodeBuffer.append(this.indentation+"\t\t}\n");

						}else if(guard.getFunction() != null && guard.getFunction()){
							if(guard.getValue().equals("phi")){
								generateCodeBuffer.append(this.indentation+"\t\t\tif (this.currentValueIndex >0) {\n");
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature,"+getParameter(guard.getFunparam().get(0),false)+","+getParameter(guard.getFunparam().get(1),false)+")); \n");
								generateCodeBuffer.append(this.indentation+"\t\t\t} else {\n");
								generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature,"+getParameter(guard.getFunparam().get(0),true)+","+getParameter(guard.getFunparam().get(1),true)+")); \n");
								generateCodeBuffer.append(this.indentation+"\t\t\t}\n");
							}else{
								if(guard.getAddValue() != null){
									generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)"+guard.getAddValue()+"); \n");
								}else{
									generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)); \n");
								}
							}
						}
					}
				}
			}
			generateCodeBuffer.append(this.indentation+"\t} \n");
		}


	}

	public void setIndentation(String string) {
		this.indentation = string;
	}

	public static class Reversed<T> implements Iterable<T> {
		private final ArrayList<T> original;

		public Reversed(ArrayList<T> original) {
			this.original = original;
		}

		public Iterator<T> iterator() {
			final ListIterator<T> i = original.listIterator(original.size());

			return new Iterator<T>() {
				public boolean hasNext() { return i.hasPrevious(); }
				public T next() { return i.previous(); }
				public void remove() { i.remove(); }
			};
		}

		public static <T> Reversed<T> reversed(ArrayList<T> original) {
			return new Reversed<T>(original);
		}
	}

	private String getParameter(FunctionParam functionParam, boolean firstIndex) {
		if(functionParam.getFunction()){
			String s = functionParam.getValue()+"(";
			if(functionParam.getValue().equals("defaultF")){

			}else{
				s+="feature";
				if(functionParam.getFunparam() != null){
					for(FunctionParam param : functionParam.getFunparam()){
						s+=",";
						s+=getParameter(param,firstIndex);
					}
				}

			}
			s+=")";
			return s;
		} else if(functionParam.isUseOther() && firstIndex){
			String s ="this.initCounters.get(\""+functionParam.getValue()+"\")";
			return s;
		}else if(functionParam.isUseOther()){
			String s ="this.timeSerieCounters.get(\""+functionParam.getValue()+"\").get(this.currentValueIndex-1)";
			return s;
		}else{
			return functionParam.getValue();
		}
	}
}
