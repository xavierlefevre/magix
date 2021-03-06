package magix;

import java.util.List;
import java.util.Map;

class MagixClass implements MagixCallable {
  final String name;
  final MagixClass superclass;
  private final Map<String, MagixFunction> methods;

  MagixClass(String name, MagixClass superclass, Map<String, MagixFunction> methods) {
    this.superclass = superclass;
    this.name = name;
    this.methods = methods;
  }

  MagixFunction findMethod(String name) {
    if (methods.containsKey(name)) {
      return methods.get(name);
    }

    if (superclass != null) {
      return superclass.findMethod(name);
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
    MagixFunction initializer = findMethod("init");
    if (initializer != null) {
      initializer.bind(instance).call(interpreter, arguments);
    }

    return instance;
  }

  @Override
  public int arity() {
    MagixFunction initializer = findMethod("init");
    if (initializer == null)
      return 0;
    return initializer.arity();
  }
}