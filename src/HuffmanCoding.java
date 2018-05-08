import java.util.*;

public class HuffmanCoding {
    private static HashMap<Character, String> charBitMap = new HashMap<>(); //for compression
    private static HashMap<String, Character> dictionary = new HashMap<>(); //for decompression
    private static int characters = 0;
    


    /**
     * Construsts a Huffman Tree based on the algorithm from the book
     * @param charFreqs an array of character frequencies f(c)
     * @return A PQ implemented with a heap containing the huffman nodes
     */
    public HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();

        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0) {
                characters += charFreqs[i];
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
            }
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }


    /**
     *  Recursively outputs leaf nodes
     * @param tree Huffman Tree
     * @param prefix A stringbuilder (use new Stringbuilder or something similar)
     */
    public static void printCodes(HuffmanTree tree, StringBuilder prefix) {
        if (tree instanceof HuffmanLeaf) { //if node is external
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            //System.out.println(prefix);
            charBitMap.put(leaf.value, prefix.toString());
            dictionary.put(prefix.toString(),leaf.value);
            if (leaf.value == '\n') {
                System.out.println("\\n" + "\t" + prefix);
            } else if (leaf.value == ' ') {
                System.out.println("\\s" + "\t" + prefix);
            } else {
                System.out.println(leaf.value + "\t" + prefix);
            }
        } else if (tree instanceof HuffmanNode) { //else if is internal -> postorder traversal
            HuffmanNode node = (HuffmanNode) tree;
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private static String getBitValues(String word, HashMap<Character,String> map){
        StringBuilder builder = new StringBuilder();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (map.containsKey(c)) {
                builder.append(map.get(c));
            }
        }
        return builder.toString();
    }

    public static void printTree(String input, HuffmanTree tree){
        System.out.println(input);
        printCodes(tree,new StringBuilder());
        System.out.println("Number of characters: " + characters);
        String bit = getBitValues(input,charBitMap);
        System.out.println("Number of bits: " + bit.length() + "\nBit String: " + bit);
        System.out.println("Decompression result: " + decompress(bit));
    }

    private static String decompress(String s) {
        String temp = "";
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            temp = temp + s.charAt(i);
            if(dictionary.containsKey(temp)) {
                result = result + dictionary.get(temp);
                temp = "";
            }
        }
        return result;
    }
}

