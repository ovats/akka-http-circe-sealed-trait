name := "akka-http-circe-sealed-trait"

version := "0.1"

scalaVersion := "2.13.2"

// object Versions
val akkaVer          = "2.6.9"
val akkaHttpVer      = "10.2.0"
val akkaHttpCirceVer = "1.31.0"

val circeVer = "0.13.0"

val betterMonadicForVer = "0.3.1"
val kindProjectorVer    = "0.11.0"
val contextAppliedVer   = "0.1.2"

lazy val scalaTestVer = "3.1.0"

val logbackVer         = "1.2.3"
val logstashVersionVer = "5.3"
val scalaLoggingVer    = "3.9.2"

val pureconfigVersion = "0.14.0"

// object Libraries
// Akka Framework
val akkaActor     = "com.typesafe.akka" %% "akka-actor-typed"         % akkaVer
val akkaTest      = "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVer     % Test
val akkaCluster   = "com.typesafe.akka" %% "akka-cluster-typed"       % akkaVer
val akkaHttp      = "com.typesafe.akka" %% "akka-http"                % akkaHttpVer
val akkHttpTest   = "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVer % Test
val akkaLogs      = "com.typesafe.akka" %% "akka-slf4j"               % akkaVer
val akkaHttpCirce = "de.heikoseeberger" %% "akka-http-circe"          % akkaHttpCirceVer

// Circe
val circeCore    = "io.circe" %% "circe-core"    % circeVer
val circeGeneric = "io.circe" %% "circe-generic" % circeVer
val circeParser  = "io.circe" %% "circe-parser"  % circeVer
val circeRefined = "io.circe" %% "circe-refined" % circeVer

// Logs
val logback      = "ch.qos.logback"              % "logback-classic"          % logbackVer % Runtime
val logstash     = "net.logstash.logback"        % "logstash-logback-encoder" % logstashVersionVer
val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"            % scalaLoggingVer

// Test
val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVer % "test"

val pureConfig = "com.github.pureconfig" %% "pureconfig" % pureconfigVersion

val akkaDeps = Seq(
  akkaActor,
  akkaTest,
  akkaCluster,
  akkaHttp,
  akkHttpTest,
  akkaHttpCirce,
  akkaLogs,
)

val circeDeps = Seq(
  circeCore,
  circeGeneric,
  circeParser,
  circeRefined,
)

// Test
val basicDeps = Seq(
  pureConfig,
  logback,
  logstash,
  scalaLogging,
  scalaTest,
)

libraryDependencies ++=
  basicDeps ++
    akkaDeps ++
    circeDeps
