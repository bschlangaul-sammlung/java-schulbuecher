`dpkg -L greenfoot`

http://www.greenfoot.org/download/files/Greenfoot-linux-381.deb

```
mvn install:install-file \
   -Dfile=/usr/share/greenfoot/greenfoot.jar \
   -DgroupId=greenfoot \
   -DartifactId=greenfoot \
   -Dversion=3.8.1 \
   -Dpackaging=jar \
   -DlocalRepositoryPath=repository \
   -DcreateChecksum=true
```