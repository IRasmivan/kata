package com.rasmivan.learning;

public class JNiceStrings {

    // From http://adventofcode.com/day/5
    //  --- Day 5: Doesn't He Have Intern-Elves For This? ---
    //
    //  Santa needs help figuring out which strings in his text file are naughty or nice.
    //
    //    A nice string is one with all of the following properties:
    //
    //    It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
    //  It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
    //    It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
    //    For example:
    //
    //    ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
    //  aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
    //    jchzalrnumimnmhp is naughty because it has no double letter.
    //    haegwjzuvuyypxyu is naughty because it contains the string xy.
    //    dvszwmarrgswjxmb is naughty because it contains only one vowel.
    //    How many strings are nice?

    /**
     *
     * @param xs
     * @return
     */
    public static int nice(String xs) {
        String vowelsPattern = "[aeiou]"; // All the Vowels
        String disallowedPattern = "(ab|cd|pq|xy)"; // All the disallowed Patterns
        String duplicateCharacterPattern = "(\\w)\\1+"; // Should contain duplicate words.


        String xVowel = xs.toLowerCase().replaceAll(vowelsPattern, "" );
        String xDisallowed = xs.toLowerCase().replaceAll(disallowedPattern, "" );
        String xDuplicateCharacter = xs.toLowerCase().replaceAll(duplicateCharacterPattern, "" );

        /**
         * Please be aware, I could directly write this logic without having any String variable declared, But
         * wanted to showcase what i was thinking and hence these variable are there to make the code readable.
         *
         * Without the variable, the same logic can be written like this.
         * if(
         *      (xs.length() - xs.replaceAll("[aeiou]", "" ).length()) >= 3 && // Vowel's Should Occur 3 or more time
         *      (xs.length() - xs.replaceAll("(ab|cd|pq|xy)", "" ).length()) == 0 && // There should be no disAllowed words
         *      (xs.length() - xs.replaceAll("(\w)\1+", "" ).length()) >= 2 // There should at least 2 character duplicated
         *      // next to next
         *      ){
         *          return 1;
         *      }
         *      return 0;
         */
        if(
                (xs.length() - xVowel.length()) >= 3 && // Vowel's Should Occur 3 or more time
                (xs.length() - xDisallowed.length()) == 0 && // There should be no disAllowed words
                (xs.length() - xDuplicateCharacter.length()) >= 2 // There should at least 2 character difference,
            // since duplicate character
        ){
            return 1; // Nice
        }

        return 0; // Naughty
    }
}
