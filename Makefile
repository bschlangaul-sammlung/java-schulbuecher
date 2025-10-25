test:
	mvn clean
	mvn test

format:
	mvn formatter:format

doc:
	mvn clean
	rm -rf target/reports/apidocs
	mvn javadoc:javadoc
	xdg-open target/reports/apidocs/index.html

docs: doc

docs_open:
	xdg-open target/reports/apidocs/index.html

build:
	mvn clean
	mvn compile

.PHONY: test format
