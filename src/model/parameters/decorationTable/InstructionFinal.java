package model.parameters.decorationTable;

import java.util.ArrayList;

public class InstructionFinal {
	private String var;
	private String index;
	private String value;
	private Boolean function;
	private Boolean useOther;
	private int indexOther;
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "(var=" + var + ", index=" + index + ", value=" + value + ")";
	}
	public Boolean getFunction() {
		return function;
	}
	public void setFunction(Boolean function) {
		this.function = function;
	}
	public Boolean getUseOther() {
		return useOther;
	}
	public void setUseOther(Boolean useOther) {
		this.useOther = useOther;
	}
	public int getIndexOther() {
		return indexOther;
	}
	public void setIndexOther(int indexOther) {
		this.indexOther = indexOther;
	}
	
	

}
