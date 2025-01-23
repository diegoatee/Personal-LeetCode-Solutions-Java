/*
Idea:
Two pointer solution, starting from the right end of the String s.

Have a "cur" pointer (current character), and a "prev" pointer (character immediately to the left).

For each character, use a switch statement to determine and add its decimal value and check if it is preceded by a character that would require subtraction to occur (for example, if 'I' is directly before 'V'). If 
subtraction must occur, then decrement both pointers by an extra character to skip over the "subtraction"
character. 

(Example: For "CIV", add 5 from the "V", then subtract 1 after checking that "I" precedes "V", skip
over the I by decrementing the pointer an extra time, then add 100 from the "C")

//Time complexity: O(N) where N is the length of the String
*/

class Solution {
    public int romanToInt(String s) {
        int curTotal = 0;
        char cur;
        char prev = '!';    //In case of no previous char
        int i;

        for (i = s.length() - 1; i > 0; i--) {
            
            cur = s.charAt(i);
            prev = s.charAt(i - 1);
            

            switch (cur) {
                
                case 'M':
                   curTotal += 1000;
                    if (prev == 'C') {
                        curTotal -= 100;
                        i--;
                    }
                    break;
                case 'D':
                    curTotal += 500;
                    if (prev == 'C') {
                        curTotal -= 100;
                        i--;
                    }
                    break;
                case 'C':
                    curTotal += 100;
                    if (prev == 'X') {
                        curTotal -= 10;
                        i--;
                    }
                    break;
                case 'L':
                    curTotal += 50;
                    if (prev == 'X') {
                        curTotal -= 10;
                        i--;
                    }
                    break;
                case 'X':
                    curTotal += 10;
                    if (prev == 'I') {
                        curTotal -= 1;
                        i--;
                    }
                    break;
                case 'V':
                    curTotal += 5;
                    if (prev == 'I') {
                        curTotal -= 1;
                        i--;
                    }
                    break;
                case 'I':
                    curTotal += 1;
                    break;
            }
        }

        cur = s.charAt(0);
        if (i == 0) {
            switch (cur) {
                case 'M':
                   curTotal += 1000;
                    break;
                case 'D':
                    curTotal += 500;
                    break;
                case 'C':
                    curTotal += 100;
                    break;
                case 'L':
                    curTotal += 50;
                    break;
                case 'X':
                    curTotal += 10;
                    break;
                case 'V':
                    curTotal += 5;
                    break;
                case 'I':
                    curTotal += 1;
                    break;
            }
        }

        return curTotal;
    }
}
