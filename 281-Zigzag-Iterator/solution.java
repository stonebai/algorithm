public class ZigzagIterator {
    
    private List<Iterator<Integer>> iters;
    private int pos;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.iters = new ArrayList<Iterator<Integer>>();
        Iterator<Integer> i1 = v1.iterator();
        Iterator<Integer> i2 = v2.iterator();
        if (i1.hasNext()) {
            this.iters.add(i1);
        }
        if (i2.hasNext()) {
            this.iters.add(i2);
        }
        this.pos = 0;
    }

    public int next() {
        Iterator<Integer> iter = this.iters.get(this.pos);
        int res = iter.next();
        if (iter.hasNext()) {
            this.pos++;
        } else {
            this.iters.remove(this.pos);
        }
        return res;
    }

    public boolean hasNext() {
        return !this.iters.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */