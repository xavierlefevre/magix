# Magix

Language creation, following the amazing [www.craftinginterpreters.com](http://www.craftinginterpreters.com/) course.

## Compile and run

- Compile your program: `javac -d build magix/Magix.java`
- Run it with an input file: `java -cp build magix/Magix "testFiles/ParserTest.magix"`
- Run it in REPL: `java -cp build magix/Magix`

## Edit the language

- You can generate expressions (`magix/Expr.java`) with `tool/GenerateAst.java`, run it by typing in your terminal: `java tool/GenerateAst.java "./magix"`