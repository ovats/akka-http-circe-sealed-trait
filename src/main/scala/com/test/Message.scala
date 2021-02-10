package com.test

import cats.syntax.functor._
import io.circe.Decoder
import io.circe.generic.auto._

sealed trait Message

object Message {

  case class SMS(numFrom: String, message: String)     extends Message
  case class Email(emailFrom: String, message: String) extends Message

  implicit val messageDecoder: Decoder[Message] =
    Seq[Decoder[Message]](Decoder[SMS].widen, Decoder[Email].widen).reduceLeft(_ or _)

}
