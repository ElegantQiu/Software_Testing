package lab1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestFindLess {

	Problem pro;
	
	@Before
	public void setUp(){
		pro = new Problem();
	}

	@Test
	public void testFindLess1(){
		Money result = pro.findLess(60);
		assertEquals(50,result.getValue());
	}
	
	@Test
	public void testFindLess2(){
		Money result = pro.findLess(20);
		assertEquals(20,result.getValue());
	}
	
	@Test
	public void testFindLess3(){
		Money result = pro.findLess(6);
		assertEquals(5,result.getValue());
	}
	
	@Test
	public void testFindLess4(){
		Money result = pro.findLess(4);
		assertEquals(1,result.getValue());
	}
}
