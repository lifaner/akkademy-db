name := """akkademy-db"""
version := "0.0.1-SNAPSHOT"
organization := "com.akkademy-db"
scalaVersion := "2.11.1"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "com.typesafe.akka" %% "akka-remote" % "2.3.6")

/**
  * 需要在发布的内容中排出applicatoin.conf
  * 防止客户端也能试图启动远程服务器
  * （更好的做法是把消息放在一个单独的库中）
  */
mappings in (Compile,packageBin) ~= {
  _.filterNot{
    case (_, name) => Seq("application.conf").contains(name)
  }
}

fork in run := true