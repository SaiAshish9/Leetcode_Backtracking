package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, res, curr);
        return res;
    }

    private void dfs(int start, int[] candidates, int target,
                     List<List<Integer>> res, List<Integer> curr) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curr.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], res, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
    // O(n.2^n) [[1, 2, 2], [5]]

}