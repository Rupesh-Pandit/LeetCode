class LRUCache {
    public class Node {
        Node prev;
        Node next;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public Node head = new Node(-1, -1);
    public Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<>();
    int limit;

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
           deleteNode(map.get(key));
           addNode(map.get(key));
            return map.get(key).val;
        }
        else
            return -1;
    }

    public void deleteNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public void addNode(Node newNode){
        Node oldNode = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldNode;
        oldNode.prev = newNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            deleteNode(oldNode);
            map.remove(key);
        }

        if (map.size() == limit) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */