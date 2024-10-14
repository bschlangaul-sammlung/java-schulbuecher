#! /bin/sh


_convert() {
    iconv -f ISO_8859-1 -t UTF-8 -o "$1" "$1"
}


for FILE in $(find "$1" -name \*.java); do # Not recommended, will break on whitespace
    echo $FILE
    _convert "$FILE"
done
