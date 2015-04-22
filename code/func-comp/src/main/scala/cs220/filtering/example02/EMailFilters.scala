package cs220.filtering.example02

import cs220.example02._

object EMailFilters {
  // EMailFilter is an type alias for the function type taking an
  // EMail as its argument and returning a Boolean. It can be used as
  // a predicate function to filter a list of emails.
  type EMailFilter = EMail => Boolean

  /** This function is used to return a sequence of emails that is
    * filtered by the EMailFilter f.
    */
  def newMailsForUser(mails: Seq[EMail], f: EMailFilter) = mails.filter(f)

  ///////////// EXTENSION ////////////////////////////////////////////

  // SizeChecker is a type alias for functions that checks the size of
  // an email's body.
  type SizeChecker = Int => Boolean

  /** This function is used to create EMailFilters that perform a
    * constraint check on the size of the body of an email. We will
    * use this function to help define the minimumSize and maximumSize
    * EMail filters.
    */
  def sizeConstraint(c: SizeChecker): EMailFilter =
    email => c(email.text.size)

  /** The `minimumSize` factory function creates a new email filter that
    * can be used to filter an email based on the minimum size of the
    * email's text.
    *
    *  NOTE: this function returns a function!
    */
  def minimumSize(n: Int): EMailFilter = sizeConstraint(_ >= n)

  /** The `maximumSize` factory function creates a new email filter
    * that can be used to filter an email based on the maximum size of
    * the email's text.
    *
    *  NOTE: this function returns a function!
    */
  def maximumSize(n: Int): EMailFilter = sizeConstraint(_ <= n)

  /** The `equalSize` factory function creates a new email filter that
    *  can be used to filter an email based on its size.
    *
    *  NOTE: this function returns a function!
    */
  def equalSize(n: Int): EMailFilter = sizeConstraint(_ == n)





  ///////////// EXTENSION ////////////////////////////////////////////

  /** The `complement` function takes a predicate function and returns
    * a new function which is the complement of the result of calling
    * the given function.
    */
  def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)

  /*
   The problem is that the original definitions of the sendByOneOf and
   notSentByAnyOf return an EMailFilter not Boolean. To simplify the
   definition we use function composition.
   */

  /** The `sendByOneOf` factory function creates a new email filter that
    * can be used to filter an email based on its inclusion in the
    * given set of sender emails.
    *
    *  NOTE: this function returns a function!
    */
  def sendByOneOf(senders: Set[String]): EMailFilter =
    email => senders.contains(email.sender)

  /** The `notSentByAnyOf` factory function creates a new email filter
    * that can be used to filter an email based on its exclusion in
    * the provided set of sender emails.
    *
    *  NOTE: this function returns a function!
    */
  // YUCK - this looks terrible!
  def notSentByAnyOf(senders: Set[String]): EMailFilter =
    (sendByOneOf _ andThen(g => complement(g)))(senders)
}
