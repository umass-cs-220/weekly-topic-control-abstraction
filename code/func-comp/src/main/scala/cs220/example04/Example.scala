package cs220.example04

import cs220.example04._
import cs220.example04.EMailFilters._

object Example extends App {
  ///////////// EXTENSION ////////////////////////////////////////////
  // Create a customized email filter that composes many
  // email filters into one:
  val emailFilter: EMailFilter = every(
    sentByOneOf(Set("instructor@umass.edu")),
    minimumSize(10),
    maximumSize(10000)
  )
  ///////////// EXTENSION ////////////////////////////////////////////  

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
