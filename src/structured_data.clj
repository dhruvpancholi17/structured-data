(ns structured-data)

(defn do-a-thing-orig [x]
  (Math/pow (+ x x) (+ x x)))

(defn do-a-thing [x]
  (let [x2 (+ x x)]
      (Math/pow x2 x2)
    ))

(defn spiff [v]
  (cond
    (< (count v) 3) "?"
    :else (+ (get v 0) (get v 2))
    ))

(defn cutify [v]
  (conj v "<3"))

(defn spiff-destructuring [v]
  (cond
    (< (count v) 3) "?"
    :else (let [[v1 v2 v3] v] (+ v1 v3))
    ))

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  :-)

(defn height [rectangle]
  :-)

(defn square? [rectangle]
  :-)

(defn area [rectangle]
  :-)

(defn contains-point? [rectangle point]
  :-)

(defn contains-rectangle? [outer inner]
  :-)

(defn title-length [book]
  :-)

(defn author-count [book]
  :-)

(defn multiple-authors? [book]
  :-)

(defn add-author [book new-author]
  :-)

(defn alive? [author]
  :-)

(defn element-lengths [collection]
  :-)

(defn second-elements [collection]
  :-)

(defn titles [books]
  :-)

(defn monotonic? [a-seq]
  :-)

(defn stars [n]
  :-)

(defn toggle [a-set elem]
  :-)

(defn contains-duplicates? [a-seq]
  :-)

(defn old-book->new-book [book]
  :-)

(defn has-author? [book author]
  :-)

(defn authors [books]
  :-)

(defn all-author-names [books]
  :-)

(defn author->string [author]
  :-)

(defn authors->string [authors]
  :-)

(defn book->string [book]
  :-)

(defn books->string [books]
  :-)

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

(defn hypotenuse [x y] 
  (let [xx (* x x )
        yy (* y y)]
    (Math/sqrt (+ xx yy)))
  )

; %________%
