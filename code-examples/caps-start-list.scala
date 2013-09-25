object CapsStartList {
  def main(args: Array[String]) = {
    // The type of capsList will be List[String]. In general, it will be the
    // same as the input collection, unless the element type is changed!
    val capsList = for {
      arg <- args.toList  // convert the array to a List[String]
      if (arg(0).isUpper)
    } yield arg
    println("list: "+capsList)
  }
}
// $ scalac caps-start-list.scala
// $ scala -cp $PWD CapsStartList aB Ab AB ab
// list: List(Ab, AB)
//
// NOTE: You may not need the "-cp $PWD" argument.
// You can also try "-cp .", but while this should work,
// for some reason it doesn't always! 
