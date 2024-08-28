/* Read sentences from the user until * is entered. 
Show the number of words in each sentence that 
contain a stretch of non-z characters with exactly 2 vowels. 
A stretch starts from the start of the word or after a 'z'. 
A stretch terminates just before another 'z' 
or at the end of the word.

Examples:
Matching words: zoo, azozooza, GONZALEZ
Non-matching words: ozo, azoooza
The sentences contain no punctuation, 
the words are separated by one or more spaces, 
and the characters may be upper or lower case. 
Keep reading sentences until the user enters "*". */

public class StretchWith2Vowels {



    public static void main(String[] args) {
        /* Take in input and split string into new string array */
        runner();
        System.out.println("Done");

    }


    public static String readSentence() {
        System.out.print("Sentence: ");
        String input = In.nextLine();
        return input;
    }

    public static int countVowel(String input) {
        /* Loop to read the word from z to z and then initialize the counter
         * to count the number of vowels in the word. */

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) {
                count++;
            }
        }
        return count;


           
    }
    public static String[] splitString(String input) {
        String[] words = input.split("z");
        return words;
    }
    public static void runner() {
        
        String input = readSentence();
        
        while (!input.equals("*")) {
            int[] countArray = new int[input.length()];
            String[] words = splitString(input);
            for (int i = 0; i < words.length; i++) {  
                countArray[i] = countVowel(words[i]);
            }
            System.out.println("Matching words: " + numCountMatch(countArray));
            input = readSentence();
        }

        
    }
    public static boolean isVowel(char c) {
        char a = Character.toLowerCase(c);
        return "aeiou".contains ("" + a);
    }

    public static int numCountMatch(int[] countArray) {
        int count = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 2) {
                count++;
            }
        }
        return count;
    }
    
}
