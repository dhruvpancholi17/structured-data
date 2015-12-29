(ns structured-data)

(def china {:name "China Miéville", :birth-year 1972})
(def octavia {:name "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def friedman {:name "Daniel Friedman" :birth-year 1944})
(def felleisen {:name "Matthias Felleisen"})

(def cities {:title "The City and the City" :authors [china]})
(def wild-seed {:title "Wild Seed", :authors [octavia]})
(def embassytown {:title "Embassytown", :authors [china]})
(def little-schemer {:title "The Little Schemer"
                     :authors [friedman, felleisen]})

(println "Loading structured-data")

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

(defn sum-pairs [[x1 y1] [x2 y2]]
  [(+ x1 x2) (+ y1 y2)])

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- x2 x1))
  )

(defn height [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- y2 y1))
  )

(defn square? [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (cond
      (= (- x2 x1) (- y2 y1)) true
      :else false)
    ))

(defn area [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (* (- x2 x1) (- y2 y1))
    ))

(defn contains-point? [rectangle point]
  (let [[[x1 y1] [x2 y2]] rectangle
        [x3 y3] point]
    (cond
      (and (<= x1 x3 x2) (<= y1 y3 y2)) true
      :else false)
    ))

(defn contains-rectangle? [outer inner]
  (let [[[x1 y1] [x2 y2]] outer
        [[x3 y3] [x4 y4]] inner]
    (cond
      (and (<= x1 x3 x4 x2) (<= y1 y3 y4 y2)) true
      :else false)
    ))

(defn title-length [book]
  (count (get book :title)))

(defn author-count [book]
  (count (get book :authors)))

(defn multiple-authors? [book]
  (> (count (get book :authors)) 1))

(defn add-author [book new-author]
  (assoc book :authors (conj (get book :authors) new-author))
  )

(defn alive? [author]
  (not (contains? author :death-year))
  )

(defn element-lengths [collection]
  (map count collection))

(defn second-elements [collection]
  (map second collection))

(defn titles [books]
  (map :title books))

; since a list of maps, and this from every map
; Can be extracted the given key
; (println (:name (get (:authors cities) 0)))
; (println (author-names cities))

(defn monotonic? [a-seq]
  (or (apply <= a-seq) (apply >= a-seq)))

(defn stars [n]
  (apply str (repeat n "*")))

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

(def books [cities, wild-seed, embassytown, little-schemer])

(def s (seq [1 2 3]))
; (println (seq {:a 42 :b "foo" :c ["ur" "dad"]}))
; (println s)
; (println (first s))
; (println (rest s))
; (println (cons 0 s))

(defn author-names [book]
  (map :name (:authors book)))

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
