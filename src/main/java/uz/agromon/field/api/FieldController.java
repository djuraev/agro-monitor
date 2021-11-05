package uz.agromon.field.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/field")
public class FieldController {

    @Autowired
    FieldService fieldService;

    @PostMapping("/field")
    ResponseEntity<APIResponse> createField(@RequestBody Field field) {
        Field createdField = fieldService.create(field);
        return ResponseBuilder.buildOk(createdField);
    }

    @PutMapping("/field")
    ResponseEntity<APIResponse> updateField(@RequestBody Field field) {
        return null;
    }

    @DeleteMapping("/field/{fieldId}")
    ResponseEntity<APIResponse> deleteField(@PathVariable String fieldId) {
        Integer iFieldId = Integer.parseInt(fieldId);
        fieldService.deleteField(iFieldId);
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("resultMessage", "Field deleted.");
        return ResponseBuilder.buildOk(responseMessage);
    }

    @GetMapping("/field/{userSequence}")
    ResponseEntity<APIResponse> getUserFields(@PathVariable String userSequence) {
        List<Field> userFields = fieldService.getFieldsOfUser(userSequence);
        return ResponseBuilder.buildOk(userFields);
    }
}
