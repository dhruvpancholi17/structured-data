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

(defn monotonic? [a-seq]
  (or (apply <= a-seq) (apply >= a-seq)))

(defn stars [n]
  (apply str (repeat n "*")))

(defn toggle [a-set elem]
  (cond
    (contains? a-set elem) (disj a-set elem)
    :else (conj a-set elem)))

(defn contains-duplicates? [a-seq]
  (let [total_count (count a-seq)]
    (not (= (count (set a-seq)) total_count))
    ))

(defn old-book->new-book [book]
  (assoc book :authors (set (:authors book)))
  )

(defn author-names [book]
  (map :name (:authors book)))

(defn has-author? [book author]
  (let [authors (set (author-names book))]
    (contains?  authors (:name author)))
)

(defn authors [books]
  (map :name
    (apply concat 
      (map :authors books)
    )
  )
)

(def books [cities, wild-seed, embassytown, little-schemer])

(defn all-author-names [books]
  (let [author-names (fn [book] (map :name (:authors book)))]
    (set (apply concat (map author-names books)))
    ))

(defn author->string [author]
  (cond
    (and (contains? author :birth-year) (contains? author :death-year)) (format "%s (%d - %d)" (:name author) (:birth-year author) (:death-year author))
    (and (contains? author :birth-year) (not (contains? author :death-year))) (format "%s (%d - )" (:name author) (:birth-year author))
    :else (format "%s" (:name author))
    ))

(defn authors->string [authors]
  (apply str (interpose ", " (map author->string authors))
    ))

(defn book->string [book]
  (format "%s, written by %s" (:title book) (authors->string (:authors book))))

(defn books->string [books]
  (let [books-text (apply str (interpose ". " (map book->string books)))
        books-count (count books)
        books-count-text (cond
            (= books-count 0) "No books."
            (= books-count 1) "1 book."
            :else (format "%d books." books-count)
          )
    ] (cond
        (= books-count 0) books-count-text
        :else (format "%s %s." books-count-text books-text)
      )) 
  )

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
