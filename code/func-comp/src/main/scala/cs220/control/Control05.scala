package cs220.control

object Control05 {

  def unless(predicate: Boolean)(block: => Unit): Unit = {
    if (!predicate) {
      block
    }
  }

  def tryit(x: Int) {
    unless(x == 5) {
      println("I AM AWESOME!")
    }
  }
}