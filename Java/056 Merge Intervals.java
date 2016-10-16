/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Long> nodes = new ArrayList<Long>();
        for (Interval interval : intervals){
            nodes.add((long)(2 * interval.start));
            nodes.add((long)(2 * interval.end + 1));
        }
        Collections.sort(nodes);
        Stack<Integer> stack = new Stack<Integer>();
        List<Interval> result = new LinkedList<Interval>();
        int start, end;
        for (long node : nodes){
            if (node % 2 == 1){
                start = stack.pop();
                if (stack.isEmpty()){
                    end = (int)(node/2);
                    result.add(new Interval(start, end));
                }
            }
            else{
                stack.push((int)(node/2));
            }
        }
        return result;
    }
}