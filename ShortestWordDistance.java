/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, distance = Integer.MAX_VALUE;
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1)
                    distance = Integer.min(distance, index1 - index2);
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1)
                    distance = Integer.min(distance, index2 - index1);
            }
        }
        return distance;
    }
}
