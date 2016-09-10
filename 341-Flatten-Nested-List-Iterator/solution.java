/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<Iterator<NestedInteger>> stack = new Stack<>();
    private Iterator<NestedInteger> iterator;
    private Integer current;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = nestedList.iterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return current;
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if (current != null) {
            return true;
        } else {
            while (true) {
                if (iterator.hasNext()) {
                    NestedInteger tmp = iterator.next();
                    if (tmp.isInteger()) {
                        current = tmp.getInteger();
                        return true;
                    } else {
                        stack.push(iterator);
                        iterator = tmp.getList().iterator();
                    }
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        iterator = stack.pop();
                    }
                }
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */