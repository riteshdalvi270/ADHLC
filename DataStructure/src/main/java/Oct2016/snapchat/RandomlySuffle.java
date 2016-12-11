package Oct2016.snapchat;

/**
 * Created by ritesh on 12/9/16.
 */
public class RandomlySuffle {

    public static void main(String args[]) {

        int[] input = new int[]{1,3,5,7,8,9};

        shuffleAnArray(input);

        for(int i = 0; i<input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void shuffleAnArray(int[] input) {

        for(int i = 0; i<input.length; i++) {

            int number = (int) (Math.random() % input.length);

            shuffle(input,i,number);
        }
    }

    private static void shuffle(int[] input, int i, int j) {

        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
