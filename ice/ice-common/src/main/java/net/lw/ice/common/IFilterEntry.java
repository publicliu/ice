package net.lw.ice.common;


public interface IFilterEntry {

	public String getKey();

	public Object getValue();

	public Operator getOperator();
}
