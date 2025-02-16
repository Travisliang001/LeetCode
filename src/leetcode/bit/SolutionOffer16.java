package leetcode.bit;

public class SolutionOffer16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double res = 1.0;

        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>>= 1;
        }

        return res;
    }
}
