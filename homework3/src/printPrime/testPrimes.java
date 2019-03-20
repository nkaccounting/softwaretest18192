package printPrime;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testprimes {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	
	@Test
	public void testmoney() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		PrintPrimes pp=new PrintPrimes();
		//由于是private方法，采用反射机制，用method的方法调用函数
		Class pc=pp.getClass();
		Method m=pc.getDeclaredMethod("printPrimes", new Class[]{int.class});
		m.setAccessible(true);
		m.invoke(pp, 5);

		String expect="Prime: 2"+'\r'+'\n';
		expect=expect+"Prime: 3"+'\r'+'\n';
		expect=expect+"Prime: 5"+'\r'+'\n';
		expect=expect+"Prime: 7"+'\r'+'\n';
		expect=expect+"Prime: 11"+'\r'+'\n';
		
		assertEquals(expect,outContent.toString());
	}
}
