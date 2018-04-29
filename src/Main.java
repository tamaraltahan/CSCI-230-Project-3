public class Main {

    public static void main(String[] args) {
        patterns();

    }



    public static void patterns(){
        String text;
        String pattern;
        Reader reader = new Reader();
        PatternMatching patternMatching = new PatternMatching();
        int index;

        //declaration
        text = reader.getDeclaration();
        pattern = "harass";
        //BM
        index = patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: Boyer Moore\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());
        //KMP
        index = patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: KMP\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());

        //word NOT in file
        pattern = "King George is my Homie";
        //BM
        index = patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: Boyer Moore\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());
        //KMP
        index = patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: KMP\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());

        //DNA
        text = reader.getDNA().toUpperCase();
        pattern = "TAGTAC";

        index = patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: Boyer Moore\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());
        //KMP
        index = patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: KMP\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());

        //word NOT in file
        pattern = "TACGATCATATA";
        //BM
        index = patternMatching.findBoyerMoore(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: Boyer Moore\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());
        //KMP
        index = patternMatching.findKMP(text.toLowerCase().toCharArray(),pattern.toCharArray());
        System.out.println("Matching Scheme: KMP\n" + "Index found at: " + index + "\nTime: " + patternMatching.getTime() + "\nComparisons: " + patternMatching.getComparisons());
    }
}
