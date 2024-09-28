class Node {
    int val;
    Node next;
    Node prev;
    
    public Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque {
    int maxSize, listSize;
    Node head, tail;
    
    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.listSize = 0;
        head = tail = null;
    }
    
    public boolean insertFront(int value) {
        if (listSize == maxSize) {
            return false;
        }
        
        Node newNode = new Node(value);
        
        if (listSize == 0) {
            // When deque is empty, set both head and tail to new node
            head = tail = newNode;
            head.next = head.prev = head; // circular references
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        
        listSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (listSize == maxSize) {
            return false;
        }
        
        Node newNode = new Node(value);
        
        if (listSize == 0) {
            // When deque is empty, set both head and tail to new node
            head = tail = newNode;
            head.next = head.prev = head; // circular references
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        
        listSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (listSize == 0) {
            return false;
        }
        
        if (listSize == 1) {
            head = tail = null; // When there is only one element
        } else {
            Node curr = head;
            head = head.next;
            tail.next = head;
            head.prev = tail;
            curr.next = curr.prev = null; // Clear references for GC
        }
        
        listSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (listSize == 0) {
            return false;
        }
        
        if (listSize == 1) {
            head = tail = null; // When there is only one element
        } else {
            Node curr = tail;
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            curr.prev = curr.next = null; // Clear references for GC
        }
        
        listSize--;
        return true;
    }
    
    public int getFront() {
        if (listSize == 0) {
            return -1;
        }
        return head.val;
    }
    
    public int getRear() {
        if (listSize == 0) {
            return -1;
        }
        return tail.val;
    }
    
    public boolean isEmpty() {
        return listSize == 0;
    }
    
    public boolean isFull() {
        return listSize == maxSize;
    }
}