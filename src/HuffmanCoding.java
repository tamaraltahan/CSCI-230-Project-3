import java.util.*;

public class HuffmanCoding {
    private static int uniqueCharacters = 0;

    public HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

        assert trees.size() > 0;
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

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        if (tree instanceof HuffmanLeaf) { //if node is external
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            uniqueCharacters++;
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
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void printTree(HuffmanTree tree, StringBuffer prefix){
        
        printCodes(tree,prefix);
    }
}
