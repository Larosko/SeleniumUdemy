package sec_18;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestNG {

	@Test
	public void Demo() {
		System.out.println("hello");
	}

	@AfterTest
	public void After() {
		System.out.println("After Test");
	}

	@BeforeTest
	public void Before() {
		System.out.println("Before Test");
	}

	@AfterSuite

	public void afSyite() {
		System.out.println("I am After Suite ");
	}

	@Test
	public void SecondTest() {
		System.out.println("bye");
	}

}
