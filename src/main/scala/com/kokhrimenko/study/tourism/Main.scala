package com.kokhrimenko.study.tourism

import java.util.Locale

import akka.actor.{ActorRef, ActorSystem, Props}
import com.kokhrimenko.study.tourism.domain.Tourist.Start
import com.kokhrimenko.study.tourism.domain.{Guidebook, Tourist}

object Main extends App {

  val  system: ActorSystem = ActorSystem("Guide_System")

  val guideProps: Props = Props[Guidebook]
  val guidebook:ActorRef = system.actorOf(guideProps, "guidebook")

  val tourProps: Props = Props(classOf[Tourist], guidebook)

  val tourist: ActorRef = system.actorOf(tourProps)

  tourist ! Start(Locale.getISOCountries)
}
