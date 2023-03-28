import java.util.Scanner;


public class PigLatinTranslator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Pig Latin phrase: ");
        String pigLatinPhrase = scanner.nextLine();

        String englishPhrase = translatePigLatinToEnglish(pigLatinPhrase);

        System.out.println("English equivalent: " + englishPhrase);
    }

    public static String translatePigLatinToEnglish(String pigLatinPhrase) {
        String[] words = pigLatinPhrase.split(" ");

        StringBuilder englishPhraseBuilder = new StringBuilder();

        for (String word : words) {
            if (word.endsWith("way")) {
                // Word ends in "way", so it's already in English
                englishPhraseBuilder.append(word.substring(0, word.length() - 3)).append(" ");
            } else {
                // Word starts with a consonant cluster followed by "ay"
                int firstVowelIndex = -1;

                for (int i = 0; i < word.length(); i++) {
                    if ("aeiouAEIOU".indexOf(word.charAt(i)) >= 0) {
                        firstVowelIndex = i;
                        break;
                    }
                }

                String consonantCluster = word.substring(0, firstVowelIndex);
                String restOfWord = word.substring(firstVowelIndex, word.length() - 2);

                englishPhraseBuilder.append(restOfWord).append(consonantCluster).append(" ");
            }
        }

        return englishPhraseBuilder.toString().trim();
    }

}