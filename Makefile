test:
	mvn clean
	mvn test

format:
	mvn formatter:format

doc:
	rm -rf target/reports/apidocs
	mvn javadoc:javadoc
	xdg-open target/reports/apidocs/index.html

docs: doc

build:
	mvn clean
	mvn compile

.PHONY: test format
