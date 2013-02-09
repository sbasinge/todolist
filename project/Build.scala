import sbt._
import Keys._
//import play.Project._
import PlayProject._

object ApplicationBuild extends Build {

  val appName         = "todolist"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
//    jdbc,
//    anorm,
    "org.squeryl" %% "squeryl" % "0.9.5-2",
    "postgresql" % "postgresql" % "8.4-702.jdbc4"
  )


//  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
//  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
  )

}
