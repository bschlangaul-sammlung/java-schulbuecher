#! /usr/bin/env python

from pathlib import Path
from typing import List
import termcolor

result = list(Path("src").rglob("*.java"))


def convert_path_to_package(file_path: str) -> str:
    """src/main/java/rocks/friedrich/schule/jahrgangsstufe_09/n30_objektorientierung/n70_konstruktor/ball_vorlage/Spielfeld.java
jf.jahrgangsstufe_09.n30_objektorientierung.n70_konstruktor.ball_vorlage
"""
    segments = file_path.split('/')
    segments = segments[3:-1]
    return '.'.join(segments)


def add_package_statement(file_path: str):
    lines: List[str]
    with open(file_path, 'r') as fin:
        lines = fin.read().splitlines(True)

    package_statement = 'package ' + convert_path_to_package(file_path) + ';\n'

    while lines[0] == '\n':
        lines = lines[1:]

    if lines[0].startswith('package '):
        if lines[0] == package_statement:
            print(termcolor.colored(lines[0], 'green'))
        else:
            print(termcolor.colored(lines[0], 'yellow'))
            lines[0] = package_statement
    else:
        print(termcolor.colored(package_statement, 'red'))
        lines = [package_statement, '\n'] + lines

    with open(file_path, 'w') as fout:
        fout.writelines(lines)


for java_file in result:
    java_file = str(java_file)
    print(java_file)
    add_package_statement(java_file)
