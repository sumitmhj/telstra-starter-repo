package au.com.telstra.simcardactivator.Controller;

import au.com.telstra.simcardactivator.Model.Iccid;
import au.com.telstra.simcardactivator.Repository.IccidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping()
public class IccidController {
    @Autowired
    IccidRepository iccidRepository;

    @Autowired
    RestTemplate restTemplate;

//    @PostMapping
//    public Iccid createIccid(@RequestBody Iccid iccid){
//        return iccidRepository.save(iccid);
//    }

    @PostMapping("iccid")
    public ResponseEntity<String> postToOtherService(@RequestBody Iccid iccid) {
        System.out.println("hello sumit");
        String url = "http://localhost:8080" +
                "/actuate";

        String iccid_new = iccid.getIccid();

        Map<String, String> iccidData = new HashMap<>();
        iccidData.put("iccid", iccid_new);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(iccidData, headers);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            return response;
        } catch (ResourceAccessException e) {
            System.err.println("Connection refused: " + e.getMessage());
            return new ResponseEntity<>("Could not connect to the external service", HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);

//        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.OK);
        }
    }

//    @PostMapping("actuate")
//    public ResponseEntity<String> handleIccid(@RequestBody Map<String, String> iccidData){
//        String iccid = iccidData.get("iccid");
//
//        return ResponseEntity.ok("Received : "+ iccid);
//
//    }


}
