object CapsStartFor {
  def main(args: Array[String]) = {
    for {
      arg <- args
      if (arg(0).isUpper)
    } println("arg: " + arg)
  }
}
// $ scalac caps-start-for.scala
// $ scala -cp $PWD CapsStartFor aB Ab AB ab
// arg: Ab
// arg: AB
//
// NOTE: You may not need the "-cp $PWD" argument.
// You can also try "-cp .", but while this should work,
// for some reason it doesn't always! 
