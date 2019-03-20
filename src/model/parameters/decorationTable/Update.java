package model.parameters.decorationTable;

import java.util.ArrayList;

public class Update {
	private String var;
	private String value;
	private String index;
	private Boolean useOther;
	private String indexOther;
	private String addValue;
	private Boolean function;
	private ArrayList<FunctionParam> funparam;
	
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "(var=" + var + ", value=" + value + ") ";
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public Boolean getUseOther() {
		return useOther;
	}
	public void setUseOther(Boolean useOther) {
		this.useOther = useOther;
	}
	public String getIndexOther() {
		return indexOther;
	}
	public void setIndexOther(String indexOther) {
		this.indexOther = indexOther;
	}
	public String getAddValue() {
		return addValue;
	}
	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}
	public Boolean getFunction() {
		return function;
	}
	public void setFunction(Boolean function) {
		this.function = function;
	}
	public ArrayList<FunctionParam> getFunparam() {
		return funparam;
	}
	public void setFunparam(ArrayList<FunctionParam> funparam) {
		this.funparam = funparam;
	}
	
	
}
