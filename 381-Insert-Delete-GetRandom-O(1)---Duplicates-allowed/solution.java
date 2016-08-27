public class RandomizedCollection {
    
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.map = new HashMap<Integer, Set<Integer>>();
        this.list = new ArrayList<Integer>();
        this.random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        this.list.add(val);
        if (this.map.containsKey(val)) {
            Set<Integer> set = this.map.get(val);
            set.add(this.list.size() - 1);
            return false;
        } else {
            Set<Integer> set = new HashSet<Integer>();
            set.add(this.list.size() - 1);
            this.map.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (this.map.containsKey(val)) {
            Set<Integer> set = this.map.get(val);
            if (!set.isEmpty()) {
                int index = set.iterator().next();
                set.remove(index);
                int index2 = this.list.size() - 1;
                int value = this.list.get(index2);
                this.list.set(index, value);
                this.list.remove(index2);
                Set<Integer> set2 = this.map.get(value);
                set2.remove(index2);
                set2.add(index);
                return true;
            }
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = this.random.nextInt(this.list.size());
        return this.list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */