package me.klivenko.leetcode.contest.w182;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1396. Design Underground System
Difficulty:Medium
Implement the class UndergroundSystem that supports three methods:

1. checkIn(int id, string stationName, int t)

A customer with id card equal to id, gets in the station stationName at time t.
A customer can only be checked into one place at a time.
2. checkOut(int id, string stationName, int t)

A customer with id card equal to id, gets out from the station stationName at time t.
3. getAverageTime(string startStation, string endStation)

Returns the average time to travel between the startStation and the endStation.
The average time is computed from all the previous traveling from startStation to endStation that happened directly.
Call to getAverageTime is always valid.
You can assume all calls to checkIn and checkOut methods are consistent. That is, if a customer gets in at time t1 at some station, then it gets out at time t2 with t2 > t1. All events happen in chronological order.



Example 1:

Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

Output
[null,null,null,null,null,null,null,14.0,11.0,null,11.0,null,12.0]

Explanation
UndergroundSystem undergroundSystem = new UndergroundSystem();
undergroundSystem.checkIn(45, "Leyton", 3);
undergroundSystem.checkIn(32, "Paradise", 8);
undergroundSystem.checkIn(27, "Leyton", 10);
undergroundSystem.checkOut(45, "Waterloo", 15);
undergroundSystem.checkOut(27, "Waterloo", 20);
undergroundSystem.checkOut(32, "Cambridge", 22);
undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
undergroundSystem.checkIn(10, "Leyton", 24);
undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0
undergroundSystem.checkOut(10, "Waterloo", 38);
undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.0


Constraints:

There will be at most 20000 operations.
1 <= id, t <= 10^6
All strings consist of uppercase, lowercase English letters and digits.
1 <= stationName.length <= 10
Answers within 10^-5 of the actual value will be accepted as correct.
 */

/*
    https://leetcode.com/contest/weekly-contest-182/problems/design-underground-system/
 */

public class P5370_Design_Underground_System {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        double avg1 = undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        double avg2 = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        double avg3 = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        double avg4 = undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.0

        System.out.println(avg1);
        System.out.println(avg2);
        System.out.println(avg3);
        System.out.println(avg4);
    }

    static class UndergroundSystem {
        private Map<Integer, CheckIn> checkInMap = new HashMap();
        private Map<String, Map<String, List<Integer>>> avgTime = new HashMap();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new CheckIn(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckIn checkIn = checkInMap.get(id);
            checkInMap.remove(id);

            if (!avgTime.containsKey(checkIn.stationName)) {
                avgTime.put(checkIn.stationName, new HashMap());
            }

            if (!avgTime.get(checkIn.stationName).containsKey(stationName)) {
                avgTime.get(checkIn.stationName).put(stationName, new ArrayList());
            }

            avgTime.get(checkIn.stationName).get(stationName).add(Math.abs(t - checkIn.time));
        }

        public double getAverageTime(String startStation, String endStation) {
            List<Integer> avg = avgTime.get(startStation).get(endStation);

            int total = 0;
            for (int i = 0; i < avg.size(); i++) {
                total += avg.get(i);
            }
            return total / avg.size();
        }
    }

    public static class CheckIn {
        public String stationName;
        public int time;

        public CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
}

