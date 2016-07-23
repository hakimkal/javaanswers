package com.ehealth.qone;

/**
 * Created by abdulhakim on 7/21/16.
 */


public class IntToBinary {
   // private final Logger log = LoggerFactory.getLogger(IntToBinary.class);
    int[] bigCounter = {0};

    private int countZeroesInArray(char[] subChars) {
        char[] newSubChars = new char[subChars.length];

        int counter = 0;
        int maxCounter = 0;

        //log.info("subchars" + ArrayUtils.toString(subChars));

        //10000010001
        //100011000001

        for (int p = 0; p < subChars.length; p++) {

            /*

             else if (chars[i] == '0'  && i == (chars.length - 1)  )

                {

                 return 0;


            }
            *
            */
            if (subChars[p] == '0' && p != subChars.length - 1 ) ///&& ((p + 1) < subChars.length)  && subChars[p+1] != '1' )
                 {

                maxCounter = Math.max(maxCounter, ++counter);

                     if(maxCounter > this.bigCounter[0]) {
                    this.bigCounter[0] = maxCounter  ; //- 1;

                 if(p == (subChars.length - 1) && subChars[p] != '1' )
                 {
                  return this.bigCounter[0];
                 }
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


        System.out.println(bn);

    /* Convert bn to array */
        char[] chars = bn.toCharArray();


        int counter = 0;
        int maxCounter = 0;
        char[] subChars = new char[8];



        for (int i = 0; i < chars.length; i++) {
            // log.info("element found: " + chars[i]);
            if (chars[i] == '0' && (i - 1) >= 0 && chars[i - 1] == '1' && i < chars.length ) {

                subChars =  new char[chars.length - i + 1];
                //log.info(ArrayUtils.toString(subChars));
                System.arraycopy(chars, i - 1, subChars, 0, chars.length - i + 1);
                subChars = removeZeroSuffix(subChars);

                maxCounter = countZeroesInArray(subChars);
                return maxCounter;


            }



        }


        System.out.println(    "Final Counter " + maxCounter);


        //return  bn;
        return maxCounter;

    }


    public char[] removeZeroSuffix(char[] chars){

     char[] subChars = new char[2];
    for(int e = 0 ; e <= chars.length - 1; e++){

        if(chars[chars.length - 1] == '0') {
            subChars = new char[chars.length - 1];

            System.arraycopy(chars, 0, subChars, 0, chars.length- 1);

            if(subChars[subChars.length - 1] == '0') {
               subChars= removeZeroSuffix(subChars);

            }
        }
        else{
            return chars;
        }
    }
    return subChars;
}
    public static void main(String[] args) {
        String num = "";
        if (args.length != 0) {
              num = args[0];}
     else{

         num = "1041";
            System.out.println("No argument passed, using  " + num + " instead!");
     }

            if (Integer.parseInt(num) >= 0) {
                IntToBinary intB = new IntToBinary();
                int result = intB.getMaximalZeroes(Integer.parseInt(num));
                System.out.println("The final result of consecutive zeros between 1s for decimal number: "+ num + " is " + result);

            }
        }

}

