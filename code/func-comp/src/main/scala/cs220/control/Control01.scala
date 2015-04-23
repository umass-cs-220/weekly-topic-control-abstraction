package cs220.control

import java.io.File
import java.io.PrintWriter
import java.util.Date

object Control01 {

  type Operation = PrintWriter => Unit

  def withPrintWriter(file: File, op: Operation) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def tryit() {
    withPrintWriter(
      new File("date.txt"),
      writer => writer.println(new Date)
    )
  }

}