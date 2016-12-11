package Oct2016.GeeksForGeeks.dynamicprogramming;

/**
 * Created by ritesh on 12/9/16.
 */
public class TowerOfHanoi {

    public static void main(String args[]) {

        // no of disk
        int n = 3;

        towerofHanoi(n,'1', '3', '2');
    }

    public static void towerofHanoi(int n, char fromRod, char toRod, char auxRod) {

        if(n == 0) {
            return;
        }

        if(n==1) {
            System.out.println("Disk:1" + " moved from: "+fromRod+" to rod "+toRod);
            return;
        }

        towerofHanoi(n-1,fromRod,auxRod,toRod);
        System.out.println("Disk:"+n+" moved from: "+fromRod+" to rod "+toRod);
        towerofHanoi(n-1,auxRod,toRod,fromRod);
    }
}
