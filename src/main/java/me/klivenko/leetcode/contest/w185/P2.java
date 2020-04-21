package me.klivenko.leetcode.contest.w185;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
1418. Display Table of Food Orders in a Restaurant
User Accepted:4229
User Tried:4486
Total Accepted:4284
Total Submissions:7352
Difficulty:Medium
Given the array orders, which represents the orders that customers have done in a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item customer orders.

Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered. The first column is the table number and the remaining columns correspond to each food item in alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the food items. Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order.



Example 1:

Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
Explanation:
The displaying table looks like:
Table,Beef Burrito,Ceviche,Fried Chicken,Water
3    ,0           ,2      ,1            ,0
5    ,0           ,1      ,0            ,1
10   ,1           ,0      ,0            ,0
For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
For the table 5: Carla orders "Water" and "Ceviche".
For the table 10: Corina orders "Beef Burrito".
Example 2:

Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
Explanation:
For the table 1: Adam and Brianna order "Canadian Waffles".
For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
Example 3:

Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]


Constraints:

1 <= orders.length <= 5 * 10^4
orders[i].length == 3
1 <= customerNamei.length, foodItemi.length <= 20
customerNamei and foodItemi consist of lowercase and uppercase English letters and the space character.
tableNumberi is a valid integer between 1 and 500.
 */

/*
https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class P2 {
    public static void main(String[] args) {
        List<List<String>> input = Arrays.asList(
                Arrays.asList("David", "3", "Ceviche"),
                Arrays.asList("Corina", "10", "Beef Burrito"),
                Arrays.asList("David", "3", "Fried Chicken"),
                Arrays.asList("Carla", "5", "Water"),
                Arrays.asList("Carla", "5", "Ceviche"),
                Arrays.asList("Rous", "3", "Ceviche")
        );

        List<List<String>> output = Arrays.asList(
                Arrays.asList("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
                Arrays.asList("3", "0", "2", "1", "0"),
                Arrays.asList("5", "0", "1", "0", "1"),
                Arrays.asList("10", "1", "0", "0", "0")
        );

        run(input, output);
    }

    public static void run(List<List<String>> input, List<List<String>> correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", input);
        List<List<String>> result = new Solution().displayTable(input);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            Set<String> allDishes = new TreeSet<>();
            Map<String, Integer> dishesIndex = new HashMap<>();
            Map<Integer, Map<String, Integer>> map = new TreeMap();
            for (int i = 0; i < orders.size(); i++) {
                List<String> list = orders.get(i);
                allDishes.add(list.get(2));

                Map<String, Integer> subMap = map.getOrDefault(Integer.parseInt(list.get(1)), new HashMap());
                Integer val = subMap.getOrDefault(list.get(2), 0);
                subMap.put(list.get(2), val + 1);

                map.put(Integer.parseInt(list.get(1)), subMap);
            }

            List<List<String>> result = new ArrayList<>();
            List<String> firstRow = new ArrayList<>();
            firstRow.add("Table");
            firstRow.addAll(allDishes);
            for (int i = 1; i < firstRow.size(); i++) {
                dishesIndex.put(firstRow.get(i), i);
            }
            result.add(firstRow);

            for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
                List<String> row = new ArrayList<>();
                for (int i = 0; i < allDishes.size() + 1; i++) {
                    row.add("0");
                }

                Map<String, Integer> val = entry.getValue();
                for (Map.Entry<String, Integer> subEntry : val.entrySet()) {
                    row.set(dishesIndex.get(subEntry.getKey()), subEntry.getValue().toString());
                }
                row.set(0, entry.getKey().toString());
                result.add(row);
            }

            return result;
        }
    }
}
