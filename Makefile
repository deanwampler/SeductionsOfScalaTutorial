# Makefile for building the Seductions of Scala Tutorial distribution

STAGE_DIR=seductions-of-scala-tutorial
ZIP=${STAGE_DIR}.zip
TGZ=${STAGE_DIR}.tgz

all: zip tgz

zip: stage
	zip -r ${ZIP} ${STAGE_DIR}

tgz: stage
	tar czf ${TGZ} ${STAGE_DIR}

stage: clean ${STAGE_DIR}
	cp README.* Half* SeductionsOfScalaTutorial*.pdf ${STAGE_DIR}
	cp -r code-examples ${STAGE_DIR}/code-examples
	cp -r tutorial-exercises ${STAGE_DIR}/tutorial-exercises

# Actually, we will distribute the compiled class files:
# clean: code.clean stage.clean zip.clean
clean: stage.clean zip.clean tgz.clean

code.clean:
	cd tutorial-exercises/drawing-actors; sbt clean
	find code-examples tutorial-exercises -name '*.class' -exec rm {} \;

stage.clean:  
	rm -rf ${STAGE_DIR}

zip.clean:  
	rm -f ${ZIP}

tgz.clean:  
	rm -f ${TGZ}

${STAGE_DIR}:
	mkdir -p ${STAGE_DIR}
    
