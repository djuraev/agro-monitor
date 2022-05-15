package uz.agromon.info;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.FailureMessage;
import uz.agromon.helper.ResponseBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    @PostMapping("/html/upload/{page}/{lang}")
    public ResponseEntity<APIResponse> uploadInfoHtmlFile(@RequestParam("file")MultipartFile htmlFile, @PathVariable String page, @PathVariable String lang) throws IOException {
        String fileName = "/static/htmlViews/" + page + "_" + lang+".html";
        String coreFolder = new ClassPathResource("application.yaml").getFile().getParent();
        fileName = coreFolder + fileName;
        try {
            //Files.copy(htmlFile.getInputStream(), Paths.get(fileName), StandardCopyOption.ATOMIC_MOVE);
            htmlFile.transferTo(new File(fileName));
            //htmlFile.sav(new File(fileName));
        }
        catch (IOException ioException) {
            return ResponseBuilder.buildError(new FailureMessage("Cannot save the file.", ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseBuilder.buildOk("File saved.");
    }
}
