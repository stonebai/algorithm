public class RandomizedSet {
    
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
        this.random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            this.list.add(val);
            this.map.put(val, this.list.size() - 1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = this.map.get(val).intValue();
            int value = list.get(this.list.size() - 1);
            this.list.set(index, value);
            this.map.put(value, index);
            this.map.remove(val);
            this.list.remove(this.list.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(this.list.size());
        return this.list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */