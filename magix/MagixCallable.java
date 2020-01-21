package magix;

import java.util.List;

interface MagixCallable {
  int arity();

  Object call(Interpreter interpreter, List<Object> arguments);
}