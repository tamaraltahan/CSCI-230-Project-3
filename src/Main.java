public class Main {

    public static void main(String[] args) {
        patterns();
        System.out.println();
        huffman();
    }



    public static void patterns(){
        String text;
        String pattern;
        Reader reader = new Reader();
        PatternMatching patternMatching = new PatternMatching();

        //declaration
        //word IN file
        System.out.println("Good");
        text = reader.getDeclaration();
        pattern = "Declaration";
        //BM
        patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toLowerCase().toCharArray());
        patternMatching.printData();
        //KMP
        patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toLowerCase().toCharArray());
        patternMatching.printData();

        //word NOT in file
        System.out.println("Bad");
        pattern = "King George is my Homie";
        //BM
        patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toLowerCase().toCharArray());
        patternMatching.printData();
        //KMP
        patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toLowerCase().toCharArray());
        patternMatching.printData();


        //DNA
        System.out.println("Good");
        text = reader.getDNA().toUpperCase();
        pattern = "TAGTAC";

        patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toLowerCase().toCharArray());
        patternMatching.printData();

        //KMP
        patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toLowerCase().toCharArray());
        patternMatching.printData();


        //word NOT in file
        System.out.println("bad");
        pattern = "TACGATCATATA";
        //BM
        patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toCharArray());
        patternMatching.printData();

        //KMP
        patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toCharArray());
        patternMatching.printData();

    }


    public static void huffman(){
        System.out.println("Huffman Coding:");
        //Writer writer = new Writer();
        Reader reader = new Reader();
        HuffmanCoding huffman = new HuffmanCoding();

        String input = reader.getMoneyIn();
        int[] freq = new int[256];
        for(char c : input.toCharArray()){
            freq[c]++;
        }
        HuffmanTree tree = huffman.buildTree(freq);
        //huffman.printCodes(tree, new StringBuilder());
        huffman.printTree(tree,new StringBuilder());
    }
}
