package cs220.example01

/** An case class to represent emails.
  */
case class EMail(
  subject: String,
  text: String,
  sender: String,
  recipient: String
)
