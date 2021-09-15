name:="abhishek"
version := "0.1"

scalaVersion := "2.13.4"

lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test
lazy val mockitoScala = "org.mockito" %% "mockito-scala" % "1.16.15" % Test

lazy val UT = project.in(file("Question1-2"))
  .settings(
    libraryDependencies += scalaTest
  )

lazy val UT_IT = project.in(file("Question3"))
  .settings(
    libraryDependencies ++= Seq(
      scalaTest,
      mockitoScala
    )
  )

lazy val root = project.in(file(".")).aggregate(UT,UT_IT)