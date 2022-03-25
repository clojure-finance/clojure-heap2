# clojure-heap2
Heap in Clojure (from `java.util.PriorityQueue`)

A heap is a tree-based data structure that satisfies the heap property, which is one maximally efficient implementation of a priority queue.

- In a min-heap: for any given node C, if P is a parent node of C, then the key of P is less than or equal to the key of C.
- In a max-heap: for any given node C, if P is a parent node of C, then the key of P is greater than or equal to the key of C.

### Usage


The way to initiate an empty min-heap: 

``` clojure
user=> (def hmin (init-empty))
#'clojure-heap.core/hmin
user=> hmin
#object[java.util.PriorityQueue 0x62c1a9c2 "[]"]
```

The way to initiate an empty max-heap: 

```clojure
user=> (def hmax (init-empty >))
#'clojure-heap.core/hmax
user=> hmax
#object[java.util.PriorityQueue 0x5a34485d "[]"]
```

The way to min-heapify a collection:

```clojure
user=> (def hpmin (init [6 8 7 0 0 1 4 3 2]))
#'clojure-heap.core/hpmin
user=> hpmin
#object[java.util.PriorityQueue 0x2448f167 "[0, 0, 1, 2, 6, 7, 4, 8, 3]"]
```

The way to max-heapify a collection:

```clojure
user=> (def hpmax (init [6 8 7 0 0 1 4 3 2] >))
#'clojure-heap.core/hpmax
user=> hpmax
#object[java.util.PriorityQueue 0x3f84b171 "[8, 6, 7, 3, 0, 1, 4, 0, 2]"]
```

The way to add a new element to the heap:

```clojure
user=> (add hpmin 0)
#object[java.util.PriorityQueue 0x2448f167 "[0, 0, 1, 2, 0, 7, 4, 8, 3, 6]"]
user=> (add hpmax 1)
#object[java.util.PriorityQueue 0x3f84b171 "[8, 6, 7, 3, 1, 1, 4, 0, 2, 0]"]
```

The way to remove an element from the heap:

```clojure
user=> (remove hpmin 8)
#object[java.util.PriorityQueue 0x2448f167 "[0, 0, 1, 2, 0, 7, 4, 6, 3]"]
user=> (remove hpmax 3)
#object[java.util.PriorityQueue 0x3f84b171 "[8, 6, 7, 2, 1, 1, 4, 0, 0]"]                                                         
```

The way to return the root of the heap without changing the heap:

```clojure
user=> (pop hpmin)
0
user=> hpmin
#object[java.util.PriorityQueue 0x2448f167 "[0, 0, 1, 2, 0, 7, 4, 6, 3]"]
user=> (pop hpmax)
8
user=> hpmax
#object[java.util.PriorityQueue 0x3f84b171 "[8, 6, 7, 2, 1, 1, 4, 0, 0]"]
```

The way to return the root and take it out of an existing heap:

```clojure
user=> (poll hpmin)
0
user=> hpmin
#object[java.util.PriorityQueue 0x2448f167 "[0, 0, 1, 2, 3, 7, 4, 6]"]
user=> (poll hpmax)
8
user=> hpmax
#object[java.util.PriorityQueue 0x3f84b171 "[7, 6, 4, 2, 1, 1, 0, 0]"]
```

The way to check if the heap contains an element:

```clojure
user=> (contains hpmin 0)
true
user=> (contains hpmax 5)
false
```

The way to get the size of the heap

```clojure
user=> (size hpmin)
8
user=> (size hpmax)
8
```
