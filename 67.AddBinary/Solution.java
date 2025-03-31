class Solution {
    public String addBinary(String a, String b) {
        //Rule 1: 0 + 0 = 0
        //Rule 2: 1 + 0 = 1
        //Rule 3: 1 + 1 = 0 Carry the 1
        //Rule 4: 1 + 1 + carried 1 = 1 Carry the 1

        int num1Index = a.length() - 1;
        int num2Index = b.length() - 1;
        String binaryTotal = "";
        boolean numberCarried = false;
        int binaryDigit = 0;
        int digitCalc;

        while (num1Index >= 0 && num2Index >= 0) {
            int num1Digit = a.charAt(num1Index) - '0';
            int num2Digit = b.charAt(num2Index) - '0';

            if (numberCarried) {
                digitCalc = num1Digit + num2Digit + 1;
            }
            else {
                digitCalc = num1Digit + num2Digit;
            }
            

            switch(digitCalc) {
                case 0:
                    binaryDigit = 0;
                    numberCarried = false;
                    break;
                case 1:
                    binaryDigit = 1;
                    numberCarried = false;
                    break;
                case 2:
                    binaryDigit = 0;
                    numberCarried = true;
                    break;
                case 3:
                    binaryDigit = 1;
                    numberCarried = true;
            }
            

            binaryTotal = String.valueOf(binaryDigit) + binaryTotal;
            
            num1Index--;
            num2Index--;
        }

        for (int i = num1Index; i >= 0; i--) {
            if (numberCarried) {
                digitCalc = (a.charAt(i) - '0') + 1;
            }
            else {
                digitCalc = a.charAt(i) - '0';
            }

            switch(digitCalc) {
                case 0:
                    binaryDigit = 0;
                    numberCarried = false;
                    break;
                case 1:
                    binaryDigit = 1;
                    numberCarried = false;
                    break;
                case 2:
                    binaryDigit = 0;
                    numberCarried = true;
            }

            binaryTotal = String.valueOf(binaryDigit) + binaryTotal;
        }

        for (int i = num2Index; i >= 0; i--) {
            if (numberCarried) {
                digitCalc = (b.charAt(i) - '0') + 1;
            }
            else {
                digitCalc = b.charAt(i) - '0';
            }

            switch(digitCalc) {
                case 0:
                    binaryDigit = 0;
                    numberCarried = false;
                    break;
                case 1:
                    binaryDigit = 1;
                    numberCarried = false;
                    break;
                case 2:
                    binaryDigit = 0;
                    numberCarried = true;
            }

            binaryTotal = String.valueOf(binaryDigit) + binaryTotal;
        }
        
        if (numberCarried) {
            binaryTotal = "1" + binaryTotal;
        }

        return binaryTotal;
    }
}
