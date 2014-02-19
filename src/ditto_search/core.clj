(ns ditto-search.core
  (:use seesaw.core
        me.raynes.fs))

(def program-version
  "0.0.1")

(defn content
  ([] (content "/"))
  ([path] (listbox :model (sort (list-dir path)))))

;(listen content
;        :double (fn [e] (content (selection e))))

(defn -main [& args]
  (invoke-later
    (-> (frame :title (str "Ditto Search " program-version),
               :content (content),
               :on-close :exit)
        pack!
        show!)))
