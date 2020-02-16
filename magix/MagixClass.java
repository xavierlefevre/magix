package magix;

import java.util.List;
import java.util.Map;

class MagixClass implements MagixCallable {
  final String name;
  private final Map<String, MagixFunction> methods;

  MagixClass(String name, Map<String, MagixFunction> methods) {
    this.name = name;
    this.methods = methods;
  }

  MagixFunction findMethod(String name) {
    if (methods.containsKey(name)) {
      return methods.get(name);
    }

    return null;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    MagixInstance instance = new MagixInstance(this);
    return instance;
  }

  @Override
  public int arity() {
    return 0;
  }
}