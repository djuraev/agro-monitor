package uz.agromon.helper;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {

    public static ResponseEntity<APIResponse> buildOk(List<Object> entities) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.getEntities().addAll(entities);
        apiResponse.setRequestFailed(false);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public static ResponseEntity<APIResponse> buildOk(Object entity) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.getEntities().add(entity);
        apiResponse.setRequestFailed(false);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public static ResponseEntity<APIResponse> buildError(FailureMessage message, HttpStatus httpStatus) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setRequestFailed(true);
        apiResponse.setFailureMessage(message);
        return new ResponseEntity<>(apiResponse, httpStatus);
    }

    public static ResponseEntity<APIPagesResponse> buildOk(List<Object> objects, long totalCount, int currentPage, int totalPages) {
        APIPagesResponse apiPagesResponse = new APIPagesResponse(totalCount, currentPage, totalPages);
        apiPagesResponse.getEntities().addAll(objects);
        apiPagesResponse.setRequestFailed(false);
        return new ResponseEntity<>(apiPagesResponse, HttpStatus.OK);
    }
}
