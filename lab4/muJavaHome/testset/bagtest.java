package mujava;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class bagtest {
	private int m;
	private int n;
	private int w[];
	private int p[];
	private int c[][];
	
	@Before
	public void setup(){
		m=10;
		n=3;
		w=new int []{3,4,5};
		p=new int []{4,5,6};
		c=BackPack.BackPack_Solution(m,n,w,p);
		}
	
	@Test
	public void test(){
		assertEquals(11,this.c[n][m]);
	}
}
