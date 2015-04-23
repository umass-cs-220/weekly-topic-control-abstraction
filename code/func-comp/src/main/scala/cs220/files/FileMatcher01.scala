package cs220.files

import java.io.File

object FileMatcher01 {
  private def filesHere = (new File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file

  // (1) Where is the code duplication in the above functions?
  //     - Why can't we simply replace that code?
  //     - What is an alternative?

  // (2) Spend 5-10 minutes implementing a `filesMatching` function
  //     that takes a query and a function as an argument to eliminate
  //     the code duplication.
}