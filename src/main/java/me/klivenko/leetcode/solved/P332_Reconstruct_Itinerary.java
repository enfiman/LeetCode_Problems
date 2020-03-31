package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

public class P332_Reconstruct_Itinerary {
    public static void main(String[] args) {

        List<List<String>> list1 = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO"));
        List<String> output1 = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        run(list1, output1);


        List<List<String>> list2 = Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO"));
        List<String> output2 = Arrays.asList("JFK","ATL","JFK","SFO","ATL","SFO");
        run(list2, output2);

        List<List<String>> list3 = Arrays.asList(
                Arrays.asList("JFK","KUL"),
                Arrays.asList("JFK","NRT"),
                Arrays.asList("NRT","JFK"));

        List<String> output3 = Arrays.asList("JFK","NRT","JFK","KUL");
        run(list3, output3);
    }

    public static void run(List<List<String>> tickets, List<String> correctAnswer) {
        Utils.print("start app with: ", tickets);
        List<String> result = new Solution().findItinerary(tickets);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private Map<String, List<String>> fromToMap = new HashMap<>();
        private List<String> path = new ArrayList<>();
        private Integer routeLength;

        public List<String> findItinerary(List<List<String>> tickets) {
            this.routeLength = tickets.size() + 1;

            for(int i = 0; i < tickets.size(); i++){
                if(!fromToMap.containsKey(tickets.get(i).get(0))){
                    fromToMap.put(tickets.get(i).get(0), new ArrayList<>());
                }
                fromToMap.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }

            for (Map.Entry<String, List<String>> entry : fromToMap.entrySet()) {
                Collections.sort(entry.getValue());
            }

            path.add("JFK");
            dfs("JFK");
            return path;
        }

        private boolean dfs(String start){
            List<String> toPossible = fromToMap.get(start);
            if(null == toPossible) return false;

            for(int i = 0; i < toPossible.size(); i++){
                String to = toPossible.get(i);
                toPossible.remove(i);

                path.add(to);

                boolean res = dfs(to);

                if(path.size() == routeLength) {
                    return true;
                }

                if(res == true) return true;
                path.remove(path.size() - 1);
                toPossible.add(i, to);
            }

            return false;
        }
    }
}
