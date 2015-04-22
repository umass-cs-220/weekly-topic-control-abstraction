package cs220.filtering.example01

import cs220.example01._

object EMailFilters {
  // EMailFilter is an type alias for the function type taking an
  // EMail as its argument and returning a Boolean. It can be used as
  // a predicate function to filter a list of emails.
  type EMailFilter = EMail => Boolean

  /** This function is used to return a sequence of emails that is
    * filtered by the EMailFilter f.
    */
  def newMailsForUser(mails: Seq[EMail], f: EMailFilter) = mails.filter(f)

  /* Now we can implement factory functions that generate new email
   * filter functions that can be used by the function above.
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
  def notSentByAnyOf(senders: Set[String]): EMailFilter =
    email => !senders.contains(email.sender)

  /** The `minimumSize` factory function creates a new email filter that
    * can be used to filter an email based on the minimum size of the
    * email's text.
    *
    *  NOTE: this function returns a function!
    */
  def minimumSize(n: Int): EMailFilter =
    email => email.text.size >= n

  /** The `maximumSize` factory function creates a new email filter
    * that can be used to filter an email based on the maximum size of
    * the email's text.
    *
    *  NOTE: this function returns a function!
    */
  def maximumSize(n: Int): EMailFilter =
    email => email.text.size <= n
}
