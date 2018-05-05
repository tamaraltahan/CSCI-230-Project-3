import java.util.*;

public class HuffmanCoding {
    private static int characters = 0;
    private static String bits = "";

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
            leaf.bitValue = prefix.toString();
            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
            if(leaf.value == '\n'){
                System.out.println("\\n" + "\t" + prefix);
            }
            else if(leaf.value == ' '){
                System.out.println("\\s" + "\t" + prefix);
            }
            else {
                System.out.println(leaf.value + "\t" + prefix);
            }
        } else if (tree instanceof HuffmanNode) { //else if is internal
            HuffmanNode node = (HuffmanNode) tree;
            // traverse left
            prefix.append('0');
            bits += prefix;
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
            // traverse right
            prefix.append('1');
            bits += prefix;
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void printTree(HuffmanTree tree, StringBuilder prefix){
        printCodes(tree,prefix);
        System.out.println("Number of characters: " + (characters-1));
        System.out.println("Number of bits: "  + bits.length() + "\nBit String: " + bits);
    }
}
