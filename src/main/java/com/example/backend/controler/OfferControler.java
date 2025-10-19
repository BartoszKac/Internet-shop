package com.example.backend.controler;

import com.example.backend.model.Offer;
import com.example.backend.model.User;
import com.example.backend.service.OfferService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OfferControler {

    private final OfferService offerService;

    public OfferControler(OfferService offerService) {
        this.offerService = offerService;
    }


    @PostMapping("/offer")
    public ResponseEntity<?> saveOffer(@RequestBody Offer offer) {
        return offerService.saveoffer(offer);
    }

    @GetMapping("/alloffer")
    public ResponseEntity<?> getOfferAll() {
        return offerService.getOfferAll();
    }

    @GetMapping("/offerById/{id}")
    public ResponseEntity<?> getOfferById(@PathVariable long id) {
        return offerService.getOfferById(id);
    }


    @GetMapping("/searchOffer/{search}")
    public ResponseEntity<?> getOfferByText(@PathVariable String search) {

        return offerService.SearchOffer(search);

    }
}
