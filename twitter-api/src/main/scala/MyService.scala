package restapi

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import scala.compat.Platform.currentTime

class TwitterServiceActor extends Actor with TwitterService {

	def actorRefFactory = context

	def receive = runRoute(myRoute)
}

trait TwitterService extends HttpService {

	val myRoute =
		path("ping") {
			get {
				complete {
					<h1>Pong</h1>
				}
			}
		}
}
