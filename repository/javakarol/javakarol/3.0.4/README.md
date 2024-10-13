https://mebis.bycs.de/assets/uploads/posts/1/2/4/8/2/1ebccfee-28b9-4cc2-873e-2f54ca928393/JavaKarol30.zip

```
mvn install:install-file \
    -Dfile=javakarol.jar \
    -DgroupId=javakarol \
    -DartifactId=javakarol \
    -Dversion=3.0.4 \
    -Dpackaging=jar \
    -DlocalRepositoryPath=repository \
    -DcreateChecksum=true
```