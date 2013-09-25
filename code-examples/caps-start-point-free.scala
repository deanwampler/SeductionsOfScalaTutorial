object CapsStartPointFree {
  def main(args: Array[String]) = {
  	// The next two lines do the same thing. Try each one!
    args filter (_(0).isUpper) foreach ((arg) => println("arg: "+arg))
    // args filter (_(0).isUpper) map ("arg: "+_) foreach println
  }
}
// $ scalac caps-start-point-free.scala
// $ scala -cp $PWD CapsStartPointFree aB Ab AB ab
// arg: Ab
// arg: AB
//
// NOTE: You may not need the "-cp $PWD" argument.
// You can also try "-cp .", but while this should work,
// for some reason it doesn't always! 
