// Comment to get more information during initialization
logLevel := Level.Warn

// Resolvers
// resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.22")
addSbtPlugin("com.twitter" %% "scrooge-sbt-plugin" % "19.11.0")
