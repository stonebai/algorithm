/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger cur = null;
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        char[] chs = s.toCharArray();
        for (int i = 0;i < chs.length;i++) {
            if ((chs[i] >= '0' && chs[i] <= '9') || chs[i] == '-') {
                int sign = 1;
                if (chs[i] == '-') {
                    sign = -1;
                    i++;
                }
                int num = 0;
                for (;i < chs.length;i++) {
                    if (chs[i] >= '0' && chs[i] <= '9') {
                        num = num * 10 - '0' + chs[i];
                    } else {
                        break;
                    }
                }
                if (cur == null) {
                    return new NestedInteger(num * sign);
                } else {
                    cur.add(new NestedInteger(num * sign));
                }
                i--;
            } else if (chs[i] == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
            } else if (chs[i] == ']') {
                if (!stack.isEmpty()) {
                    NestedInteger tmp = cur;
                    cur = stack.pop();
                    cur.add(tmp);
                }
            }
        }
        return cur;
    }
}