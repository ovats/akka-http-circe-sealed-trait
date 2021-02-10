name := "akka-http-circe-sealed-trait"

version := "0.1"

scalaVersion := "2.13.2"

val akkaVersion          = "2.6.9"
val akkaHttpVersion      = "10.2.0"
val akkaHttpCirceVersion = "1.31.0"
val circeVersion         = "0.13.0"

//lazy val scalaTestVer = "3.1.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed"   % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-http"          % akkaHttpVersion,
  "de.heikoseeberger" %% "akka-http-circe"    % akkaHttpCirceVersion,
  "io.circe"          %% "circe-core"         % circeVersion,
  "io.circe"          %% "circe-generic"      % circeVersion,
  "io.circe"          %% "circe-parser"       % circeVersion,
  "io.circe"          %% "circe-refined"      % circeVersion,
)
