import java.util.HashMap;
import java.util.Map;

public class Day45LRUCache {
        //define a doubly linked list node to store key-value pairs
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //capacity of the cache
    private int capacity;
    //map to store key and corresponding Node
    private Map<Integer, Node> map_cache;
    //head and tail of the doubly linked list
    private Node head;
    private Node tail;

    public Day45LRUCache(int capacity) {
        this.capacity = capacity;
        this.map_cache = new HashMap<>();
        //Initialize dummy head and tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        //connect the head and tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map_cache.containsKey(key)){
            //if key exists, move the corresponding node to the front (most recently used)
            Node node = map_cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1; //if key doesn't exists
    }
    
    public void put(int key, int value) {
        if(map_cache.containsKey(key)){
            //if key exists, update the value and move the corresponding node to the front
            Node node = map_cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            //if key doesn't exists, create a new node and add it to the front
            Node newNode = new Node(key, value);
            map_cache.put(key, newNode);
            addToFront(newNode);

            //if capacity is exceeded, remove the least recently used node from the back
            if(map_cache.size() > capacity){
                Node removedNode = removeFromTail();
                map_cache.remove(removedNode.key);
            }
        }
    }

    //method to move a node to the front of the doubly linked list
    private void moveToHead(Node node){
        removeNode(node);
        addToFront(node);
    }
    //method to add a node to the front of the doubly linked list
    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    //method to remove a node from the doubly linked list
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //method to remove the last node (least recently use) from the DLL
    private Node removeFromTail(){
        Node removedNode = tail.prev;
        removeNode(removedNode);
        return removedNode;
    }

    public static void main(String[] args){
        Day45LRUCache lruCache = new Day45LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // Output: 1
        lruCache.put(3, 3); // Remove the least recently used key (2)
        System.out.println(lruCache.get(2)); // Output: -1 (not found)
        lruCache.put(4, 4); // Remove the least recently used key (1)
        System.out.println(lruCache.get(1)); // Output: -1 (not found)
        System.out.println(lruCache.get(3)); // Output: 3
        System.out.println(lruCache.get(4)); // Output: 4
    }
}
