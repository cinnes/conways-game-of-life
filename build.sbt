name := "conways-game-of-life"

version := "0.1"

scalaVersion := "2.12.8"

val ScalaTestVersion = "3.0.5"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % ScalaTestVersion,
  "org.scalatest" %% "scalatest" % ScalaTestVersion % "test"
)