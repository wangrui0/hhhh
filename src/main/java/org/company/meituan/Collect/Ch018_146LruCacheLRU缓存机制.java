package org.company.meituan.Collect;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>146. LRU 缓存机制
 * <p>运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 *
 * <p>实现 LRUCache 类：
 *
 * <p>    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * <p>    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * <p>    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * <p>进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * <p>示例：
 *
 * <p>输入
 * <p>["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * <p>[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * <p>输出
 * <p>[null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * <p>解释
 * <p>LRUCache lRUCache = new LRUCache(2);
 * <p>lRUCache.put(1, 1); // 缓存是 {1=1}
 * <p>lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * <p>lRUCache.get(1);    // 返回 1
 * <p>lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * <p>lRUCache.get(2);    // 返回 -1 (未找到)
 * <p>lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * <p>lRUCache.get(1);    // 返回 -1 (未找到)
 * <p>lRUCache.get(3);    // 返回 3
 * <p>lRUCache.get(4);    // 返回 4
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= capacity <= 3000
 * <p>    0 <= key <= 3000
 * <p>    0 <= value <= 104
 * <p>    最多调用 3 *<p>104 次 get 和 put
 *
 * <p>通过次数166,649
 * <p>提交次数318,279
 * <p>https://leetcode-cn.com/problems/lru-cache/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch018_146LruCacheLRU缓存机制 {


  class DLinkedNode {

    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int _key, int _value) {
      key = _key;
      value = _value;
    }
  }

  private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
  //现在容量
  private int size;
  //大小
  private int capacity;
  private DLinkedNode head, tail;

  public Ch018_146LruCacheLRU缓存机制(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    // 使用伪头部和伪尾部节点
    head = new DLinkedNode();
    tail = new DLinkedNode();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      return -1;
    }
    // 如果 key 存在，先通过哈希表定位，再移到头部
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      // 如果 key 不存在，创建一个新的节点
      DLinkedNode newNode = new DLinkedNode(key, value);
      // 添加进哈希表
      cache.put(key, newNode);
      // 添加至双向链表的头部
      addToHead(newNode);
      ++size;
      if (size > capacity) {
        // 如果超出容量，删除双向链表的尾部节点
        DLinkedNode tail = removeTail();
        // 删除哈希表中对应的项
        cache.remove(tail.key);
        --size;
      }
    } else {
      // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
      node.value = value;
      moveToHead(node);
    }
  }

  private void addToHead(DLinkedNode node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }

  //5
  //head->4->  5  ->3->2
  private void removeNode(DLinkedNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void moveToHead(DLinkedNode node) {
    removeNode(node);
    addToHead(node);
  }

  private DLinkedNode removeTail() {
    DLinkedNode res = tail.prev;
    removeNode(res);
    return res;
  }
}
