organization := "hr.element.spt"

name := "legal-drinking-age-implementation"

version := "0.0.0-SNAPSHOT"

crossScalaVersions := Seq("2.10.4-RC3", "2.11.0-RC1")

scalaVersion := crossScalaVersions.value.last

scalacOptions := Seq(
  "-encoding", "UTF-8"
, "-deprecation"
, "-optimise"
, "-unchecked"
, "-Xcheckinit"
, "-Xlint"
, "-Xno-forwarders"
, "-Xmax-classfile-name", "72"
, "-Xverify"
, "-Yclosure-elim"
, "-Ydead-code"
, "-Yinline"
, "-Yrepl-sync"
, "-Ywarn-adapted-args"
, "-Ywarn-dead-code"
, "-Ywarn-inaccessible"
, "-Ywarn-nullary-override"
, "-Ywarn-nullary-unit"
, "-Ywarn-numeric-widen"
, "-Ywarn-value-discard"
, "-feature"
, "-language:postfixOps"
, "-language:implicitConversions"
, "-language:existentials"
)

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

compileOrder := CompileOrder.Mixed

unmanagedSourceDirectories in Test := Nil

EclipseKeys.eclipseOutput := Some(".target")

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)

libraryDependencies += organization.value % "age-verificator-interface" % "0.0.0-SNAPSHOT"
