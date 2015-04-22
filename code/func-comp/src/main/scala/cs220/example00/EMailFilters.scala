package cs220.example00

import cs220.example01._

object EMailFilters {
  /** The `filterByOneOf` function filters a sequence of emails based
    * on emails in the set of senders.
    */
  def filterByOneOf(mails: Seq[EMail], senders: Set[String]) =
    mails.filter(e => senders.contains(e.sender))

  /** The `filterNotSentByAnyOf` function filters a sequence of emails
    * based on emails not found in the set of senders.
    */
  def filterNotSentByAnyOf(mails: Seq[EMail], senders: Set[String]) =
    mails.filter(e => !senders.contains(e.sender))

  /** The `minimumSize` function is used to filter an email based on the
    * minimum size of the email's text.
    */
  def minimumSize(mails: Seq[EMail], n: Int) =
    mails.filter(e => e.text.size >= n)

  /** The `maximumSize` function is used to filter an email based on the
    * maximum size of the email's text.
    */  
  def maximiumSize(mails: Seq[EMail], n: Int) =
    mails.filter(e => e.text.size <= n)
}
