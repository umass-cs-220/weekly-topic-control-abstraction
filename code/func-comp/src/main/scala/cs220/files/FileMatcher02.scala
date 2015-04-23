package cs220.files

import java.io.File

object FileMatcher02 {
  private def filesHere = (new File(".")).listFiles

  type Matcher = (String, String) => Boolean

  def filesMatching(query: String, matcher: Matcher) =
    for (file <- filesHere; if matcher(file.getName, query))
      yield file

  def filesEnding(query: String) =
    filesMatching(query, _.endsWith(_))

  def filesContaining(query: String) =
    filesMatching(query, _.contains(_))

  def filesRegex(query: String) =
    filesMatching(query, _.matches(_))
}