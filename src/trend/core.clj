(ns trend.core)

(defn- trend-pairs [s]
  (partition 2 1 s))

(defn- pair-score [[p1 p2]]
  (cond
    (and (zero? p1) (> p2 0)) 1
    (= p1 p2) 0
    :else (-> (- p2 p1) (/ p1))))

(defn- nil-or-empty? [s]
  (or (nil? s) (empty? s)))

(defn trend [s]
    (if (nil-or-empty? s)
      nil
      (->> (trend-pairs s) (map pair-score) (reduce +))))
