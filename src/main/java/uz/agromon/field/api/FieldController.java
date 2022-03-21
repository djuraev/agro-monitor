package uz.agromon.field.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.field.store.jpo.FieldJpo;
import uz.agromon.helper.APIPagesResponse;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.*;

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

    @GetMapping("/fields/{villageId}")
    ResponseEntity<APIResponse> getAllFields(@PathVariable String villageId) {
        Integer vid = Integer.valueOf(villageId);
        List<Field> allFields = fieldService.getFieldOfVillage(vid);
        return ResponseBuilder.buildOk(allFields);
    }

    @PostMapping("/fields/dynamic")
    ResponseEntity<APIResponse> dynamicFieldRequest(@RequestBody Field field) {
        List<FieldJpo> fields = fieldService.findAll(field);
        Collections.reverse(fields);
        return ResponseBuilder.buildOk(fields);
    }
}
