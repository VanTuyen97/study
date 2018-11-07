package com.vantuyen361.testng.dependent;

import org.testng.annotations.Test;

import com.vantuyen361.testng.Support;

public class DependentTest extends Support{
	
	@Test(dependsOnMethods = { "OpenBrowser" })//OpenBrowser() test method must run before this test method
	public void SignIn() {
		log("This will execute second (SignIn)");
	}

	@Test
	public void OpenBrowser() {
		log("This will execute first (Open Browser)");
	}

	@Test(dependsOnMethods = { "SignIn" })//SignIn() test method must run before this test method
	public void LogOut() {
		log("This will execute third (Log Out)");
	}
}
