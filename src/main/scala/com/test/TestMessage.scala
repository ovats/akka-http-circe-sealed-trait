package com.test

import io.circe.parser.decode

object TestMessage extends App {

  val payloadSMS =
    """
      | [
      |   { 
      |     "numFrom": "1-555-1234",
      |     "message": "this is a SMS" 
      |   }
      | ]
      |""".stripMargin

  val payloadEmail =
    """
      | [
      |    {
      |       "emailFrom" : "some@mail.com",
      |       "message" : "email message body"
      |    }
      | ]
      |""".stripMargin

  val resultEmail = decode[List[Message]](payloadEmail)
  println(s"resultEmail $resultEmail")
  val resultSMS = decode[List[Message]](payloadSMS)
  println(s"resultSMS $resultSMS")
}
