test:
	mvn test

format:
	mvn formatter:format

doc:
	mvn javadoc:javadoc

build:
	mvn compile

.PHONY: test format
