package model.generator;

import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieSigns {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorTimeSerieSigns(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code timeSerie signs \n");
		generateCodeBuffer.append(this.indentation+"this.timeSerieSigns = new String[nbElements - 1];\n");
		generateCodeBuffer.append(this.indentation+"for (int i = 0; i < nbElements - 1; i++) {\n");
		generateCodeBuffer.append(this.indentation+"\tif (timeSerie[i] == timeSerie[i+1]) {\n");
		generateCodeBuffer.append(this.indentation+"\t\ttimeSerieSigns[i] = \"=\";\n");
		generateCodeBuffer.append(this.indentation+"\t} else if (timeSerie[i] < timeSerie[i+1]) {\n");
		generateCodeBuffer.append(this.indentation+"\t\ttimeSerieSigns[i] = \"<\";\n");
		generateCodeBuffer.append(this.indentation+"\t} else {\n");
		generateCodeBuffer.append(this.indentation+"\t\ttimeSerieSigns[i] = \">\";\n");
		generateCodeBuffer.append(this.indentation+"\t}\n");
		generateCodeBuffer.append(this.indentation+"}\n");	
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
