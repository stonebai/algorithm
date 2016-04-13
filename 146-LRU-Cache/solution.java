public class LRUCache {
    
    private class Node {
        
        public int key;
        public int val;
        public Node pre;
        public Node next;
        
        public Node(int x, int y) {
            key = x;
            val = y;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    private int capacity;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node != null) {
            moveToHead(node);
            return node.val;   
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        }
        else {
            if(size>=capacity) {
                evict();
            }
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
        }
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    
    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }
    
    private void evict() {
        Node node = tail.pre;
        map.remove(node.key);
        deleteNode(node);
        size--;
    }
}