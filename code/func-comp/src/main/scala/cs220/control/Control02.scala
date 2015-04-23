package cs220.control

import java.io.File
import java.io.PrintWriter
import java.util.Date

object Control02 {

  type Operation = PrintWriter => Unit

  // Let us define a function of two parameters
  // that uses currying to produce a function that
  // will be evaluated as a sequence of functions
  // of one parameter each.
  def withPrintWriter(file: File)(op: Operation) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  // Now, we can make this look a little more like a real
  // constrol abstraction:
  def tryit() {
    val file = new File("date.txt")
    withPrintWriter(file) {
      writer => writer.println(new Date)
    }
  }

}