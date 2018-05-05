public class HuffmanLeaf extends HuffmanTree {
    public final char value; // the character this leaf represents
    public String bitValue;

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}