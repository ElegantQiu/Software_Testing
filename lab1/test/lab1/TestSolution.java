package lab1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestSolution {

	Problem pro;
	@Before
	public void setUp(){
		pro = new Problem();
	}
	
	@Test
	public void testSolution1(){
		pro.init();
		pro.givenNumber = 52;
		String result = pro.solution();
		assertEquals("1yuan 1yuan 50yuan ",result);
	}
	
	@Test
	public void testSolution2(){
		pro.init();
		pro.givenNumber = 54;
		String result = pro.solution();
		assertEquals("нч╫Б",result);
	}
	
	@Test
	public void testSolution3(){
		pro.init();
		pro.givenNumber = 7;
		String result = pro.solution();
		assertEquals("1yuan 1yuan 5yuan ",result);
	}
}
