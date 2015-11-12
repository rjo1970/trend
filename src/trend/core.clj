(ns trend.core)

(defn trend-pairs [s]
  (if-let [pairs (partition 2 1 s)]
    pairs nil))

(defn pair-score [[p1 p2]]
  (cond
    (and (zero? p1) (> p2 0)) 1
    (= p1 p2) 0
    :else (-> (- p2 p1) (/ p1))))

(defn trend [s]
  (let [nil-or-empty? (or (nil? s) (empty? s))
        pairs (trend-pairs s)
        scores (map pair-score pairs)]
    (if nil-or-empty? nil (reduce + scores))))
