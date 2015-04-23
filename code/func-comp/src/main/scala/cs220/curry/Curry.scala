package cs220.curry

object Curry extends App {

  // Here is a definition of a function that sums to Ints:
  def plainOldSum(x: Int, y: Int) = x + y

  // Here is a similar function that is "curried":
  def curriedSum(x: Int)(y: Int) = x + y

  // What is happening with this new definition of sum? It
  // turns out that you get a function that accepts the
  // first argument which returns another function that
  // accepts the second argument which returns an Int:
  //
  // (x: Int)(Int) => Int
  //
  // You can invoke it like this:
  //
  // scala> curriedSum(4)(5)
  //
  // Or, you can invoke it with a single argument:
  //
  // scala> val second = curriedSum(4)
  // scala> second(5)

  // Here is another way of defining the same function:
  def first1(x: Int) = (y: Int) => x + y

  // And, yet another way:
  val first2: Int => Int => Int = x => y => x + y

  //
}