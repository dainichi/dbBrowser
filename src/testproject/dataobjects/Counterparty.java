package testproject.dataobjects;

public class Counterparty {
	public enum End {
		FROM, TO
	}
	Table table;
	String condition;
	End end;
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public End getEnd() {
		return end;
	}
	public void setEnd(End end) {
		this.end = end;
	}
	public Counterparty(Table table, String condition, End end) {
		super();
		this.table = table;
		this.condition = condition;
		this.end = end;
	}
}
