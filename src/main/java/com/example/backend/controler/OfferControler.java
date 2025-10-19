package com.example.backend.controler;

import com.example.backend.model.Offer;
import com.example.backend.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferControler {

    private final OfferService offerService;

    public OfferControler(OfferService offerService) {
        this.offerService = offerService;
    }


    @PostMapping("/offer")
    public ResponseEntity<?> saveOffer(@RequestBody Offer offer){
        return  offerService.saveoffer(offer);
    }


    public ResponseEntity<?> getOfferAll(){
        return offerService.getOfferAll();
    }

}
