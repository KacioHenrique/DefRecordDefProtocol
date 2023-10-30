(ns defprotocol-defrecord.lowLevel.deftype.book)

;using deftype

(deftype BookVanila [author title year]
  #_ Object
  #_ (equals [this other]
    (and (instance? BookVanila other)
         (= (.author this) (.author other))
         (= (.title this) (.title other))
         (= (.year this)  (.year other)))))

(BookVanila. "Ursula K. Le Guin" "The Dispossessed" 1974)
(->BookVanila "Ursula K. Le Guin" "The Dispossessed" 1974)
(.title (->BookVanila "a" "b" 1999))

;; sem implementação de equals
;; decomentar  linhas 6, 7 e mostrar com a implementação de equals
(= (BookVanila. "Ursula K. Le Guin" "The Dispossessed" 1974)
   (->BookVanila "Ursula K. Le Guin" "The Dispossessed" 1974))

(def book (->BookVanila "Pat Cadigan" "Fools" 1992))
(assoc book :title "The Player of Games")
