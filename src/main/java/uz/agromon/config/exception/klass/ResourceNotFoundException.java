package uz.agromon.config.exception.klass;

import org.springframework.util.StringUtils;

import java.util.Map;

public class ResourceNotFoundException extends RuntimeException {
    Class klass;
    String searchParam;
    public ResourceNotFoundException(Class klass, String searchParam) {
        super();
        this.klass = klass;
        this.searchParam = searchParam;
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) + " was not found for parameters " + searchParams;
    }
}
