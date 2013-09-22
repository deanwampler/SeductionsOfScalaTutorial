// "MiniMap" demonstrates details of case classes and how Scala implements
// the literal syntax for its Maps: Map("one" -> 1, "two" -> 2)

class MiniMap1[K,V](val pairs: Tuple2[K,V]*) {
  override def toString = pairs.mkString("MiniMap1(", ", ", ")")
}

val mm1a = new MiniMap1(("one", 1), ("two", 2))
println(mm1a)

// Let's define our own map initialization syntax:
// (Note, why can we get away with NOT declaring "key" as a val??)
implicit class MiniMap1Element[K](key: K) {
  def :->[V] (value: V) = (key,value)  // Is the return type clear?
}

val mm1b = new MiniMap1("one" :-> 1, "two" :-> 2)
println(mm1b)

// But Scala doesn't require us to use "new":
//   val m = Map("one" -> 1, "two" -> 2)
// It uses an object for this:

object MiniMap1 {
  def apply[K,V](pairs: Tuple2[K,V]*) = new MiniMap1(pairs: _*)
}

val mm1c = MiniMap1("one" :-> 1, "two" :-> 2)
println(mm1c)

// This pattern of having a "companion object" with a factory method is so 
// common and convenient, there is a short-hand form:

case class MiniMap[K,V](pairs: Tuple2[K,V]*)

val mm = MiniMap("one" :-> 1, "two" :-> 2)
println(mm)
