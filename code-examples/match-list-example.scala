import math2._  // For Complex case class

val l = Complex(1,2) :: Complex(1.1,2.2) ::
        (1,2,3) :: (3,2,1) :: Nil

def printList[A](l: List[A]): Unit = l match {
  case head :: tail =>   // Same as case ::(head, tail) =>
    print(head+", "); printList(tail)
  case Nil =>  // empty
}
printList(l)

// What does this do? (Compare with List.sliding(...))
def slide[A](l: List[A]): List[(A,A)] = l match {
    case h1 :: h2 :: tail => (h1,h2) :: slide(tail)
    case h :: tail => Nil
    case Nil => Nil
}