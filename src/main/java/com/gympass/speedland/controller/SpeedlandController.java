package com.gympass.speedland.controller;

import com.gympass.speedland.controller.response.GrandPrixResponse;
import com.gympass.speedland.controller.response.PilotResponse;
import com.gympass.speedland.models.GrandPrix;
import com.gympass.speedland.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/speedland")
public class SpeedlandController {

    @Autowired
    private LogService logService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<? extends GrandPrixResponse> startGrandPrix() {

        try {
            GrandPrix grandPrix = logService.readLog();
            List<PilotResponse> pilots = new ArrayList<>();

            grandPrix.getPilots().forEach(p -> {

                PilotResponse pilotResponse = new PilotResponse()
                        .code(p.getCode())
                        .position(p.getPosition())
                        .name(p.getName())
                        .laps(p.getLaps().size());

                pilots.add(pilotResponse);
            });

            GrandPrixResponse response = new GrandPrixResponse()
                    .pilots(pilots)
                    .durationTime(grandPrix.getDurationTime());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
