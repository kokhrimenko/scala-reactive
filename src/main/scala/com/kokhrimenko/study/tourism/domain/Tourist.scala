package com.kokhrimenko.study.tourism.domain

import akka.actor.{Actor, ActorRef}
import com.kokhrimenko.study.tourism.domain.Guidebook.Inquiry

object Tourist {

  case class Guidance(code:String, description: String)

  case class Start(code: Seq[String])
}

class Tourist (guidebook: ActorRef) extends Actor {
  import Tourist.{Guidance, Start}

  override def receive = {
    case Start(codes) => {
      codes.foreach(guidebook ! Inquiry(_))
    }
    case Guidance(code, description) => {
      println(s"$code: $description")
    }
  }
}
