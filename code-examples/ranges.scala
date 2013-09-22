// Ranges

// What do these lines do?

val r1 = 1 to 10
val r2 = 1 until 10
val r3 = 1 until 10 by 3
val r4 = 1.0 until 2.0 by 0.1

r1.foreach(println)
r2 foreach println    // Drop the . and ()
r3 foreach println    
r4 foreach println

// Side note: Why is dropping the . and () useful?
// 1. Reduces clutter
// 2. Very useful for operator-like methods:

class Complex(val real: Double, val imag: Double) {
  def + (other: Complex) = new Complex(real + other.real, imag + other.imag)

  override def toString = s"Complex($real, $imag)"
}

val c1 = new Complex(1.2, 2.1)
val c2 = new Complex(3.0, 4.5)

c1 + c2

// Okay, so we know how to declare object-oriented classes; we'll return to this later.
