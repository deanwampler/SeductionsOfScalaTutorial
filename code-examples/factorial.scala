// Recursion using factorials.

// There are left and right recursions. 
// Which is a tail call? Which works better with infinite sequences?

// This is a right-recursion implementation of factorial.
// Note that we aren't checking for negative arguments!

//@scala.annotation.tailrec  // NOT tail recursive!
def factr(i: Int): Long = 
  if (i == 1) 1L 
  else i*factr(i-1)

// This is a left-recursion implementation.

def factl(i: Int): Long = {
  @scala.annotation.tailrec
  def f(accumulator: Long, i: Int): Long = 
    if (i == 1) accumulator
    else f(i*accumulator, i-1)
  f(1, i)
}

for(n <- 1 to 10) {
  printf("%2d: %d =? %d\n", n, factl(n), factr(n))
}

factl(25)
factr(25)

// Neither of the following returns the correct value
// because of Long overflow, but what happens with each one??
factl(10000)
factr(10000)
