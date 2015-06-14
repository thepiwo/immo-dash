name := """hackday"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.

routesGenerator := InjectedRoutesGenerator

libraryDependencies += evolutions

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += "me.figo" % "sdk" % "1.2.1"
