2023-11-27 https://codeload.github.com/engine-alpha/edu-klassen-v4/zip/refs/heads/master

mvn install:install-file \
   -Dfile=.jars/Engine.Alpha.jar \
   -DgroupId=ea.edu \
   -DartifactId=AlphaEngine \
   -Dversion=4.0.0 \
   -Dpackaging=jar \
   -DlocalRepositoryPath=repository \
   -DcreateChecksum=true
