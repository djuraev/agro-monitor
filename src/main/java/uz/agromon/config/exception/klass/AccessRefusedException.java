package uz.agromon.config.exception.klass;

public class AccessRefusedException extends RuntimeException {
    public AccessRefusedException(String message){
        super(message);
    }
}
