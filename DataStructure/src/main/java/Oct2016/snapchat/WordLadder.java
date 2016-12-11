package Oct2016.snapchat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ritesh on 12/10/16.
 */
public class WordLadder {

    public static void main(String args[]) {

        final String beginWord = "hot";

        final String endWord = "dog";

        final List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("cog");
        wordList.add("pot");
        wordList.add("dot");

        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final String[] beginEndWord = new String[]{beginWord,endWord};

        final Set<String> output = new HashSet<>();

        for(final String word : beginEndWord) {

            char[] wordArray = word.toCharArray();

            if(wordList.contains(word) && beginEndWord.length == wordList.size()) {
                continue;
            }

            for(final String dicWord : wordList) {

                int counter = 0;

                if(word.length()!=dicWord.length()) {
                    continue;
                }

                char[] dicWordArray = dicWord.toCharArray();

                for(int i = 0; i<word.length();i++) {

                    if(wordArray[i]!=dicWordArray[i]) {

                        counter++;
                    }
                }

                if(counter==1) {

                    if(word.equals(endWord)) {
                        output.add(dicWord);
                        output.add(word);
                        break;
                    }
                   output.add(word);
                   output.add(dicWord);
                    break;
                }else if(counter == 0) {
                    output.add(dicWord);
                    break;
                }else {
                    output.add(dicWord);
                }
            }
        }

        return output.size();
    }
}
