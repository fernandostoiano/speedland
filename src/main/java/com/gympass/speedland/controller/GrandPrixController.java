package com.gympass.speedland.controller;

import com.gympass.speedland.controller.response.GrandPrixResponse;
import com.gympass.speedland.converter.GrandPrixResponseConveter;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.services.GrandPrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/speedland")
public class GrandPrixController {

    @Autowired
    private GrandPrixService grandPrixService;

    @Autowired
    private GrandPrixResponseConveter grandPrixResponseConveter;

    @PostMapping(path = "/start_race", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<? extends GrandPrixResponse> startRace(
            @RequestParam(value = "filePath", required = false) String path) {

        GrandPrix grandPrix = grandPrixService.startRace(path);

        GrandPrixResponse response = grandPrixResponseConveter.apply(grandPrix);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
