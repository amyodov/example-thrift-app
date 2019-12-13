name := "sample-thrift-app"

// Thrift is the API syntax specifier.
val thriftVersion = "0.13.0"
// Scrooge is the SBT automation to make Scala interfaces from Thrift API definitions automatically.
val scroogeVersion = "19.11.0"
// Twitter-made high-concurrency RPC server and client pair.
val finagleVersion = "19.11.0"

lazy val commonSettings = Seq(
  organization := "com.myodov",
  maintainer := "Alex Myodov <amyodov@gmail.com>",
  version := "0.1.0",
  scalaVersion := "2.12.10",
  libraryDependencies ++= Seq(
    //    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
    //    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "org.apache.thrift" % "libthrift" % thriftVersion,
    "com.twitter" %% "scrooge-core" % scroogeVersion exclude("com.twitter", "libthrift"),
    // Either Thrift or ThriftMux server implementation is needed in practice
    "com.twitter" %% "finagle-thrift" % finagleVersion exclude("com.twitter", "libthrift"),
    "com.twitter" %% "finagle-thriftmux" % finagleVersion exclude("com.twitter", "libthrift")
//    "com.twitter" %% "finagle-http" % finagleVersion exclude("com.twitter", "libthrift"),
  )
)

lazy val api = (project in file("api"))
  .settings(commonSettings: _*)
  .settings(
    scroogeThriftSourceFolder in (Compile, run) := {
      val base = baseDirectory.value
      println(s"Base: $base")
      base / "src/main/thrift"
    }
  )

// Run as:
//   sbt server/run
// or (to re-run it on every save):
//   sbt '~server/run'
lazy val server = (project in file("server"))
  .settings(commonSettings: _*)
  .settings(
  )
  .dependsOn(api)
  .enablePlugins(JavaAppPackaging)

// Run as:
//   sbt client/run
// or (to re-run it on every save):
//   sbt '~client/run'
lazy val client = (project in file("client"))
  .settings(commonSettings: _*)
  .settings(
  )
  .dependsOn(api)
  .enablePlugins(JavaAppPackaging)
