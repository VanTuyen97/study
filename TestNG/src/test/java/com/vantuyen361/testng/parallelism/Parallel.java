package com.vantuyen361.testng.parallelism;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vantuyen361.testng.Support;

public class Parallel extends Support{
	@BeforeMethod
	public void beforeMethod() {
		log("");
	}
	
	@Test
	public void test1( ) {
		log("");
	}
	
	@Test
	public void test2( ) {
		log("");
	}
	
	@Test
	public void test3( ) {
		log("");
	}
	
	@Test
	public void test4( ) {
		log("");
	}
	
	@Test
	public void test5( ) {
		log("");
	}
	
	@AfterMethod
	public void afterMethod ( ) {
		log("");
	}
}
