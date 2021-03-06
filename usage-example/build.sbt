organization := "hr.element.spt"

name := "usage-example"

version := "0.0.0-SNAPSHOT"

scalaVersion := "2.11.0-RC1"

javacOptions := Seq(
  "-encoding", "UTF-8"
, "-deprecation"
, "-Xlint"
, "-source", "1.6"
, "-target", "1.6"
)

javacOptions in doc := Seq(
  "-source", "1.6"
)

crossPaths := false

autoScalaLibrary := false

unmanagedSourceDirectories in Compile := (javaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

EclipseKeys.eclipseOutput := Some(".target")

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

libraryDependencies += organization.value % "legal-drinking-age-implementation_2.11.0-RC1" % "0.0.0-SNAPSHOT"
