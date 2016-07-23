package com.ehealth.qone;

/**
 * Created by abdulhakim on 7/21/16.
 */

import org.junit.Test ;
import org.junit.Assert;

public class IntToBinaryTest {
    @Test

    public void shouldReturnBinaryString(){

        IntToBinary intB = new IntToBinary();
        //System.out.println("Number " + Integer.parseInt("1000110000",2));
//Assert.assertEquals(0,  intB.getMaximalZeroes(112));
        Assert.assertEquals(3,  intB.getMaximalZeroes(560));

    }
}
