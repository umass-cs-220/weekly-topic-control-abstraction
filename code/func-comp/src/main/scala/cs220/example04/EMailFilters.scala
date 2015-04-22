package cs220.example04

import cs220.example04._

object EMailFilters {
  type EMailFilter = EMail => Boolean

  def newMailsForUser(mails: Seq[EMail], f: EMailFilter) = mails.filter(f)

  type SizeChecker = Int => Boolean

  def sizeConstraint(c: SizeChecker): EMailFilter =
    email => c(email.text.size)

  def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)

  ///////////// EXTENSION ////////////////////////////////////////////
  def any[A](predicates: (A => Boolean)*): A => Boolean =
    a => predicates.exists(pred => pred(a))

  def none[A](predicates: (A => Boolean)*) =
    complement(any(predicates: _*))

  def every[A](predicates: (A => Boolean)*) =
    none(predicates.map(complement(_)): _*)
  ///////////// EXTENSION ////////////////////////////////////////////  

  val minimumSize: Int => EMailFilter = n => sizeConstraint(_ >= n)
  val maximumSize: Int => EMailFilter = n => sizeConstraint(_ <= n)
  val equalSize: Int => EMailFilter = n => sizeConstraint(_ == n)
  val sentByOneOf: Set[String] => EMailFilter =
    senders => email => senders.contains(email.sender)
  val notSentByAnyOf: Set[String] => EMailFilter =
    sentByOneOf andThen (complement(_))
  
}
