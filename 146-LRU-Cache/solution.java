public class LRUCache {
    
    static class Node {
        int key;
        int val;
        Node pre;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            refresh(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.val = value;
            refresh(node);
        } else {
            if (this.size == this.capacity) {
                evict();
                create(key, value);
            } else {
                this.size++;
                create(key, value);
            }
        }
    }
    
    private void refresh(Node node) {
        delete(node);
        add(node);
    }
    
    private void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void add(Node node) {
        node.next = this.head.next;
        node.pre = this.head;
        this.head.next.pre = node;
        this.head.next = node;
    }
    
    private void evict() {
        Node node = this.tail.pre;
        this.map.remove(node.key);
        delete(node);
    }
    
    private void create(int key, int val) {
        Node node = new Node(key, val);
        this.map.put(key, node);
        add(node);
    }
}