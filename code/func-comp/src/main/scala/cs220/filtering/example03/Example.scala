package cs220.filtering.example03

import cs220.filtering.example03._
import cs220.filtering.example03.EMailFilters._

object Example extends App {
  // Create a customized email filter that will filter email by a list
  // of emails not sent by the senders:
  val emailFilter: EMailFilter = notSentByAnyOf(Set("instructor@umass.edu"))

  // Create a sequence of emails. This one is simple - it will consist
  // of only a single email.
  val mails = EMail(
    subject   = "Semester Grades",
    text      = "Your grades will be out shortly.",
    sender    = "instructor@umass.edu",
    recipient = "student@umass.edu"
  ) :: Nil

  // Filter emails with the created filter:
  val result = newMailsForUser(mails, emailFilter)

  println("before filtering:")
  println(mails)
  println("after filtering:")
  println(result)
}
