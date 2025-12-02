# Exam 3 - Capstone Project
Option C: The Intelligent Cache (Hash Tables & Lists)
Real-World Context: Web browser caches, "Recent Chats" history, or Fraud Detection systems.
The Problem: Providing instant access to frequently used data while managing limited memory.
Key Challenge: How do you store millions of records to allow for $O(1)$ instant retrieval?
Required Structures: HashMap combined with a Doubly Linked List (LRU Cache pattern) or Dynamic Arrays.

Design Choice Explanation:
I chose Option C because 
I chose Option C because many real systems, such as web browsers and “Recent Chats” lists, need to return frequently 
used data instantly while still working within limited memory. An Array or Linked List can not do that efficently, 
while the array gives fast random access by index it can not find items by key because then the complexity for the 
operation would be O(n) which is too long. A list list makes insertion and removal fast but searching for an item by 
the key is O(n) which is also not good. 

In order to get both fast loopup and efficent recency updates using Hashmaps and Doubly Linked Lists make sense because
The HashMap stores mappings from the key such as a chat ID to a node in the list so that lookups would be O(1), The 
doubly linked list maintains items in order from most recently used (head) to least recently used(tail) and because 
every node has prev and next moving a note to the front orremoving it from the tail is O(1). When the cache is 
full and a new item is added, the least recently used item at the tail is removed. 

Because the cache uses a HashMap from key to list node every get(key) and containsKey(key) call performs a HashMap lookup 
in O(1) expected time. After the node is found removeNode and addNodeAtHead also becomes O(1) since they update only a few
pointers. The put(key, value) operation either updates an existing node (lookup + move to head) or inserts a new node at the
head and, if needed, removes the tail node and all of them are also O(1). So both get and put run in O(1) which is really good


UML Diagram
```mermaid
classDiagram
    class CacheNode {
        int key
        Object value
        CacheNode prev
        CacheNode next
    }

    class IntelligentCache {
        int capacity
        Map~Integer, CacheNode~ map
        CacheNode head
        CacheNode tail
        +IntelligentCache(int capacity)
        +Object get(int key)
        +void put(int key, Object value)
        +boolean containsKey(int key)
        +int size()
        +boolean isEmpty()
        -void moveToHead(CacheNode node)
        -void removeNode(CacheNode node)
        -void addNodeAtHead(CacheNode node)
        -void evictLeastRecentlyUsed()
    }

    IntelligentCache "1" --> "*" CacheNode : maintains
