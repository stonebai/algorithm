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
    
    private Stack<List<NestedInteger>> stack;
    private Stack<Integer> index;
    private List<NestedInteger> list;
    private int pos;
    private Integer current;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
        this.stack = new Stack<List<NestedInteger>>();
        this.index = new Stack<Integer>();
        this.pos = 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Integer res = this.current;
            this.current = null;
            return res;
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
                if (this.list != null && this.pos < this.list.size()) {
                    NestedInteger tmp = this.list.get(this.pos);
                    this.pos++;
                    if (tmp.isInteger()) {
                        current = tmp.getInteger();
                        return true;
                    } else {
                        this.stack.push(this.list);
                        this.index.push(this.pos);
                        this.list = tmp.getList();
                        this.pos = 0;
                    }
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        this.list = this.stack.pop();
                        this.pos = this.index.pop();
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