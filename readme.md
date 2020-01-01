# Magix

Language creation, following the amazing [www.craftinginterpreters.com](http://www.craftinginterpreters.com/) course.

## Compile and run

- Compile your program: `javac magix/Magix.java`
- Run it with an input file: `java magix/Magix "TestCode.magix"`
- RUn it in REPL: `java magix/Magix`

## Edit the language

- You can generate new expressions with `tool/GenerateAst.java`, run it by typing in your terminal: `java tool/GenerateAst.java "./magix"`