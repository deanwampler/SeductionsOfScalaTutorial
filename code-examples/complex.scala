// Compile this with scalac.

package math2   // Avoid colliding with Scala's math package

case class Complex(real: Double, imaginary: Double) {
  def +(that: Complex) = 
    new Complex(real + that.real, imaginary + that.imaginary)
  def -(that: Complex) = 
    new Complex(real - that.real, imaginary - that.imaginary)
  def unary_- = 
    new Complex(-real, imaginary)
  override def toString() = "("+real+", "+imaginary+")"
}

