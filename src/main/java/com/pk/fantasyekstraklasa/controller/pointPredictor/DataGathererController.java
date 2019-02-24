package com.pk.fantasyekstraklasa.controller.pointPredictor;

import com.pk.fantasyekstraklasa.logic.pointPredictor.DataGathererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataGatherer")
public class DataGathererController {

    private DataGathererService dataGathererService;

    @Autowired
    public DataGathererController(DataGathererService dataGathererService) {
        this.dataGathererService = dataGathererService;
    }

    @RequestMapping(value = "/gatherStatistics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> gatherStatistics() {
        this.dataGathererService.gatherStatistics();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/gatherScores", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> gatherScores() {
        this.dataGathererService.gatherScores();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
