package au.com.telstra.simcardactivator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/actuate")
public class ActuateController {

//    @Autowired
//    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<String> handleActuateRequest(@RequestBody Map<String, String> iccidData){
        String iccid = iccidData.get("iccid");
        System.out.println("REceived iccid: "+ iccid);
        return new ResponseEntity<>("Processed iccid: "+ iccid, HttpStatus.OK);
    }
}

