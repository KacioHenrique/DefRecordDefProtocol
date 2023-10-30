(ns defprotocol-defrecord.defprotocol.shape)

(defprotocol Shape
  "Protocol for computing properties of geometrical shapes"
  (surface-area [shape]
    "The surface are of this shape."))

;defprotocol diferente de definterface pode receber metadata,
(:doc (meta #'Shape))  ;=> "Protocol for computing properties of geometrical shapes"
(:doc (meta #'surface-area));=> "The surface are of this shape."

(defrecord Rectangle [width height]
  Shape
  (surface-area [_]
    (* width height)))

(defrecord Circle [radius]
  Shape
  (surface-area [_]
    (* Math/PI (* radius radius))))

(surface-area (->Circle 1))          ;;=> 3.141592653589793
(surface-area (->Rectangle 2 3))     ;;=> 6

;Também é possível implementar um protocolo para um tipo já definido anteriormente,
; mesmo que o tipo seja fornecido por Java ou por uma biblioteca de terceiros.
; Acontece que Java já contém uma classe para representar retângulos.
; Ao estender o tipo para que ele implemente o protocolo Shape,
; agora você pode usar objetos do tipo Rectangle em seu código de forma transparente.
; Esta é uma ótima maneira de preencher a lacuna entre o código Clojure funcional
; e o código Java orientado a objetos ao trabalhar com bibliotecas de terceiros.

;*extend-type*
;extend-type para adicionar vários protocolos a um tipo de uma só vez.
(extend-type java.awt.Rectangle
  Shape
  (surface-area [rect]
    (* (.width rect) (.height rect))))

(surface-area (java.awt.Rectangle. 100 50))  ;=> 5000

;Às vezes você quer fazer o oposto: implementar um único protocolo
; para vários tipos. É para isso que serve extend-protocol.

(extend-protocol Shape
  java.awt.Rectangle
  (surface-area [rect]
    (* (.width rect) (.height rect)))

  java.awt.geom.Ellipse2D$Double
  (surface-area [e]
    (* Math/PI (.width e) (.height e))))

(surface-area (java.awt.Rectangle. 100 100)) ; => 10000
(surface-area (java.awt.geom.Ellipse2D$Double. 0 0 100 50)) ; => 15707.963267948966

