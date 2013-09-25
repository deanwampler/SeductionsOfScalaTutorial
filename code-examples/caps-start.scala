object CapsStart {
  def main(args: Array[String]) = {
    args.filter((arg) => arg(0).isUpper)
    .foreach((arg) => println("arg: "+arg))
  }
}
// $ scalac caps-start.scala
// $ scala -cp $PWD CapsStart aB Ab AB ab
// arg: Ab
// arg: AB
//
// NOTE: You may not need the "-cp $PWD" argument.
// You can also try "-cp .", but while this should work,
// for some reason it doesn't always! 
