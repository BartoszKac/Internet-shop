package com.example.backend.service;

import com.example.backend.model.Offer;
import com.example.backend.model.OfferLite;
import com.example.backend.repository.OfferRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfferService {


    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public ResponseEntity<?> saveoffer(Offer offer){

        if(offerRepository.findById(offer.getId()).isPresent()){
            return ResponseEntity.
                    badRequest().
                    body("Offer with this id already exists");
        }
        return ResponseEntity.ok(offerRepository.save(offer));
    }

    public ResponseEntity<?> getOfferAll(){
        List<OfferLite> offerLites = offerRepository.findAll()
                .stream().
                map( offer -> new OfferLite(
                     offer.getId(),
                        offer.getTitle(),
                            offer.getPrice()
                        )).toList();

        return ResponseEntity.ok( offerLites);

    }
}
