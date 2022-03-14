(ns HeapClj.core
  (:doc "A heap or priority queue is a tree-based data structure
         that satisfies the heap property: for any given node C,
         if P is a parent node of C, then the key of P is less than
         or equal to the key of C.")
  (:gen-class)
  (:import [java.util PriorityQueue]))


(defn init-empty
  "initiate an empty heap"
  []
  (let [heap (PriorityQueue.)] heap))

(defn init [coltn]
  "Initiate a heap with an existing collection"
  (let [heapcoltn (init-empty)]
    (loop [iter 0]
      (if (<= iter (.indexOf coltn (last coltn)))
        (do
          (add heapcoltn (nth coltn iter))
          (recur (inc iter)))))
    (println heapcoltn)))

(defn add
  "Add a new element to an existing heap"
  [heap ele]
  (.add heap ele))

(defn remo
  "Remove an element from an existing heap"
  [heap ele]
  (.remove heap ele))

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

(let [a (init-empty)]
  (add a 5)
  (add a 6)
  (add a 1)
  (add a 4)
  (println (pop a))
  (println a)
  (remo a 4)
  (println a))