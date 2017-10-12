package com.akkademy.actor

import akka.actor.{Actor, Status}

class ScalaPingActor extends Actor {
    override def receive: Receive = {
        case "Ping" => sender() ! "Pong"
        case "Pong" => sender() ! "Ping"
        case _ => sender() ! Status.Failure(new Exception("ScalaPingActor 匹配失败！"))
    }
}


