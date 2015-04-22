package cs220.filtering.example00

import cs220.example00._
import cs220.example00.EMailFilters._

object Example extends App {
  // Create a sequence of emails. This one is simple - it will consist
  // of only a single email.
  val mails = EMail(
    subject   = "Semester Grades",
    text      = "Your grades will be out shortly.",
    sender    = "instructor@umass.edu",
    recipient = "student@umass.edu"
  ) :: Nil

  // Filter emails with the created filter:
  val result = filterNotSentByAnyOf(mails, Set("instructor@umass.edu"))

  println("before filtering:")
  println(mails)
  println("after filtering:")
  println(result)
}
