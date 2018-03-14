package testproject.dataobjects;

import java.util.Map;
import java.util.Set;

public class DataModel {
	private Set<Table> tables;
	private Set<Association> associations;
	private transient MultiMap<Table, Counterparty> counterpartyMap;
	private transient Map<String, Table> tableMap;
	private transient Set<String> tableNames;
}
