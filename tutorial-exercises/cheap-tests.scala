object CheapTests {
  implicit class CheapTestsForDoubles(actual: Double) {

    val TOLERANCE = 0.00001

    def is(expected: Double, within: Double = TOLERANCE):Unit = 
      if (math.abs(expected - actual) > TOLERANCE) {
        Console.err.println("ERROR! Expected %f vs. actual %f is not within tolerance %f".format(expected, actual, within))
        sys.exit(1)
      }

    def isnot(expected: Double, within: Double = TOLERANCE):Unit = 
      if (math.abs(expected - actual) <= TOLERANCE) {
        Console.err.println("ERROR! The difference of the expected %f vs. the actual %f is smaller than tolerance %f. Expected it to be larger than the tolerance!".format(expected, actual, within))
        sys.exit(1)
      }
  }

  implicit class CheapTestsForEverythingElse[T](actual: T) {

    def is[T](expected: T):Unit = 
      if (expected != actual) {
        Console.err.println("ERROR! Expected \"%s\", but got \"%s\"".format(expected, actual))
        sys.exit(1)
      }

    def isnot[T](expected: T):Unit = 
      if (expected == actual) {
        Console.err.println("ERROR! Expected \"%s\" to not equal \"%s\"".format(expected, actual))
        sys.exit(1)
      }
  }
}