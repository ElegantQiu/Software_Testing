package lab1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class TestExchange {

	Problem pro;
	private static Money money0 = new Money(0,0);
	private static Money money1 = new Money(50,1);
	private static Money money2 = new Money(20,2);
	private static Money money3 = new Money(5,3);
	private static Money money4 = new Money(5,4);
	private static Money money5 = new Money(1,5);
	private static Money money6 = new Money(1,6);
	private static Money money7 = new Money(1,7);
	private static Money[] arrayMoney = {money1,money2,money3,money4,money5,
        money6,money7};
	
	@Before
	public void setUp(){
		pro = new Problem();
	}
	
	@Test
	public void testExchange1(){
		Money[] testResult = pro.exchange(4, arrayMoney);
		assertEquals(0,testResult[6].getNumber());
	}
	
	@Test
	public void testExchange2(){
		Money[] testResult = pro.exchange(4, arrayMoney);
		assertEquals(6,testResult[4].getNumber());
	}
	
	@Test
	public void testExchange3(){
		Money[] testResult = pro.exchange(4, arrayMoney);
		assertEquals(1,testResult[0].getNumber());
	}
}
