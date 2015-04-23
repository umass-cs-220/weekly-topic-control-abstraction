package cs220.control

object Control04 {

  var assertionsEnabled = true

  def myAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  def tryit() {
    myAssert(5 > 3)
  }

  def tryit2() {
    myAssert {
      5 > 3
    }
  }
}