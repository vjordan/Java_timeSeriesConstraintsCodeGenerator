package model.generator;

public class GeneratorFeatureFunctions {

	public static void append(StringBuffer generateCodeBuffer) {
        generateCodeBuffer.append("\n\tprivate int neutral(String feature) {\n");
        generateCodeBuffer.append("\t\tswitch(feature) {\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_ONE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_WIDTH:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_SURFACE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MAX:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MIN_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MIN:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MAX_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_RANGE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tdefault:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t}\n");
        generateCodeBuffer.append("\t}\n");

        generateCodeBuffer.append("\n\tprivate int min(String feature) {\n");
        generateCodeBuffer.append("\t\tswitch(feature) {\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_ONE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_WIDTH:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_SURFACE:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MIN_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MAX:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MIN_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MIN:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MIN_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_RANGE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tdefault:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t}\n");
        generateCodeBuffer.append("\t}\n");

        generateCodeBuffer.append("\n\tprivate int max(String feature) {\n");
        generateCodeBuffer.append("\t\tswitch(feature) {\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_ONE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 1;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_WIDTH:\n");
        generateCodeBuffer.append("\t\t\t\treturn this.timeSerie.length + 1;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_SURFACE:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MAX_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MAX:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MAX_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MIN:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MAX_VALUE;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_RANGE:\n");
        generateCodeBuffer.append("\t\t\t\treturn Integer.MAX_VALUE;\n");
        generateCodeBuffer.append("\t\t\tdefault:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0; \n");
        generateCodeBuffer.append("\t\t}\n");
        generateCodeBuffer.append("\t}\n");

        generateCodeBuffer.append("\n\tprivate int phi(String feature, int param1, int param2) {\n");
        generateCodeBuffer.append("\t\tswitch(feature) {\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_ONE:\n");
        generateCodeBuffer.append("\t\t\t\treturn Math.max(param1, param2);\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_WIDTH:\n");
        generateCodeBuffer.append("\t\t\t\treturn param1 + param2;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_SURFACE:\n");
        generateCodeBuffer.append("\t\t\t\treturn param1 + param2;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MAX:\n");
        generateCodeBuffer.append("\t\t\t\treturn Math.max(param1, param2);\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MIN:\n");
        generateCodeBuffer.append("\t\t\t\treturn Math.min(param1, param2);\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_RANGE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tdefault:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t}\n");
        generateCodeBuffer.append("\t}\n");

        generateCodeBuffer.append("\n\tprivate int delta(String feature) {\n");
        generateCodeBuffer.append("\t\tswitch(feature) {\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_ONE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 1;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_WIDTH:\n");
        generateCodeBuffer.append("\t\t\t\treturn 1;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_SURFACE:\n");
        generateCodeBuffer.append("\t\t\t\treturn this.timeSerie[this.currentValueIndex];\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MAX:\n");
        generateCodeBuffer.append("\t\t\t\treturn this.timeSerie[this.currentValueIndex];\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MIN:\n");
        generateCodeBuffer.append("\t\t\t\treturn this.timeSerie[this.currentValueIndex];\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_RANGE:\n");
        generateCodeBuffer.append("\t\t\t\treturn this.timeSerie[this.currentValueIndex];\n");
        generateCodeBuffer.append("\t\t\tdefault:\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t}\n");
        generateCodeBuffer.append("\t}\n");
        
        generateCodeBuffer.append("\n\tprivate int deltaPrime(String feature) {\n");
        generateCodeBuffer.append("\t\tswitch(feature) {\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_ONE:\n");
        generateCodeBuffer.append("\t\t\t\treturn 1;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_WIDTH:\n");
        generateCodeBuffer.append("\t\t\t\treturn 1;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_SURFACE:\n");
        generateCodeBuffer.append("\t\t\t\tif(this.timeSerie.length-1 >=this.currentValueIndex+1){\n");
        generateCodeBuffer.append("\t\t\t\t\treturn this.timeSerie[this.currentValueIndex+1];\n");
        generateCodeBuffer.append("\t\t\t\t}\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MAX:\n");
        generateCodeBuffer.append("\t\t\t\tif(this.timeSerie.length-1 >=this.currentValueIndex+1){\n");
        generateCodeBuffer.append("\t\t\t\t\treturn this.timeSerie[this.currentValueIndex+1];\n");
        generateCodeBuffer.append("\t\t\t\t}\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_MIN:\n");
        generateCodeBuffer.append("\t\t\t\tif(this.timeSerie.length-1 >=this.currentValueIndex+1){\n");
        generateCodeBuffer.append("\t\t\t\t\treturn this.timeSerie[this.currentValueIndex+1];\n");
        generateCodeBuffer.append("\t\t\t\t}\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tcase FEATURE_RANGE:\n");
        generateCodeBuffer.append("\t\t\t\tif(this.timeSerie.length-1 >=this.currentValueIndex+1){\n");
        generateCodeBuffer.append("\t\t\t\t\treturn this.timeSerie[this.currentValueIndex+1];\n");
        generateCodeBuffer.append("\t\t\t\t}\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t\tdefault:\n");
        generateCodeBuffer.append("\t\t\t\tif(this.timeSerie.length-1 >=this.currentValueIndex+1){\n");
        generateCodeBuffer.append("\t\t\t\t\treturn this.timeSerie[this.currentValueIndex+1];\n");
        generateCodeBuffer.append("\t\t\t\t}\n");
        generateCodeBuffer.append("\t\t\t\treturn 0;\n");
        generateCodeBuffer.append("\t\t}\n");
        generateCodeBuffer.append("\t}\n");
        
        generateCodeBuffer.append("\n\tprivate int defaultF(String feature) {\n");
        generateCodeBuffer.append("\t\treturn this.defaultVal;\n");
        generateCodeBuffer.append("\t}\n");
	}

}
