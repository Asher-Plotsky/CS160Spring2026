/*
Program 1 Token
Tokenize a string and override toString to return the token.
CS160-03
2/4/2026
@author Asher Plotsky
*/
public class Token {
    private String value;

    public Token(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    @Override
    public String toString(){
        return value;
    }
}
