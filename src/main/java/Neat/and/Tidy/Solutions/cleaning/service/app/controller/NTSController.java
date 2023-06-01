package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.CreateServiceRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.CreateServiceResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.FindServiceResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Services;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.NTSService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/service")
public class NTSController {
private final NTSService ntsService;
    public NTSController(NTSService ntsService) {
        this.ntsService = ntsService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody CreateServiceRequest createServiceRequest){
        CreateServiceResponse createServiceResponse = ntsService.createService(createServiceRequest);
        return new ResponseEntity<>(createServiceResponse, HttpStatus.CREATED);
    }
    @GetMapping("/findService/{serviceId}")
    public ResponseEntity<?> findServiceById(@PathVariable Long serviceId){
        FindServiceResponse findServiceResponse = ntsService.findServiceById(serviceId);
        return new ResponseEntity<>(findServiceResponse, HttpStatus.OK);
    }
    @GetMapping("/getAllService")
    public ResponseEntity<?> findAllServices(){
        List<Services> allServices = ntsService.findAllServices();
        return new ResponseEntity<>(allServices, HttpStatus.OK);
    }
}
