package model.generator;

public class GeneratorListToString {
	public static void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append("\t//Code list to string \n");
		generateCodeBuffer.append("\tpublic String listToString(int[] list){\n");
		generateCodeBuffer.append("\t\tString res=\"[\";\n");
		generateCodeBuffer.append("\t\tfor(int i=0;i<list.length;i++){\n");
		generateCodeBuffer.append("\t\t\tif (i < list.length-1) {\n");
		generateCodeBuffer.append("\t\t\t\tres+=list[i]+\", \";\n");
		generateCodeBuffer.append("\t\t\t} else {\n");
		generateCodeBuffer.append("\t\t\t\tres+=list[i];\n");
		generateCodeBuffer.append("\t\t\t}\n");
		generateCodeBuffer.append("\t\t}\n");
		generateCodeBuffer.append("\t\tres+=\"]\";\n");
		generateCodeBuffer.append("\t\treturn res;\n");
		generateCodeBuffer.append("\t}\n");	
		generateCodeBuffer.append("\t//Code list to string \n");
		generateCodeBuffer.append("\tpublic String listToString(String[] list){\n");
		generateCodeBuffer.append("\t\tString res=\"[\";\n");
		generateCodeBuffer.append("\t\tfor(int i=0;i<list.length;i++){\n");
		generateCodeBuffer.append("\t\t\tif (i < list.length-1) {\n");
		generateCodeBuffer.append("\t\t\t\tres+=list[i]+\", \";\n");
		generateCodeBuffer.append("\t\t\t} else {\n");
		generateCodeBuffer.append("\t\t\t\tres+=list[i];\n");
		generateCodeBuffer.append("\t\t\t}\n");
		generateCodeBuffer.append("\t\t}\n");
		generateCodeBuffer.append("\t\tres+=\"]\";\n");
		generateCodeBuffer.append("\t\treturn res;\n");
		generateCodeBuffer.append("\t}\n");	
	}
}
