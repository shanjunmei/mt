package com.lanhun.framework.utils.em;


public  interface EnumCode<E extends Enum<E>>{
	
	/**
	 * 描述
	 * @return
	 */
	public String getDisplay();

	public String getName();
	
	public int getValue();
	
	
}
