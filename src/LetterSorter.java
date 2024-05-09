import java.util.*;

public class LetterSorter {
    public static void main(String[] args) {
        String[] words1 = {"Abc", "bCd"};
        String[] words2 = {"Oke", "One"};
        String[] words3 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};

        wordCounter(words1);
        System.out.println(groupAndSort(words1)); // Output: bACcd
        wordCounter(words2);
        System.out.println(groupAndSort(words2)); // Output: Oekn
        wordCounter(words3);
        System.out.println(groupAndSort(words3)); // Output: aenrktipBDPTUdmosu
    }

    public static String groupAndSort(String[] words) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        List<Character> sortedChars = new ArrayList<>(charCount.keySet());
        Collections.sort(sortedChars, (a, b) -> {
            int countComparison = charCount.get(b) - charCount.get(a);
            if (countComparison == 0) {
                return Character.compare(a, b);
            }
            return countComparison;
        });

        StringBuilder result = new StringBuilder();
        for (char c : sortedChars) {
            result.append(c);
        }

        return result.toString();
    }

    public static void wordCounter(String[] words) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for(String word: words){
            String[] letters = word.split("");
            for (String letter : letters) {
                char currentLetter = letter.charAt(0);
                if(Character.isLetter(currentLetter)){
                    charCount.put(currentLetter, charCount.getOrDefault(currentLetter, 0) + 1);
                }
            }
        }

        boolean isFirst = true;
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            if(!isFirst){
                System.out.print(", ");
            }
            System.out.print(entry.getKey() + "=" + entry.getValue());
            isFirst = false;
        }
        System.out.println("");
    }
}
