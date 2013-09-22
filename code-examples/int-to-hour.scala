// Implicit conversions to implement Haskell-style type classes.

import java.util.{ Calendar, GregorianCalendar }

implicit class Hour (val howMany:Int){
  def hour(when: Int) = when + howMany
  def hour(gc: GregorianCalendar) = gc.get(Calendar.HOUR_OF_DAY) + howMany
}

// object Hour {
//  def fromNow = now

//  import java.util.{ Calendar, GregorianCalendar }
//  def now = new GregorianCalendar().get(Calendar.HOUR_OF_DAY) 
// }
object FromNow {
 implicit val fromNow = new GregorianCalendar()
}

import FromNow._

println(1 hour fromNow)

// Note that we've defined a mini-DSL for working with time.

// EXERCISE: Make the following work. There are two approaches you might take.

println(1 minute fromNow)

