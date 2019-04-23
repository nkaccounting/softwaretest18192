package mujava;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



public class sorttest {

	@Test
	public void testmoney(){
		assertTrue(Arrays.equals(BubbleSort.BubbleSort(new int[]{3,6,4,7,5,2,1}),new int []{1,2,3,4,5,6,7}));//正确序
		assertTrue(Arrays.equals(BubbleSort.BubbleSort(new int[]{1,1,11,8,9,86}),new int []{86,11,1,1,8,9}));//错误序
		assertTrue(Arrays.equals(BubbleSort.BubbleSort(new int[]{568,1314,4856,1243,58586}),new int []{568,1243,1314,75841,856}));//数值不对
	}
}
