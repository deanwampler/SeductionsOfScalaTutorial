all: clean exercises

clean: exercises.clean 

exercises: cheap-tests

cheap-tests: cheap-tests-compile cheap-tests-test

cheap-tests-compile:
	scalac -cp ${PWD} cheap-tests.scala

cheap-tests-test: cheap-tests-test-pass cheap-tests-test-fail

cheap-tests-test-pass:
	scala -cp ${PWD} cheap-tests-test-pass.scala

# Because each failed test exits; we just pass individual expressions to the REPL
# and test that they exit with nonzero status!
cheap-tests-test-fail:
	@for expr in "List(1,2) is List(1)" "List(1,2) isnot List(1,2)" "3.14 is 3.0" "3.14 isnot 3.14"; \
	do \
	  tmpfile=$$$$.out; \
	  t="import CheapTests._; $$expr"; \
	  echo "code: $$t" > $$tmpfile; \
	  scala -cp /${PWD} -e "$$t" >> $$tmpfile 2>&1; \
	  if [ $$? -eq 0 ]; then echo "Failed!"; cat $$tmpfile; rm $$tmpfile; exit 1; fi; \
		rm $$tmpfile; \
	done

exercises.clean:
	rm -f *.class
