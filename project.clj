(def trapperkeeper-version "4.3.0")
(def kitchensink-version "3.5.5")
(def i18n-version "1.0.3")

(defproject org.openvoxproject/trapperkeeper-filesystem-watcher "1.5.1-SNAPSHOT"
  :description "Trapperkeeper filesystem watcher service"
  :url "https://github.com/openvoxproject/trapperkeeper-filesystem-watcher"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :min-lein-version "2.9.1"

  :pedantic? :abort

  ;; These are to enforce consistent versions across dependencies of dependencies,
  ;; and to avoid having to define versions in multiple places. If a component
  ;; defined under :dependencies ends up causing an error due to :pedantic? :abort,
  ;; because it is a dep of a dep with a different version, move it here.
  :managed-dependencies [[org.clojure/clojure "1.12.4"]
                          [clj-time "0.15.2"]

                         [org.openvoxproject/kitchensink ~kitchensink-version]
                         [org.openvoxproject/kitchensink ~kitchensink-version :classifier "test"]
                         [org.openvoxproject/trapperkeeper ~trapperkeeper-version]
                         [org.openvoxproject/trapperkeeper ~trapperkeeper-version :classifier "test"]]

  :dependencies [[org.clojure/clojure]
                 [org.clojure/tools.logging "1.3.1"]
                 [prismatic/schema "1.4.1"]
                 [clj-commons/fs "1.6.312"]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/kitchensink]
                 [org.openvoxproject/i18n ~i18n-version]]

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]]

  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]

  :profiles {:dev {:dependencies [[org.openvoxproject/trapperkeeper
                                   :classifier "test"
                                   :scope "test"]
                                  [org.openvoxproject/kitchensink
                                   :classifier "test"
                                   :scope "test"]]}}

  :plugins  [[jonase/eastwood "1.4.3"]
             [org.openvoxproject/i18n ~i18n-version]]

  :main puppetlabs.trapperkeeper.main)
