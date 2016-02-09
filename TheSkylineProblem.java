/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
Credits:
Special thanks to @stellari for adding this problem, creating these two awesome images and all test cases.
*/

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        TreeMap<Integer, Integer> availableHeights = new TreeMap<>();
        List<int[]> view = new ArrayList<>(buildings.length);
        int N = buildings.length;
        if (N == 0) {
            return view;
        }
        Event[] events = new Event[N << 1];
        for (int i = 0; i < N; ++i) {
            int[] building = buildings[i];
            events[i << 1] = new Event(building[0], building[2], false);
            events[1 + (i << 1)] = new Event(building[1], building[2], true);
        }
        Arrays.sort(events);
        int currentHeight = 0;
        availableHeights.put(0, 1);
        for (int i = 0, j; i < N << 1; i = j) {
            for (j = i; j < N << 1 && events[i].x == events[j].x; ++j) {
                Event event = events[j];
                if (event.closing) {
                    int counter = availableHeights.get(event.height);
                    if (counter == 1) {
                        availableHeights.remove(event.height);
                    } else {
                        availableHeights.put(event.height, counter - 1);
                    }
                } else {
                    Integer counter = availableHeights.get(event.height);
                    if (counter == null) {
                        availableHeights.put(event.height, 1);
                    } else {
                        availableHeights.put(event.height, counter + 1);
                    }
                }
            }
            int x = events[i].x;
            int height = availableHeights.lastKey();
            if (height != currentHeight) {
                view.add(new int[] { x, height });
                currentHeight = height;
            }
        }
        return view;
    }
}

class Event implements Comparable<Event> {
    int x, height;
    boolean closing;

    public Event(int a, int b, boolean c) {
        x = a;
        height = b;
        closing = c;
    }

    @Override
    public int compareTo(Event that) {
        return x != that.x ? x - that.x : Boolean.compare(closing, that.closing);
    }
}
