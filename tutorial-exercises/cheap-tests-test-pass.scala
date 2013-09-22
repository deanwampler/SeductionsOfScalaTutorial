// cheap-tests-test-pass: Test "CheapTests" itself!
// None of these should fail!

import CheapTests._

List(1,2,3) is (1 to 3).toList
"Hello" is "Hello"
3.14159 is 3.14159

List(3,2,1) isnot (1 to 3).toList
"Hello" isnot "World!"
3.14159 isnot 3.0
