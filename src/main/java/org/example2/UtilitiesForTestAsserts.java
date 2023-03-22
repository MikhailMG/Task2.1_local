package org.example2;


public class UtilitiesForTestAsserts {

        public String checkedString_Minor;
        public String checkedString_Major;
        public static boolean incloodesString;
        static double index1;

        public static boolean checkString(String checkedString_Major, String checkedString_Minor) {
            index1 = (checkedString_Major).indexOf(checkedString_Minor);
            incloodesString = (index1 > 0);
        return incloodesString;
        }
    }


