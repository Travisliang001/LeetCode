package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        backtrack(new StringBuilder(), n, n);

        return res;
    }

    private void backtrack(StringBuilder element, int left, int right) {
        // 结束条件
        if (left == 0 && right == 0) {
            res.add(element.toString());
            return;
        }

        // 做选择，先狂加左括号
        if (left > 0) {
            left--;
            element.append("(");

            backtrack(element, left, right);

            left++;
            element.deleteCharAt(element.length() - 1);
        }
        // 再加右括号，注意需要右值大于左值才能加
        if (right > 0 && left < right) {
            right--;
            element.append(")");

            backtrack(element, left, right);

            right++;
            element.deleteCharAt(element.length() - 1);
        }
    }
}
