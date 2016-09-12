public class Vector2D implements Iterator<Integer> {
    
    private Iterator<List<Integer>> lIter;
    private Iterator<Integer> iIter;

    public Vector2D(List<List<Integer>> vec2d) {
        this.lIter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return this.iIter.next();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while (this.iIter == null || !this.iIter.hasNext()) {
            if (this.lIter.hasNext()) {
                this.iIter = this.lIter.next().iterator();
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */