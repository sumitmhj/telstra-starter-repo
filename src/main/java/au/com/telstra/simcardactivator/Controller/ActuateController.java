package au.com.telstra.simcardactivator.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ActuateController {

    @PostMapping("/actuate")
    public ResponseEntity<String> handleActuateRequest(@RequestBody Map<String, String> iccidData){
        String iccid = iccidData.get("iccid");
        System.out.println("REceived iccid: "+ iccid);
        return new ResponseEntity<>("Processed iccid: "+ iccid, HttpStatus.OK);
    }
}
