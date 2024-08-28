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


    public static int splitterCount(String input) {
        
        input = input.toLowerCase();
        int count = 0;
        String[] words = input.split(" ");
        
        for (int i = 0; i < words.length; i++ ) {
            
            String[] stretch = words[i].split("z");
            

            boolean hasStretch = false;
            
            for (int j = 0; j < stretch.length; j++) {
                
                if (is2CountVowel(stretch[j])){
                    hasStretch = true;
                    break;
                }

            }

            if (!hasStretch && is2CountVowel(words[i])) {
                hasStretch = true;
            }

            if (hasStretch) {
                count++;
            }
        }

        return count;

    }
    
    public static void runner() {
        
        String input = readSentence();
        
        while (!input.equals("*")) {
            
            int count = 0;
            
            count = splitterCount(input);

            System.out.println("Matching Words = " + count);

            input = readSentence();
        }

        
    }
    public static boolean isVowel(char c) {
        char a = Character.toLowerCase(c);
        return "aeiou".contains ("" + a);
    }

    public static boolean is2CountVowel(String input) {
        
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) {
                count++;
            }
        }
        return count == 2;
        
        
    }


}
