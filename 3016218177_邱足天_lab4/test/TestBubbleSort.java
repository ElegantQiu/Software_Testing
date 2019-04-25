package cn.tju.scsst.lab.lab4;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestBubbleSort {

    @Test
    public void testBubbleSort(){
        int [] array = new int[]{5,6,1,3,2,8,9,7,4};
        BubbleSort.BubbleSort(array);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, array);
    }
}