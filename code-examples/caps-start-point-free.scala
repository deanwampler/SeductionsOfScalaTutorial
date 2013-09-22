object CapsStartPointFree {
  def main(args: Array[String]) = {
  	// The next two lines do the same thing. Try each one!
    args filter (_(0).isUpperCase) foreach ((arg) => println("arg: "+arg))
    // args filter (_(0).isUpperCase) map ("arg: "+_) foreach println
  }
}
// $ scalac caps-start-point-free.scala
// $ scala -cp . CapsStartPointFree aB Ab AB ab
// arg: Ab
// arg: AB
