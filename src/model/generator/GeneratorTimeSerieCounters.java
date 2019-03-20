package model.generator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.FunctionParam;
import model.parameters.decorationTable.Guard;
import model.parameters.decorationTable.InstructionTable;
import model.parameters.decorationTable.Update;
import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieCounters {
	private SeedTemplate seedTemplate;
	private String indentation;
	private DecorationTable decorationTable;

	public GeneratorTimeSerieCounters(SeedTemplate seedTemplate, DecorationTable decorationTable) {
		this.seedTemplate = seedTemplate;
		this.decorationTable = decorationTable;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {

		boolean isFirstIf = true;

		generateCodeBuffer.append(this.indentation+"//Code timeSerie counters \n");
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
						//generateCodeBuffer.append(this.indentation+"this.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")); \n");
						generateCodeBuffer.append(this.indentation+"\t\tif(this.timeSerieResults.get(\""+guard.getValue()+"\") != null ){ \n");
						if(guard.getAddValue() != null){
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")); \n");
						}
						generateCodeBuffer.append(this.indentation+"\t\t}else{ \n");
						if(guard.getAddValue() != null){
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")); \n");
						}
						generateCodeBuffer.append(this.indentation+"\t\t} \n");

					}else if(guard.getFunction() != null && guard.getFunction()){
						if(guard.getValue().equals("phi")){
							generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature,"+getParameter(guard.getFunparam().get(0))+","+getParameter(guard.getFunparam().get(1))+")); \n");
						}else{
							if(guard.getAddValue() != null){
								generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)"+guard.getAddValue()+"); \n");
							}else{
								generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)); \n");
							}
						}

					}else{
						if(guard.getAddValue() != null){
							generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+""+guard.getAddValue()+"); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"); \n");
						}
					}
				}
			}
			if(instruction.getUpdates() != null){
				for(Update update : instruction.getUpdates()){
					if(update.getFunction() != null && update.getFunction()){
						if(update.getValue().equals("phi")){
							generateCodeBuffer.append(this.indentation+"\t\tthis.currentCounters.replace(\""+update.getVar()+"\","+update.getValue()+"(feature,"+getParameter(update.getFunparam().get(0))+","+getParameter(update.getFunparam().get(1))+")); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\tthis.currentCounters.replace(\""+update.getVar()+"\","+update.getValue()+"(feature)); \n");
						}

					}else {
						if(update.getAddValue() != null){
							generateCodeBuffer.append(this.indentation+"\t\tthis.currentCounters.replace(\""+update.getVar()+"\",this.currentCounters.get(\""+update.getVar()+"\")"+update.getAddValue()+"); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\tthis.currentCounters.replace(\""+update.getVar()+"\",this.currentCounters.get(\""+update.getVar()+"\")); \n");	
						}
					}
					generateCodeBuffer.append(this.indentation+"\t\tfor(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ \n");
					generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieCounters.get(\""+update.getVar()+"\").set(i,this.currentCounters.get(\""+update.getVar()+"\")); \n");
					generateCodeBuffer.append(this.indentation+"\t\t} \n");
				}
			}
			generateCodeBuffer.append(this.indentation+"\t} \n");
		}
	}

	private String getParameter(FunctionParam functionParam) {
		if(functionParam.getFunction()){
			String s = functionParam.getValue()+"(";
			if(functionParam.getValue().equals("defaultF")){

			}else{
				s+="feature";
				if(functionParam.getFunparam() != null){
					for(FunctionParam param : functionParam.getFunparam()){
						s+=",";
						s+=getParameter(param);
					}
				}

			}
			s+=")";
			return s;
		} else if(functionParam.isUseOther()){
			String s ="this.currentCounters.get(\""+functionParam.getValue()+"\")";
			return s;
		}else{
			return functionParam.getValue();
		}
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
