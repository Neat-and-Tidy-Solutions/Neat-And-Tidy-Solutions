package Neat.and.Tidy.Solutions.cleaning.service.app.controller;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCleanerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCleanerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CleanerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cleaner")
@CrossOrigin("*")
@AllArgsConstructor
public class CleanerController {

    @Autowired
    private CleanerService cleanerService;

    @PostMapping("/update")
    public ResponseEntity<?> updateCleanerProfile(@RequestBody UpdateCleanerRequest updateCleanerRequest) {
        cleanerService.updateProfile(updateCleanerRequest);
        return ResponseEntity.ok("Cleaner updated successfully");
    }


    @GetMapping("/getCleanerId")
    public ResponseEntity<?> getCleanerId(@RequestBody Long id) {
        Cleaner cleaner = cleanerService.getCleanerById(id);
        return new ResponseEntity<>(cleaner, HttpStatus.OK);
    }


    @GetMapping("/getAllCleaners")
    public ResponseEntity<?> getAllCleaners() {
        List<Cleaner> cleaner = cleanerService.getCleaners();
        return new ResponseEntity<>(cleaner, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllCleaners")
    public ResponseEntity<?> deleteCleanerByID(Long cleanerId) {
        cleanerService.deleteCleanerById(cleanerId);
        return ResponseEntity.ok("Cleaner deleted successfully");
    }




}
