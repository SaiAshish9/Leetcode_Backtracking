package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

   public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            curr.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], res, curr);
            curr.remove(curr.size() - 1);
        }
    }

}
