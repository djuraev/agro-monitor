package uz.agromon.config.exception.klass;

import org.springframework.util.StringUtils;

import java.util.Map;

public class ResourceNotFoundException extends RuntimeException {
    Class klass;

    public ResourceNotFoundException(Class klass, String message) {
        super(message);
        this.klass = klass;
    }

}
