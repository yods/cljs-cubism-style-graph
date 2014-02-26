(defproject cubism "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [reagent "0.4.1"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :preamble ["reagent/react.js"]
  :source-paths ["src"]

  :cljsbuild { 
    :builds [{:id "cubism"
              :source-paths ["src"]
              :compiler {
                :output-to "cubism.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
