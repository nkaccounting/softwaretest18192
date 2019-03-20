package moneyfun;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class testj {
	public int money;
	public int result;
	public moneycount mc=null; 
	
	public testj(int m,int r){
		this.money=m;
		this.result=r;
	}
	
	@Before
	public void setup(){
		mc=new moneycount();
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(new Object[][]{
				{100,0},{87,0},{84,0},{83,1},{36,0},{35,0},{33,1},{50,1},{20,1},{21,1},{5,1},{90,0},{15,0},{4,0},{10,1},{14,0},{13,1},{3,1},{2,1},{1,1}
		});
		
	}
	
	@Test
	public void testmoney(){
		assertEquals(this.result,mc.minus(money));
	}
}
