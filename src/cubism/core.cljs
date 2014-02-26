(ns cubism.core
  (:require [reagent.core :as reagent :refer [atom]]))
 


(def numbers (atom (apply vector (repeatedly 10 #(rand-int 300
                                   )))))

(defn update-numbers []
  (let [new (rand-int 300)]
    (reset! numbers (conj (take 9 @numbers) new))))
;;   (swap! (swap! @numbers conj new) drop 1)))

(defn line-from-numbers []
  ;;(update-numbers)
  
  [:svg {:viewBox "0 0 1200 500"}
   (for [i (range  (- (count @numbers) 1))]
     [:line {:x1 (* i 50) :y1 (@numbers i) :x2 (* 50 (+ i 1)) :y2 (@numbers (+ i 1)) :stroke-width 5 :fill "black" :stroke "green"}]
     )
   ])

(defn some-component []
  
  [:div
   [:h3 "I am a component!"]
   [:p.someclass 
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text."]
   [:svg [:circle {:cx 100 :cy 100 :r 10}]]
     (line-from-numbers)
 
  ])

  
  (reagent/render-component [some-component]

                          (.-body js/document))

  
  (update-numbers)
 
