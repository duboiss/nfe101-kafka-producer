package edu.cnam.nfe101.kafkaproducer.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cnam.nfe101.kafkaproducer.service.AddressManager;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressManager addressManager;

    public AddressController(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @PostMapping
    public ResponseEntity<String> transfer(@RequestParam String file) {
        try {
            addressManager.transfer(file);
            return ResponseEntity.ok("File imported successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }
    }
}
