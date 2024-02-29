package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LetterCombinations {

    public static List<String> digitToLetters = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    void dfs(String digits, int index, List<String> res, StringBuilder curr) {
        if (index == digits.length()) {
            res.add(curr.toString());
            return;
        }
        String chars = digitToLetters.get(Integer.parseInt(String.valueOf(digits.charAt(index))));

        for (char c : chars.toCharArray()) {
            curr.append(c);
            dfs(digits, index + 1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits, 0, res, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("2"));
    }
}