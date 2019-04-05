name := "study"

version := "0.1"

scalaVersion := "2.12.8"

val akkaVersion = "2.5.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)