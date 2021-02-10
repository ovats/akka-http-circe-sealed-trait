# akka-http-circe-sealed-trait

This is just a sample project for the question asked in StackOverflow [here](https://stackoverflow.com/questions/66107348/endpoint-receiving-a-list-of-objects-from-a-hierarchy).

Given this hierarchy (Message.scala file):

```scala
sealed trait Message
case class SMS(numFrom: String, message: String)     extends Message
case class Email(emailFrom: String, message: String) extends Message
```

How can an endpoint accept in the payload a list of Messages and deserialized with the correct case class?

```scala
entity(as[List[Message]]) { data =>
  println(s"POST /test, body $data")
  complete(StatusCodes.OK)
}
```

Solution:

```scala
implicit val messageDecoder: Decoder[Message] = List[Decoder[Message]](Decoder[SMS].widen, Decoder[Email].widen).reduceLeft(_ or _)
```
