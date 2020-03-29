package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

    Initially, all the rooms start locked (except for room 0).

    You can walk back and forth between rooms freely.

    Return true if and only if you can enter every room.

    Example 1:

    Input: [[1],[2],[3],[]]
    Output: true
    Explanation:
    We start in room 0, and pick up key 1.
    We then go to room 1, and pick up key 2.
    We then go to room 2, and pick up key 3.
    We then go to room 3.  Since we were able to go to every room, we return true.
    Example 2:

    Input: [[1,3],[3,0,1],[2],[0]]
    Output: false
    Explanation: We can't enter the room with number 2.
    Note:

    1 <= rooms.length <= 1000
    0 <= rooms[i].length <= 1000

    The number of keys in all rooms combined is at most 3000.
 */

/*
    https://leetcode.com/problems/keys-and-rooms/
 */
public class P841_Keys_and_Rooms {

    public static void main(String[] args) {
        run(new int[][]{{1}, {2}, {3}, {}}, true);
        run(new int[][]{{1, 3}, {3, 0, 1}, {2}, {0}}, false);
    }

    public static void run(int[][] nums, boolean correctAnswer) {
        List<List<Integer>> listOfList = Utils.convert(nums);

        Utils.printBreakLine();
        Utils.print("start app with: ", listOfList);

        boolean result = new Solution().canVisitAllRooms(listOfList);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private boolean isAllVisited(boolean[] visited) {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    return false;
                }
            }

            return true;
        }

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] visited = new boolean[rooms.size()];
            for (int i = 0; i < rooms.size(); i++) visited[i] = false;

            Queue<Integer> queue = new LinkedList();
            queue.add(0);
            while (true) {
                if (queue.isEmpty()) {
                    break;
                }

                int currentRoomId = queue.poll();
                visited[currentRoomId] = true;

                List<Integer> room = rooms.get(currentRoomId);
                for (Integer roomId : room) {
                    if (roomId == currentRoomId) continue;

                    if (!visited[roomId]) {
                        queue.add(roomId);
                    }
                }
            }

            return isAllVisited(visited);
        }
    }
}
