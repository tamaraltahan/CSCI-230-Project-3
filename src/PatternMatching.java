import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
   private int comparisons = 0;
    private double time = 0;

    public int getComparisons(){
        return comparisons;
    }

    public double getTime() {
        return time;
    }

    public int findBoyerMoore(char[] text, char[] pattern){
        comparisons = 0;
        time = 0;
        double t1 = System.currentTimeMillis();
        int n = BoyerMoore(text,pattern);
        double t2 = System.currentTimeMillis();
        time = t2 - t1;
        return n;
    }

    private int BoyerMoore(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0) {
            comparisons++;
            return 0;
        }
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++)
            last.put(text[i], -1);
        for (int k = 0; k < m; k++)
            last.put(pattern[k], k);
        int i = m - 1;
        int k = m - 1;
        while (i < n) {
            comparisons++;
            if (text[i] == pattern[k]) {
                if (k == 0){
                    return i;
                }
                i--;
                k--;
            } else {
                i += m - Math.min(k, 1 + last.get(text[i])); // case analysis for jump step // restart at end of pattern
                k = m - 1;
            }
        }
        return -1; // pattern was never found
    }

    public int findKMP(char[] text, char[] pattern){
        comparisons = 0;
        time = 0;
        double t1 = System.currentTimeMillis();
        int n = KMP(text,pattern);
        double t2 = System.currentTimeMillis();
        time = t2 - t1;
        return n;
    }

    private int KMP(char[] text, char[] pattern) {
        comparisons = 0;
        time = 0;
        int n = text.length;
        int m = pattern.length;
        if (m == 0) return 0;

        int[] fail = computeFailKMP(pattern);
        int j = 0;
        int k = 0;
        while (j < n) {
            comparisons++;
            if (text[j] == pattern[k]) {
                if (k == m - 1) return j - m + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else
                j++;
        }
        return -1;
    }

    private int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];
        int j = 1;
        int k = 0;
        while (j < m) {
            comparisons++;
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k - 1];
            else
                j++;
        }
        return fail;
    }
}