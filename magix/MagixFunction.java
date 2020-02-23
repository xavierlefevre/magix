package magix;

import java.util.List;

class MagixFunction implements MagixCallable {
  private final Stmt.Function declaration;
  private final Environment closure;

  MagixFunction(Stmt.Function declaration, Environment closure) {
    this.closure = closure;
    this.declaration = declaration;
  }

  MagixFunction bind(MagixInstance instance) {
    Environment environment = new Environment(closure);
    environment.define("this", instance);
    return new MagixFunction(declaration, environment);
  }

  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    Environment environment = new Environment(closure);
    for (int i = 0; i < declaration.params.size(); i++) {
      environment.define(declaration.params.get(i).lexeme, arguments.get(i));
    }

    try {
      interpreter.executeBlock(declaration.body, environment);
    } catch (Return returnValue) {
      return returnValue.value;
    }
    return null;
  }

  @Override
  public int arity() {
    return declaration.params.size();
  }

  @Override
  public String toString() {
    return "<fn " + declaration.name.lexeme + ">";
  }
}