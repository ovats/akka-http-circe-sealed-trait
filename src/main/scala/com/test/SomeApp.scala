package com.test

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport

import scala.util.{Failure, Success}

object SomeApp extends App with FailFastCirceSupport {

  implicit val system: ActorSystem = ActorSystem("some-app")
  import system.dispatcher

  val routes = pathPrefix("test") {
    post {
      entity(as[List[Message]]) { data =>
        println(s"POST /test, body $data")
        complete(StatusCodes.OK)
      }
    } ~
      get {
        complete("alive and kicking!")
      }
  }

  Http()
    .newServerAt("localhost", 8081)
    .bind(routes)
    .onComplete {
      case Success(_)         => println("app started")
      case Failure(exception) => println("app failed to start", exception)
    }

}
