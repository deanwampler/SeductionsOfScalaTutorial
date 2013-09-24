object CapsStart {
  def main(args: Array[String]) = {
    args.filter((arg) => arg(0).isUpperCase)
    .foreach((arg) => println("arg: "+arg))
  }
}
// $ scalac caps-start.scala
// $ scala -cp $PWD CapsStart aB Ab AB ab
// arg: Ab
// arg: AB
