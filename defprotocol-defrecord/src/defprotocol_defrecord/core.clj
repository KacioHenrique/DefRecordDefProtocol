(ns defprotocol-defrecord.core)

(= [51 52 53] [51 52 53])
(= 9 19)
(= '(1 2 3) [1 2 3])

(conj [1 2 3] 4)
(conj `(1 2) 3)
(conj {:a 1 :b 2} {:c 3})

(deftype Pair [x y]
   Object
   (equals [_ you]
      (and (instance? Pair you)
           (= x (.x you))
           (= y (.y you)))))


;; without custom `equals`
(= (->Pair 4 5) (->Pair 4 5))

;; with custom `equals`
(= (->Pair 4 3) (->Pair 4 5))

