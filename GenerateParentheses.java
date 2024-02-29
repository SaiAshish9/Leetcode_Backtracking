package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    private void dfs(String prefix, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(prefix);
            return;
        }
        if (left > 0) {
            dfs(prefix + '(', left - 1, right, res);
        }
        if (left < right) {
            dfs(prefix + ')', left, right - 1, res);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new org.example.GenerateParentheses().generateParenthesis(3));
    }
//    O(2^2n)


}
