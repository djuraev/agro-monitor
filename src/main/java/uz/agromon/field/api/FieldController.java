package uz.agromon.field.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;

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
}
