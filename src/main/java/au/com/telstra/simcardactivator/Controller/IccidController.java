package au.com.telstra.simcardactivator.Controller;

import au.com.telstra.simcardactivator.Model.Iccid;
import au.com.telstra.simcardactivator.Repository.IccidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iccid")
public class IccidController {
    @Autowired
    IccidRepository iccidRepository;

    @PostMapping
    public Iccid createIccid(@RequestBody Iccid iccid){
        return iccidRepository.save(iccid);
    }

}
