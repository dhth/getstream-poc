val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "getstream-server-scala",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "io.getstream.client" % "stream-java" % "3.9.1",
    libraryDependencies += "io.getstream.client" % "stream-repo-apache" % "2.1.3",
    libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.3.1"
  )
