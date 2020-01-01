package magix;

import java.util.List;                                 

import static magix.TokenType.*;

class Parser {                                         
  private final List<Token> tokens;                    
  private int current = 0;                             

  Parser(List<Token> tokens) {                         
    this.tokens = tokens;                              
  }                                                    
}
