// Tuples

// Convert 3 input arguments into a tuple; here's a verbose implementation that 
// assumes three specific types:

def toTuple3_1(a: Int, b: Double, c: String):Tuple3[Int,Double,String] = Tuple3(a,b,c)

// We can write this more concisely. Note that (a,b,c) is the "literal" syntax for
// tuples. This can be a bit confusing with function argument lists...

def toTuple3_2(a: Int, b: Double, c: String) = (a,b,c)

// We can write a more generic version:

def toTuple3[A, B, C](a: A, b: B, c: C) = (a,b,c)

toTuple3_1(1, 2.2, "3.3")

toTuple3_2(1, 2.2, "3.3")

toTuple3(1, 2.2, "3.3")

toTuple3("Different", 2.2, ("3.3", 2, "example"))

val t3 = toTuple3("Different", 2.2, ("3.3", 2, "example"))

val (a,b,c) = toTuple3("Different", 2.2, ("3.3", 2, "example"))
println(a)
println(b)
println(c)
