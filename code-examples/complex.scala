// Compile this with scalac.

package math2   // Avoid colliding with Scala's math package

class Complex(val real: Double, val imaginary: Double) {
  def +(that: Complex) = 
    new Complex(real + that.real, imaginary + that.imaginary)
  def -(that: Complex) = 
    new Complex(real - that.real, imaginary - that.imaginary)
  def unary_- = 
    new Complex(-real, imaginary)
  override def toString() = "("+real+", "+imaginary+")"
}

