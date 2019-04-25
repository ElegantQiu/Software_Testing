package cn.tju.scsst.lab.lab4;

import org.junit.Test;

import static org.junit.Assert.*;
public class TestBackPack {

    @Test
    public void testBackPack() {
        int m = 10;
        int n = 3;
        String res = "";
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack.BackPack_Solution(m, n, w, p);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res += c[i][j] + "\t";
                if (j == m) {
                    res += "\n";
                }
            }
        }
        String expected = "0\t0\t4\t4\t4\t4\t4\t4\t4\t4\t\n" +
                "0\t0\t4\t5\t5\t5\t9\t9\t9\t9\t\n" +
                "0\t0\t4\t5\t6\t6\t9\t10\t11\t11\t\n";
        assertEquals(expected, res);
    }
}