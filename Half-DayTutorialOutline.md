# Half-Day Tutorial Outline

The main tutorial material is too long for a 1/2 day tutorial, such as you often find at conferences. The main tutorial material is easily enough for several full days.

So, my approach for a half-day tutorial is to work through hands-on exercises, learning while doing, and skipping the presentations, leaving them as reference material for your own follow-up reading.

Hence, this outline works through files in the `code-examples` folder, followed by some of the `tutorial-exercises`. 

## Functional Programming

While Scala is a hybrid object-functional language, let's start with the functional side, filling in a few details from the object side as we go. We'll return to the latter in a subsequent section.

### Creating a "Program" 

The following files are in `code-examples`:

| File | Purpose
| :--- | :---
| `caps-start.scala` | A compilable program that takes a list of words as input and prints only those words where the first letter is capitalized. Uses `filter` and `foreach`.
| `caps-start-point-free.scala` | Like `caps-start.scala`, but uses the *point-free style*.
| `caps-start-for.scala` | Uses a *for comprehension*.
| `caps-start-list.scala` | Converts the input argument array into a list and uses a *for comprehension*.

### Ranges and Tuples

Before we do our first exercise, let's look at a few other features we'll need:

| File | Purpose
| :--- | :---
| `ranges.scala` | Convenient way to define a range of numbers.
| `tuples.scala` | Convenient aggregates of fields.

### Exercise 1 - For Comprehensions

In the `tutorial-exercises` directory, do `ex6-for-comprehensions.scala`. Note that the solutions are in the `tutorial-exercises/solutions` directory.

| File | Purpose
| :--- | :---
| `ex6-for-comprehensions.scala` | Practice writing for comprehensions.

You will need to compile my simple test support code `tutorial-exercises/cheap-tests.scala`:

    cd tutorial-exercises
    scalac cheap-tests.scala

Note that you'll have several `*.class` files in the same directory. Each anonymous function is compiled into a separate class file with a synthesized name. There are other files for the declared classes and (singleton) object.

Then you can run your exercise solution thusly:

    scala -cp $PWD ex6-for-comprehensions.scala

**NOTE:** I've seen mysterious error for the `import CheapTests._` statement, even though this class is in the path after you compile `cheap-tests.scala`. Try `-cp .` and `-classpath $PWD`, etc. Another hack that appears to work is to load `cheap-tests.scala` as an "initialization script":

    scala -i cheap-tests.scala ex6-for-comprehensions.scala

or if you're copying and pasting into the REPL:

    scala -i cheap-tests.scala

*If you find a cause and solution for this behavior, e.g., a particular combination of Scala, Java, and OS version, please let me know!*

### Recursion

| File | Purpose
| :--- | :---
| `factorial.scala` | Implement factorial with left and right recursions.

### By-Name vs. By-Value Parameters

| File | Purpose
| :--- | :---
| `by-name-parameters.scala` | Creates a custom `loop` "operator", like `while`. Demonstrates one technique for internal DSL creation.

See also `custom-loop.scala` for a similar example.

## Object-Oriented Programming

### Case Classes and Implicits

Scala uses some object features to implement functional concepts, such as pattern matching and Haskell-style type classes, which are implemented using a "magical" technique called *implicits*.

| File | Purpose
| :--- | :---
| `minimap.scala` | Creates a `case class` for maps and also shows how Scala's syntax for map literals is actually implemented, using *implicits*.
| `int-to-hour.scala` | Add `hour` and `minute` methods to `Int` to build up a time DSL (domain-specific language).

For another example of type classes, see `type-classes.scala`.

### Traits

Traits are an extension of Java-style interfaces, where methods and values can be defined (but see Java 8 *default methods*). Traits enable true *mixin composition* in Scala, unlike Java.

We'll briefly visit traits in the **Components** section below. We won't have time to cover traits in detail, but see the following examples and exercises:

| File | Purpose
| :--- | :---
| `traits.scala` | An example of a logging abstraction with an implementation
| `traits2.scala` | An extension of the previous example demonstrating some of the fine points of mixing traits, especially traits that *aren't* disjoint, but have the same methods that are used to "wrap" methods in classes that mix in the traits.
| `tutorial-exercises/ex7-traits.scala` | An exercise for traits. (Optional - depending on time.)

## Back to FP

### Collections

The hallmark of functional languages are powerful collections libraries.

| File | Purpose
| :--- | :---
| `integer-order1-script.scala` | Manipulating a collection of integers. What does it do?
| `integer-order2-script.scala` | A shorter version of the previous example.

### Exercise 2 - Play with the Collections API

In the `tutorial-exercises` directory, do `ex4-collections.scala`. Note that the solutions are in the `tutorial-exercises/solutions` directory.

| File | Purpose
| :--- | :---
| `ex4-collections.scala` | Practice using collections.

### Pattern Matching

| File | Purpose
| :--- | :---
| `fib.scala` | Recursive Fibonacci functions that use pattern matching.
| `match-example.scala` | Matching on arbitrary types.
| `match-list-example.scala` | Matching on lists.

## Creating Internal Domain Specific Languages

We've seen several techniques that are useful for creating *internal* (a.k.a., embedded) DSLs. Here is a list of the ones we've seen, plus a few others:

* implicits
* combinators
* case classes
* type classes
* pattern matching
* by-name parameters

For external DSLs, the parser-combinator library can be used to define custom languages that aren't Scala (see **Bonus Topics** below).

## Components

| File | Purpose
| :--- | :---
| `cake-pattern.scala` | Schematic example of the *cake pattern* for defining component dependencies as abstractions and wiring together concrete instances. (Compare to *dependency injection*).

## Actors for Concurrency

We'll work through the complete example in `tutorial-exercises/drawing-actors`. It not only demonstrates the powerful [Akka](http://akka.io) library for concurrent applications, but also using the *de facto* standard build tool, [SBT](http://scala-sbt.org), to manage external dependencies and build applications.

## Bonus Topics

We probably won't get to these. The files that start with `exN-` for some number `N` are exercises found in the `tutorial-exercises` directory.

| File | Purpose
| :--- | :---
| `currying.scala` | How to curry and uncurry functions in Scala.
| `parser-combinators-example.scala` | Creating external DSLs with Scala's built-in parser combinator library.
| `ex11-external-dsl.scala` | An exercise using the parser combinator library.
| `ex7-traits.scala` | More advanced uses for Traits.
| `ex8-function-types.scala` | How functions are typed.
| `package-import-example.scala` | Scala's import directive is much more flexible than Java's. Here are examples.
| `type-experiments.scala` | More on the type system, which is Turing complete!

See also the other examples in the `code-examples/v2.10` directory, such as the examples for macros, reflection, the `Dynamic` trait, etc.