package Oct2016.snapchat;

import java.util.*;

/**
 * Created by ritesh on 12/10/16.
 */
public class WordLadder {

    public static void main(String args[]) {

        final String beginWord = "a";

        final String endWord = "c";

        final List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");

        System.out.println(ladder(beginWord,endWord,wordList));
        System.out.println(ladderLength(beginWord,endWord,wordList));




    }

    //Wrong solution.
    private static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
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

    private static int ladder(String beginWord, String endWord, List<String> wordList) {

        final Queue<String> queue = new ArrayDeque<>();
        final Queue<Integer> distance = new ArrayDeque<>();

        wordList.add(endWord);

        queue.add(beginWord);
        distance.add(1);

        while(!queue.isEmpty()) {

            String value  = queue.remove();
            int current = distance.remove();
            char[] beginCharArray = value.toCharArray();

            if(value.equals(endWord)) {
                return current;
            }

            for(int i = 0; i<value.length();i++) {

                for(char c = 'a'; c<= 'z'; c++) {

                    char firstbeginChar = beginCharArray[i];

                    if(firstbeginChar!=c) {
                        beginCharArray[i] = c;
                    }

                        if (wordList.contains(String.valueOf(beginCharArray))) {

                            wordList.remove(String.valueOf(beginCharArray));

                            queue.add(String.valueOf(beginCharArray));

                            distance.add(current+1);
                        }


                    beginCharArray[i] = firstbeginChar;
                }
            }
        }

        return 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }

    static class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }
}
