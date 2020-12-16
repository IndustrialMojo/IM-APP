package com.industrialmojo.codechallenge;

//@SpringBootApplication
public class PrefixChallenge {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootApplication.class, args);

//        Write a function to find the longest common prefix string amongst an array of strings.
//                If there is no common prefix, return an empty string "".


        String theWinner = extracted();
        System.out.println("the winner is " + theWinner);


    }

    private static String extracted() {
        String[] stringArray = new String[]{"cd", "abdef", "abghi", "abjkl"};

        String prefix = "";

        String prefixCandidate = "";

        for (String string1 : stringArray) {

            System.out.println("xxx " + string1);

            for (String string2 : stringArray) {


                if (!string2.equals(string1)) {


                    String strChar = "";

                    for (char myChar : string1.toCharArray()) {



                        strChar = strChar + String.valueOf(myChar);


                        if (string2.startsWith(strChar)) {
                            prefixCandidate = strChar;


                        }


                    }


                }

            }


            if (prefixCandidate != null && !prefixCandidate.isEmpty()) {
                System.out.println("prefix = " + prefixCandidate);
                if (prefixCandidate.length() > prefix.length()) {
                    prefix = prefixCandidate;
                }
            }

        }
        return prefix;
    }
}
