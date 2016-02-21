/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // O(n) time, O(n) space, 1 pass
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyDummy = new RandomListNode(0);
        map.put(dummy, copyDummy);
        dummy.next = head;
        RandomListNode ins = dummy;
        RandomListNode cur = ins.next;

        while(cur != null){
            if(!map.containsKey(cur)){
                RandomListNode copyCur = new RandomListNode(cur.label);
                map.put(cur, copyCur);
            }

            if(cur.random != null) {
                if(!map.containsKey(cur.random)){
                    RandomListNode copyCurRandom = new RandomListNode(cur.random.label);
                    map.put(cur.random, copyCurRandom);
                }
            }

            map.get(ins).next = map.get(cur);
            if(cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            }
            
            ins = cur;
            cur = cur.next;
        }

        return copyDummy.next;
    }
}
