(ns defprotocol-defrecord.aplicationLevel.defrecord.book)

; o defrecord por padrão já implementa uma dúzia de interfaces do clojure
(defrecord Book [author title year])

; contrutores posicionais
(Book. "Ursula K. Le Guin" "The Dispossessed" 1974)
(->Book "Ursula K. Le Guin" "The Dispossessed" 1974)
(.title (->Book "a" "b" 1999))

; construtores de mapa

(map->Book {:title "The Caves of Steel" :author "Isaac Asimov" :year 1954})

; pelos fato de mentar as interfaces podemos usar expereções de equivaLencia
(= (map->Book {:author "Pat Cadigan", :title "Fools", :year 1992})
   (->Book "Pat Cadigan" "Fools" 1992))

;registros também se comporatam como mapas
(def book (->Book "Pat Cadigan" "Fools" 1992))

(get book :title)    ;;=> "Pat Cadigan"
(:title book)        ;;=> "Pat Cadigan"

(assoc book :title "The Player of Games")

;registros também são Seqable
(seq book)

(map first book)     ;;=> (:author :title :year)
(map key book)       ;;=> (:author :title :year)
(map val book)       ;;=> ("Iain M. Banks" "Consider Phlebas" 1987)

(into {} book)
