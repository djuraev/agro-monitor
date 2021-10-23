package uz.agromon.config.exception.klass;

import lombok.Getter;

@Getter
public class InvalidParameterException extends RuntimeException{
    String paramName;

    public InvalidParameterException(String paramName) {
        super(paramName);
        this.paramName = paramName;
    }

}
