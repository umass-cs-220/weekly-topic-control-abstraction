package cs220.client

object Client02 {

  // A better way to do this. The `exists` method on the
  // List object provides a more concise way of solving
  // the same problem by using a "control abstraction"
  // which reduces code duplication in the client API
  // using the List object.
  def containsNeg(nums: List[Int]) = nums.exists(_ < 0)

  // If we need to define another method looking for
  // odd values we "could" do it like this:
  def containsOddYuck(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num % 2 == 1)
        exists = true
    exists
  }

  // BUT, why do this when we can achieve the same
  // solution by using a cleaner and more intuitive
  // control abstraction:
  def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

  // There is a wealth of other control/looping abstractions
  // in the Scala library (and other functional languages)
  // that can lead to more concise (shorter) code that is
  // easier to read and understand.

  // In addition, using these control abstractions can reduce
  // programming errors resulting from simple loop mistakes.

  // BUT, these control abstractions do not feel like "native"
  // control structures. So, how can we do this? To understand
  // better we must first look at currying.

}