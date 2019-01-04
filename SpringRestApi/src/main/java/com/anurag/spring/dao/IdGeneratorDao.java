package com.anurag.spring.dao;

public interface IdGeneratorDao {
	
	public int doIncrement();
	public int doIncrementWithLock() ;

}
