import java.util.*;

public class HuffmanCoding {


    private static class Node {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            //assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }




    DefaultComparator comp = new DefaultComparator();
    PriorityQueue<String> Heap = new PriorityQueue<>();

    private int[] freq(char[] input){
        int[] freq = new int[256];
        for(int i = 0; i < input.length; i++){
            freq[input[i]]++;
        }
        return freq;
    }

    public PriorityQueue<String> Compress(char[] input){
        int[] freq = freq(input);
        for(int i = 0; i < freq.length; i++){
           
        }

    }


}
