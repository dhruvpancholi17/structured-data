(ns structured-data-test
  (:use midje.sweet
        structured-data))

(facts "height" {:exercise 1
					:points 1}
	(height (rectangle [1 1] [5 1])) => 0
	(height (rectangle [1 1] [5 5])) => 4
	(height (rectangle [0 0] [2 3])) => 3)

(facts "width" {:exercise 2
				:points 1}
	(width (rectangle [1 1] [5 1]))  => 4
	(width (rectangle [1 1] [1 1]))  => 0
	(width (rectangle [3 1] [10 4])) => 7)

(facts "square" {:exercise 3
				:points 1}
	(square? (rectangle [1 1] [2 2])) => true
	(square? (rectangle [1 1] [2 3])) => false
	(square? (rectangle [1 1] [1 1])) => true
	(square? (rectangle [3 2] [1 0])) => true
	(square? (rectangle [3 2] [1 1])) => false)

(facts "area" {:exercise 4
				:points 1}
	(area (rectangle [1 1] [5 1]))  => 0
	(area (rectangle [0 0] [1 1]))  => 1
	(area (rectangle [0 0] [4 3]))  => 12
	(area (rectangle [3 1] [10 4])) => 21)

(facts "contains-point?" {:exercise 5
				:points 1}
	(contains-point? (rectangle [0 0] [2 2])
                 (point 1 1))            => true
	(contains-point? (rectangle [0 0] [2 2])
	                 (point 2 1))            => true
	(contains-point? (rectangle [0 0] [2 2])
	                 (point -3 1))           => false
	(contains-point? (rectangle [0 0] [2 2])
	                 (point 1 3))            => false
	(contains-point? (rectangle [1 1] [2 2])
	                 (point 1 1))            => true
	(contains-point? (rectangle [1 1] [1 1])
	                 (point 1 1))            => true)

(facts "contains-rectangle?" {:exercise 6
				:points 1}
	(contains-rectangle? (rectangle [0 0] [3 3])
	                     (rectangle [1 1] [2 2])) => true
	(contains-rectangle? (rectangle [0 0] [2 2])
	                     (rectangle [1 1] [3 3])) => false
	(contains-rectangle? (rectangle [0 0] [1 1])
	                     (rectangle [0 0] [1 1])) => true
	(contains-rectangle? (rectangle [0 0] [1 1])
	                     (rectangle [1 1] [2 2])) => false)

(facts "title-length" {:exercise 7
				:points 1}
	(title-length cities)         => 21
	(title-length wild-seed)      => 9
	(title-length little-schemer) => 18)

(facts "author-count" {:exercise 8
				:points 1}
	(author-count cities)         => 1
	(author-count wild-seed)      => 1
	(author-count little-schemer) => 2)

(facts "multiple-authors?" {:exercise 9
				:points 1}
	(multiple-authors? cities)         => false
	(multiple-authors? wild-seed)      => false
	(multiple-authors? little-schemer) => true)

(facts "add-author" {:exercise 10
				:points 1}
	(add-author little-schemer {:name "Gerald J. Sussman"})
		=> {:title "The Little Schemer"
		   :authors [{:birth-year 1944, :name "Daniel Friedman"}
		             {:name "Matthias Felleisen"}
		             {:name "Gerald J. Sussman"}]}
	(add-author {:authors [{:name "Juhana"}]} {:name "Jani"})
		=> {:authors [{:name "Juhana"} {:name "Jani"}]})

(facts "alive?" {:exercise 11
				:points 1}
	(alive? china)   => true
	(alive? octavia) => false)

(facts "element-lengths" {:exercise 12
				:points 1}
	(element-lengths ["foo" "bar" "" "quux"])	=> [3 3 0 4]
	(element-lengths ["x" [:a :b :c] {:y 42}])	=> [1 3 1])

(facts "second-elements" {:exercise 13
				:points 1}
	(second-elements [[1 2] [2 3] [3 4]])	=> [2 3 4]
	(second-elements [[1 2 3 4] [1] ["a" "s" "d" "f"]])	=> [2 nil "s"])

(facts "titles" {:exercise 14
				:points 1}
	(titles [cities]) 	=> ["The City and the City"]
	(titles books) 		=> ["The City and the City" "Wild Seed" "Embassytown" "The Little Schemer"])

(facts "author-names" {:exercise 15
				:points 1}
	(author-names cities)		=> ["China Miéville"]
	(author-names little-schemer)	=> ["Daniel Friedman" "Matthias Felleisen"])

(facts "stars" {:exercise 16
				:points 1}
	(stars 1) => "*"
	(stars 7) => "*******"
	(stars 3) => "***")

(facts "monotonic?" {:exercise 16
				:points 1}
	(monotonic? [1 2 3])     => true
	(monotonic? [0 1 10 11]) => true
	(monotonic? [3 2 0 -3])  => true
	(monotonic? [3 2 2])     => true;    Not strictly monotonic
	(monotonic? [1 2 1 0])   => false)
