/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding;

/**
 *
 * @author wliu
 */
public class EasyCoding {

    private final static int[] seq_2 = {1, 2};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        UserThreadPool.main(args);
        sortLevel(3);
        sortLevel(4);
        sortLevel(5);
        sortLevel(6);
    }
    
    
    private static int[] sortLevel(int level) {
        if (level == 1) {
            return new int[] {1};
        }
        int[] r = getBasePoints(level);
        printArray(r, level);
        return r;
    }

    private static int[] getBasePoints(int level) {
        if (level == 2) {
            return seq_2;
        }
        
        int[] b = getBasePoints(level - 1);
        int basePointsCount = 1 << level - 1;
        int[] r = new int[basePointsCount];
        for (int i = 0; i < b.length; i++) {
            r[2*i] = b[i];
        }
        int gap = 1 << level - 2;
        for (int i = 1; i < basePointsCount; i += 2) {
            r[i] = r[i-1] + gap;
        }
        return r;
    }
    
    
    private static void printArray(int[] r, int level) {
        System.out.println("Level == " + level);
        for(int x : r) {
            System.out.print(x + ", ");
        }
        System.out.println("");
    }
}
