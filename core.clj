(ns HeapClj
  {:doc "A heap or priority queue is a tree-based data structure that satisfies the heap property: for any given node C,
         if P is a parent node of C, then the key of P is less than or equal to the key of C.
         
         The way to initiate an empty heap:
         user=> (def h (init-empty))
         #'HeapClj/h
         user=> h
         #object[java.util.PriorityQueue 0x1dc4841c " [] "]
                                                        
         The way to heapify a collection:
         user=> (def hp (init [6 8 7 0 0 1 4 3 2]))
         #'HeapClj/hp
         user=> hp
         #object[java.util.PriorityQueue 0x5b6e88b0 " [0, 0, 1, 2, 6, 7, 4, 8, 3] "]
                                                                                 
         The way to add a new element to the heap:
         user=> (add hp 1)
         #object[java.util.PriorityQueue 0x17992989 " [0, 0, 1, 2, 1, 7, 4, 8, 3, 6] "]
         user=> (add hp 0)
         #object[java.util.PriorityQueue 0x17992989 " [0, 0, 1, 2, 0, 7, 4, 8, 3, 6, 1] "]                                                                        
                                                                                       
         The way to remove an element from the heap:
         user=> (remo hp 8)
         #object[java.util.PriorityQueue 0x17992989 " [0, 0, 1, 1, 0, 7, 4, 2, 3, 6] "]
         user=> (remo hp 0)      
         #object[java.util.PriorityQueue 0x17992989 " [0, 0, 1, 1, 6, 7, 4, 2, 3] "]                                                                     
                                                                                 
         The way to return the root of the heap without changing the heap:
         user=> (pop-root hp)
         0
                                                                              
         The way to return the root and take it out of an existing heap:
         user=> hp
         #object[java.util.PriorityQueue 0x17992989 "[0, 0, 1, 1, 6, 7, 4, 2, 3]"]
         user=> (poll hp)
         0
         user=> hp
         #object[java.util.PriorityQueue 0x17992989 "[0, 1, 1, 2, 6, 7, 4, 3]"]
                                                                                 
         The way to check if the heap contains an element:
         user=> (contains hp 0)
         true
         user=> (contains hp 5)                                                                    
         false
   
         The way to get the size of the heap
         user=> (size hp)
         8                                                                     
   "}
  
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
      (if (<= iter (- (count coltn) 1))
        (do
          (add heapcoltn (nth coltn iter))
          (recur (inc iter)))))
    heapcoltn))

(defn add
  "Add a new element to an existing heap"
  [heap ele]
  (.add heap ele)
  heap)

(defn remo
  "Remove an element from an existing heap"
  [heap ele]
  (.remove heap ele)
  heap)

(defn pop-root
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
