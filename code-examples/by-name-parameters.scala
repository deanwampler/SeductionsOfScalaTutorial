// By-name function parameters are lazily evaluated
// Consider the following infinite recursion:

def infinite: Boolean = infinite

// Note the difference between a value and a function/method definition.
// WARNING: YOU'LL HAVE TO ^C TO KILL THE SECOND LINE!

def inf1 = infinite

val inf2 = infinite


// Now, let's implement a loop construct:

def loop(condition: => Boolean)(block: => Unit): Unit = 
  if (condition) {
    block
    loop(condition)(block)
  }

// Let's use it: The following should return immediately and do nothing:

loop (false)(infinite)

// This will never return; you'll either blow the stack or use ^C ;^)

loop (true)(infinite)

// (If you're here after restarting the REPL, you'll need to redefine loop from above...)

// Here's a more realistic, if contrived, example:

var count = 0
loop (count < 10) {
  println("count: "+count)
  count += 1
}

// Note that have a useful tool for building custom "internal" DSLs (domain-specific
// languages). Features like by-name parameters, multiple function argument lists, etc.
// make it straightforward to define our own control constructs, etc.
// For completeness, here's how you would have to define this as a reusable "module":

// In some Loop.scala file:
object Loop {
  def loop(condition: => Boolean)(block: => Unit): Unit = 
    if (condition) {
      block
      loop(condition)(block)
    }
}

// In a client file:
import Loop._

var count = 0
loop (count < 10) {
  println("count: "+count)
  count += 1
}

