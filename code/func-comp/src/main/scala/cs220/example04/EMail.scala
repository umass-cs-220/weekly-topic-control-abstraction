package cs220.example04

/** An case class to represent emails.
  */
case class EMail(
  subject: String,
  text: String,
  sender: String,
  recipient: String
)
