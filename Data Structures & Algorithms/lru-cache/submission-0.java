class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        head = new Node(-1, -1);
        head.prev = null;

        tail = new Node(-1, -1);
        tail.prev = head;
        tail.next = null;
        head.next = tail;                
    }

    public void moveNodeToHead(Node node) {
        //

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = head;
        node.next = head.next;
    }
    
    public int get(int key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);

            // move node to head
           removeNode(node);
           addNode(node);

            return node.value;
        } else {
            return -1;
        }
        
    }

    public void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
        
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;            
            removeNode(node);
            addNode(node);
        } else {
            // new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);

            // check capacity and remove if over
            if (map.size() > capacity) {
                Node lastNode = tail.prev;
                map.remove(lastNode.key);
                System.out.println(lastNode.key);
                removeNode(lastNode);
                
              
            } 

            addNode(newNode);
        }
    }
}
