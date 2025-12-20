(defproject org.openvoxproject/trapperkeeper-filesystem-watcher "1.2.7-SNAPSHOT"
  :description "Trapperkeeper filesystem watcher service"
  :url "https://github.com/openvoxproject/trapperkeeper-filesystem-watcher"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :min-lein-version "2.9.1"

  :parent-project  {:coords [org.openvoxproject/clj-parent "7.4.1-SNAPSHOT"]
                    :inherit [:managed-dependencies]}

  :pedantic? :abort

  :dependencies [[org.clojure/clojure]
                 [org.clojure/tools.logging]
                 [prismatic/schema]
                 [clj-commons/fs]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/kitchensink]
                 [org.openvoxproject/i18n]]

  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
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

  :plugins  [[lein-parent "0.3.7"]
             [jonase/eastwood "1.4.2"]
             [org.openvoxproject/i18n "0.9.3-SNAPSHOT"]]

  :main puppetlabs.trapperkeeper.main)
