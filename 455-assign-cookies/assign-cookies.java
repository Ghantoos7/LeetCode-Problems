import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int sat_count = 0;
        int i = 0;
        int g_len = g.length;
        int s_len = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;

        while (i < g_len && j < s_len) {
            if (s[j] >= g[i]) {
                sat_count++;
                i++;
            }
            j++;
        }

        return sat_count;
    }
}
