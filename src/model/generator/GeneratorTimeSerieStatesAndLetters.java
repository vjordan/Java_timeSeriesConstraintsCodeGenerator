package model.generator;

import model.parameters.seedTemplate.Arc;
import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieStatesAndLetters {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorTimeSerieStatesAndLetters(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		
		boolean isFirstIf = true;
		
		generateCodeBuffer.append(this.indentation+"//Code timeSerie states \n");
		for(Arc arc :this.seedTemplate.getLinks()) {
			if (isFirstIf) {
				generateCodeBuffer.append(this.indentation+"\tif (this.currentState.equals(\""+arc.getFrom()+"\") && \""+arc.getSigLabel()+"\".contains(this.timeSerieSigns[currentSignIndex])){\n");
				isFirstIf = false;
			} else {
				generateCodeBuffer.append(this.indentation+"\telse if (this.currentState.equals(\""+arc.getFrom()+"\") && \""+arc.getSigLabel()+"\".contains(this.timeSerieSigns[currentSignIndex])){\n");
			}
			generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieStates[currentValueIndex] = \""+arc.getTo()+"\";\n");
			generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieLetters[currentSignIndex] = \""+arc.getLetter()+"\";\n");
			generateCodeBuffer.append(this.indentation+"\t\tthis.currentState = this.timeSerieStates[currentValueIndex] ;\n");
			generateCodeBuffer.append(this.indentation+"\t}\n");
		};	
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
