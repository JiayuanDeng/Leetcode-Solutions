import java.util.Hashtable; 

public class LRUCache {
    Hashtable<Integer, ListNode> ht;
    ListNode mru;
    ListNode lru;
    int count;
    int capacity;
    
    public LRUCache(int capacity) {
        ht = new Hashtable<Integer, ListNode>();
        lru = null;
        count = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node = ht.get(key);
        if (node == null){
            return -1;
        }
        else{
            updateMRU(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        ListNode node = ht.get(key);
        if (node == null){
            node = new ListNode(key, value);
            if (count >= capacity){
                ht.remove(lru.key);
                if(lru.next != null){
                	lru = lru.next;
                	lru.prev = null;
                }
                count--;
            }
            
            if (count == 0){
                mru = node;
                lru = node;
            }
            else{
                mru.next = node;
                node.prev = mru;
                mru = node;
            }
            
            ht.put(key, node);
            count++;
        }
        else{
            updateMRU(node);
            node.val = value;
        }
    }
    
    private void updateMRU(ListNode node){
        if (node.next == null){
            return;
        }
        else{
        	if (node.prev == null){
        		lru = lru.next;
        	}
        	removeNode(node);
        	mru.next = node;
        	node.prev = mru;
            mru = node;
        }
    }
    
    private void removeNode(ListNode node){
    	if (node.prev == null && node.next == null){
    		return;
    	}
    	else if (node.prev == null){
    		node.next.prev = null;
    		node.next = null;
    	}
    	else if (node.next == null){
    		node.prev.next = null;
    		node.prev = null;
    	}
    	else{
    		node.next.prev = node.prev;
    		node.prev.next = node.next;
    		node.prev = null;
    		node.next = null;
    	}
    }
    
    public class ListNode{
    	int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int k, int v){
        	key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
}