object CapsStartList {
  def main(args: Array[String]) = {
    // The type of capsList will be List[String]. In general, it will be the
    // same as the input collection, unless the element type is changed!
    val capsList = for {
      arg <- args.toList  // convert the array to a List[String]
      if (arg(0).isUpperCase)
    }
      yield arg
    println("list: "+capsList)
  }
}
// $ scalac caps-start-list.scala
// $ scala -cp . CapsStartList aB Ab AB ab
// list: RangeMFM(Ab, AB)