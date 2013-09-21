// We're accustomed to writing functions that take n arguments, where n is
// the "arity", a number from 0 to a potentially large number (usually limited
// in some way by the system...).

// Let's define a 2-argument function. Note that type signature of this
// function value is: (Int,Int) => Double

def f2(i1:Int, i2:Int): Double = i1 * i2 * 3.14
// => f2: (Int, Int) => Double = <function2>

val result2 = f2(9, 4)
// => result2: Double = 113.04

// Here is the equivalent f2val that defines a function value instead:
val f2val: (Int, Int) => Double = (i1:Int, i2:Int) => i1*i2*3.14

// But the Lambda Calculus tells us that any n-argument function can
// be transformed into n functions that each take a single argument,
// where all but the LAST will return a function. To be concrete, the
// following function is effectively equivalent:

def f1(i1:Int)(i2:Int): Double = i1 * i2 * 3.14
// => f1: Int => (Int => Double) = <function1>
// Note how the compiler tells us we've defined a function that takes 
// an Int and returns a function that takes an Int and returns a double.
// Hence, the compiler is answering an important question. If I call 
// f1, which of the two Int arguments am I actually passing in, "i1" or "i2"?

val f11 = f1(9) _
// => f11: Int => Double = <function1>
// Note that we must append an "_" which says we are doing PARTIAL APPLICATION,
// that is, we are only applying some of the arguments, not making a mistake to
// specify all of them!
// The value f11 is a function of type Int => Double

val result1 = f11(4)
// => result1: Double = 113.04 (the same result)

// Here is the equivalent f1val that defines a function value instead:
val f1val: Int => Int => Double = (i1:Int) => (i2:Int) => i1*i2*3.14

// Now you DON'T have to append a "_":

val f11val = f1val(9)
// => f11val: Int => Double = <function1>
val result1val = f11val(4)
// => result1val: Double = 113.04


// This process of converting an n-ary function to n, 1-ary functions is 
// called "Currying", after Haskell Curry, one of the pioneers of the mathematics
// of computation (specifically, combinatorics...). 
// Scala provides a way to curry and uncurry function values, but not methods, at
// least directly (you need to define a value that calls the method...):

val f2valcurried = f2val.curried
// => f2valcurried: Int => (Int => Double) = <function1>
val f21c = f2valcurried(9)
// => f21c: Int => Double = <function1>
val result3 = f21c(4)
// => result3: Double = 113.04

// If you want to convert a 1-ary, curried function of "n levels" into an n-ary 
// function, use the Function object:
val f21d = Function.uncurried(f2valcurried)
// => f21d: (Int, Int) => Double = <function2>

val result4 = f21d(9,4)
// => result4: Double = 113.04


// Finally, for completeness, it's useful to know another transformation.
// Sometimes you have an n-ary function, but you actually need a function that
// takes a single tuple with the same number of elements and the same types.
// In other words, instead of this:
//   val f2val: (Int, Int) => Double = (i1:Int, i2:Int) => i1*i2*3.14
// you need this:
//   val f2tup: ((Int, Int)) => Double = (i12: (Int,Int)) => i12_.1*i12._2*3.14
// which, to be clear, is the same as this:
//   val f2tup: (Tuple2[Int, Int]) => Double = (i12: Tuple2[Int,Int]) => i12_.1*i12._2*3.14

val f2tup = f2val.tupled
// => f2tup: ((Int, Int)) => Double = <function1>
val result5 = f2tup(9 -> 4)  // same as f2tup((9,4)), same as f2tup(Tuple2(9,4))
// => result5: Double = 113.04

// And you can go the other direction:

val f2tupval = Function.untupled(f2tup)
// => f2tupval: (Int, Int) => Double = <function2>
val result6 = f2tupval(9,4)
// => result6: Double = 113.04

// See the Function scala docs for other utility transformations.
