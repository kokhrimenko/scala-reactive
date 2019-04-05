package com.kokhrimenko.study.tourism.domain

import Tourist.Guidance

import java.util.{Currency, Locale}

import akka.actor.Actor

object Guidebook {

  case class Inquiry(code:String)

}

class Guidebook extends Actor {
  import Guidebook.Inquiry

  def describe(locale: Locale) =
    s"""In ${locale.getDisplayCountry},
      ${locale.getDisplayLanguage} is spoken and the currency
      is the ${Currency.getInstance(locale).getDisplayName}"""

  override def receive: Receive = {
    case Inquiry(code) =>
      println(s"Actor ${self.path.name} responding to inquiry about $code")
      Locale.getAvailableLocales.filter(_.getCountry == code)
      .foreach{ locace =>
        sender ! Guidance(code, describe(locace))

      }
  }

}
