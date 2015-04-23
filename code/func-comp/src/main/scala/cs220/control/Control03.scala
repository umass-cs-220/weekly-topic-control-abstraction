package cs220.control

object Control03 {

  var assertionsEnabled = true

  def myAssert(predicate: () => Boolean) =
    if (assertionsEnabled && !predicate())
      throw new AssertionError

  def tryit() {
    myAssert(() => 5 > 3)
  }
}