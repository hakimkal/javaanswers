package com.ehealth.qone;

/**
 * Created by abdulhakim on 7/21/16.
 */

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntToBinary {
    private final Logger log = LoggerFactory.getLogger(IntToBinary.class);
    int[] bigCounter = {0};

    private int countZeroesInArray(char[] subChars) {
        char[] newSubChars = new char[subChars.length];

        int counter = 0;
        int maxCounter = 0;

        log.info("subchars" + ArrayUtils.toString(subChars));

        //10000010001
        //100011000001

        for (int p = 0; p < subChars.length; p++) {

            if (subChars[p] == '0' ) ///&& ((p + 1) < subChars.length)  && subChars[p+1] != '1' )
                 {

                maxCounter = Math.max(maxCounter, ++counter);

                     if(maxCounter > this.bigCounter[0]) {
                    this.bigCounter[0] = maxCounter  ; //- 1;


                }




            }
            else{
                maxCounter = 0;
                counter = 0;

            }


        }
        return Math.max(this.bigCounter[0],maxCounter);
    }

    public int getMaximalZeroes(int number) {


        String bn = Integer.toString(number, 2);


    /* Convert bn to array */
        char[] chars = bn.toCharArray();


        int counter = 0;
        int maxCounter = 0;
        char[] subChars = new char[8];



        for (int i = 0; i < chars.length; i++) {
            //  log.info("element found: " + chars[i]);
            if (chars[i] == '0' && (i - 1) >= 0 && chars[i - 1] == '1' && i < chars.length ) {

                subChars =  new char[chars.length - i + 1];
                System.arraycopy(chars, i - 1, subChars, 0, chars.length - i + 1);


                maxCounter = countZeroesInArray(subChars);


            }
else {

                return 0;
            }

        }


        log.info("Final Counter " + maxCounter);


        //return  bn;
        return maxCounter;

    }

    public static void main(String[] args) {

        if (args.length != 0) {
            String num = args[0];

            if (Integer.parseInt(num) >= 0) {
                IntToBinary intB = new IntToBinary();
                intB.getMaximalZeroes(Integer.parseInt(num));

            } else {
                System.out.println("Sorry you did not provide a number");
            }
        }
    }
}

