(def i18n-version "1.0.5")

(defproject org.openvoxproject/trapperkeeper-filesystem-watcher "1.6.2-SNAPSHOT"
  :description "Trapperkeeper filesystem watcher service"
  :url "https://github.com/openvoxproject/trapperkeeper-filesystem-watcher"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :min-lein-version "2.12.0"

  :pedantic? :abort

  ;; Generally, try to keep version pins in :managed-dependencies and the libraries
  ;; this project actually uses in :dependencies, inheriting the version from
  ;; :managed-dependencies. This prevents endless version conflicts due to deps of deps.
  ;; Renovate should keep the versions largely in sync between projects.
  :managed-dependencies [[org.clojure/clojure "1.12.6"]
                         [org.clojure/tools.logging "1.3.1"]

                         [clj-commons/fs "1.6.312"]
                         [clj-time "0.15.2"]
                         [org.openvoxproject/kitchensink "3.5.8"]
                         [org.openvoxproject/kitchensink "3.5.8" :classifier "test"]
                         [org.openvoxproject/trapperkeeper "5.0.6"]
                         [org.openvoxproject/trapperkeeper "5.0.6" :classifier "test"]
                         [prismatic/schema "1.4.2"]]

  :dependencies [[org.clojure/clojure]
                 [org.clojure/tools.logging]

                 [clj-commons/fs]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/kitchensink]
                 [org.openvoxproject/i18n ~i18n-version]
                 [prismatic/schema]]

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
