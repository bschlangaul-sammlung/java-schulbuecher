export JAVA_HOME := "/usr/lib/jvm/java-25-openjdk-amd64"

test:
    ./mvnw clean
    ./mvnw test

format:
    ./mvnw formatter:format

doc:
    ./mvnw clean
    rm -rf target/reports/apidocs
    ./mvnw javadoc:javadoc
    xdg-open target/reports/apidocs/index.html

docs: doc

docs_open:
    xdg-open target/reports/apidocs/index.html

build:
    ./mvnw clean
    ./mvnw compile

cli *args:
    ./mvnw --quiet exec:java -Dexec.mainClass=schulbuecher.tools.PackageInfoGenerator -Dexec.args="{{args}}"
