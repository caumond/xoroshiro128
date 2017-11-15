(ns xoroshiro128.test.performance
 (:require
  xoroshiro128.long-int
  [xoroshiro128.core :as x]
  #?(:clj criterium.core)
  [clojure.test :refer [deftest is]]))

#?(:clj (set! *warn-on-reflection* true))
#?(:clj (set! *unchecked-math* :warn-on-boxed))

(defn bench
 [f]
 #?(:clj (criterium.core/bench (f))
    :cljs
    (let [profile-name (gensym)
          start (.now js/performance)]
     (dotimes [n 1000000]
      (f))
     (prn
      (-
       (.now js/performance)
       start)))))

(defn bench-native
 []
 (bench xoroshiro128.long-int/native-rand))

(defn bench-rand
 []
 (bench x/rand))

; #?(:cljs
;    (deftest ??foo
;     (prn "benchmarking rand")
;     (bench-rand)
;
;     (prn "benchmarking native random long")
;     (bench-native)
;
;     (prn "benchmarking math random")
;     (bench Math.random)))
