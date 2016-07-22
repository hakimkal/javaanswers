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
        //System.out.println(Integer.parseInt("1110000",2));

        Assert.assertEquals(0,  intB.getMaximalZeroes(112));

    }
}
