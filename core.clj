(ns clojure-heap.core
  {:doc "A heap is a tree-based data structure that satisfies the heap property, which is one maximally efficient implementation of a priority queue. 
         In a min-heap: for any given node C, if P is a parent node of C, then the key of P is less than or equal to the key of C.
         In a max-heap: for any given node C, if P is a parent node of C, then the key of P is greater than or equal to the key of C.
   "}
  (:refer-clojure :exclude [remove pop])
  (:gen-class)
  (:import [java.util PriorityQueue]))
  

(defn init-empty
  "initiate an empty heap"
  ([]
   (let [heap (PriorityQueue.)] heap))
  ([comparator]
   (let [heap (PriorityQueue. comparator)] heap)))

(defn init
  "Initiate a heap with an existing collection"
  ([coltn]
   (let [heapcoltn (init-empty)]
     (loop [iter 0]
       (if (<= iter (- (count coltn) 1))
         (do
           (add heapcoltn (nth coltn iter))
           (recur (inc iter)))))
     heapcoltn))
  ([coltn comparator]
   (let [heapcoltn (init-empty comparator)]
     (loop [iter 0]
       (if (<= iter (- (count coltn) 1))
         (do
           (add heapcoltn (nth coltn iter))
           (recur (inc iter)))))
     heapcoltn)))

(defn add
  "Add a new element to an existing heap"
  [heap ele]
  (.add heap ele)
  heap)

(defn remove
  "Remove an element from an existing heap"
  [heap ele]
  (.remove heap ele)
  heap)

(defn pop
  "Return the root without changing an existing heap"
  [heap]
  (.peek heap))

(defn poll
  "Return the root and take it out of an existing heap"
  [heap]
  (.poll heap))

(defn contains
  "Check if the heap contains an element"
  [heap ele]
  (.contains heap ele))

(defn size
  "Return the size of an existing heap"
  [heap]
  (.size heap))
