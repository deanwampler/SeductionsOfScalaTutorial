// Exercise 3: Implicits - add toXML to Map.
// This options for exercise 3 is actually a little harder than the other one...
//
// We'll look at one of the important uses of implicits: "extension methods" or
// "type classes"; two names used in different languages for techniques that
// allow you to add new methods to types. The other common use for implicits is
// Type conversions. We saw an example in the presentation when we discussed the
// -> "operator" for adding key-value pairs to Maps. For another example, see
// the companion Exercise3 for working with doubles that are wrapped with feet
// or meter units. See also our little DSL for testing in "cheap-tests.scala".
//
// Note that we'll make simplifying assumptions:
//   1. The output is actually a simple string, not a tree of objects
//      representing XML nodes, etc.
//   2. ASSUME there are no nested collections, just simple values!
//   3. 2-space indentation. This could be configurable through a function arg.
//   4. Newlines are inserted everywhere. This could be configurable...
//
// Other possible extensions:
//   1. Handle arbitrary nesting of collections. (not trivial.)
//   2. Add an optional function arg. that names the outer tag, e.g.,
//      "<person>" instead of just using "<map>" (make "<map>" the default).
//   3. Sort the map keys alphabetically.

/* ------------------------------- */
/* Define the implicit class here. */
/* ------------------------------- */

// Hint: When traversing the map elements, get the keys,
// convert them to a list so you can sort them, (use the
// sortBy(key => key.toString), since the keys aren't necessarily
// strings), then use foreach to iterate through the keys, where
// you should get the corresponding value and format the tag.

import CheapTests._

val person = Map(
  "name"    -> "Dean Wampler", 
  "age"     -> 29,
  "street"  -> "101 Scala Drive",
  "city"    -> "Lausanne",
  "country" -> "CH"
)

person.toXML is """<map>
  <age>
    29
  </age>
  <city>
    Lausanne
  </city>
  <country>
    CH
  </country>
  <name>
    Dean Wampler
  </name>
  <street>
    101 Scala Drive
  </street>
</map>
"""

println("Success!")