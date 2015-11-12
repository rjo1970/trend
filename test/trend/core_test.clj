(ns trend.core-test
  (:require [clojure.test :refer :all]
            [trend.core :refer :all]))

(deftest a-trend
  (testing "If the supplied list is empty or or does not exist (null), then the trend calculator should return null."
    (is (nil? (trend [])))
    (is (nil? (trend nil)))
  )
  (testing "If the list contains only a single value, then the trend calculator should return a value of 0."
    (is (= 0 (trend [42])))
  )
  (testing "Trend values"
    (is (= 0 (trend [1 1])))
    (is (= 1 (trend [0 0.01])))
    (is (= 1 (trend [1 2])))
    (is (= 11/6 (trend [1 2 3 4])))
  )
)
