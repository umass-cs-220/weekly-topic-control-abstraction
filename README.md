# Control Abstraction

## Overview

Scala has a minimal set of built-in control abstractions (`if`, `while`, `for`, `try`, `match`, and function calls). Rather than introduce a new control abstraction for special circumstances it leverages function literals and higher-order functions to introduce new control abstractions that *feel* like built-in constructs. In this topic we explore what *currying* is and how it can be used along with higher-order functions (those functions that take and return other functions as parameters and results) to reduce code duplication and introduce new control abstractions.

## Readings

* Chapter 9, Odersky
* [Staying DRY With Higher-Order Functions][neophytes-10], Daniel Westheide
* [Currying and Partially Applied Functions][neophytes-11], Daniel Westheide

[neophytes-10]: http://danielwestheide.com/blog/2013/01/23/the-neophytes-guide-to-scala-part-10-staying-dry-with-higher-order-functions.html
[neophytes-11]: http://danielwestheide.com/blog/2013/01/30/the-neophytes-guide-to-scala-part-11-currying-and-partially-applied-functions.html

## Resources

* [DRY: Don't Repeate Yourself][wikipedia-dry], Wikipedia
* [Currying][wikipedia-curry], Wikipedia
* [By-Name Parameter to Function][daily-scala-2009-12], Daily Scala
* [Defining Custom Control Structures][daily-scala-2009-11], Daily Scala

[wikipedia-dry]: http://en.wikipedia.org/wiki/Don%27t_repeat_yourself
[wikipedia-curry]: http://en.wikipedia.org/wiki/Currying
[daily-scala-2009-11]: http://daily-scala.blogspot.com/2009/11/defining-custom-control-structures.html
[daily-scala-2009-12]: http://daily-scala.blogspot.com/2009/12/by-name-parameter-to-function.html
