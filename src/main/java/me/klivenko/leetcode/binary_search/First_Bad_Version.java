package me.klivenko.leetcode.binary_search;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */

/*
https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
 */
public class First_Bad_Version {
    public class Solution {
        private boolean isBadVersion(int n) {
            return true;
        }

        public int firstBadVersion(int n) {
            int left = 1, right = n, center;

            while(true) {
                if(left == right) return left;

                center = (int)(left / 2 + right / 2);

                if(isBadVersion(center) && !isBadVersion(center - 1)){
                    return center;
                }

                if(!isBadVersion(center)) {
                    left = center + 1;
                }else{
                    right = center;
                }
            }
        }
    }
}
