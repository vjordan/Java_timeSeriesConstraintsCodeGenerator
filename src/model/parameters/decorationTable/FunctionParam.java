package model.parameters.decorationTable;

import java.util.ArrayList;

public class FunctionParam {

	private boolean function;
	private String value;
	private boolean useOther;
	private ArrayList<FunctionParam> funparam;
	public boolean isUseOther() {
		return useOther;
	}
	public void setUseOther(boolean useOther) {
		this.useOther = useOther;
	}
	public boolean getFunction() {
		return function;
	}
	public void setFunction(boolean function) {
		this.function = function;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ArrayList<FunctionParam> getFunparam() {
		return funparam;
	}
	public void setFunparam(ArrayList<FunctionParam> funparam) {
		this.funparam = funparam;
	}
	@Override
	public String toString() {
		return "FunctionParam [function=" + function + ", value=" + value + ", funparam=" + funparam + "]";
	}
	
}
