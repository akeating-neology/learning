package com.volkrove.learning.controller;

import com.volkrove.learning.model.CameraFeed;
import com.volkrove.learning.model.OcrBehavior;
import com.volkrove.learning.plumbing.ResourceNotFoundException;
import com.volkrove.learning.repo.OcrBehaviorRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ocrbehaviors/")
public class OcrBehaviorController {

    @Autowired
    private OcrBehaviorRepo ocrBehaviorRepo;

    @GetMapping("/list")
    public List<OcrBehavior> getAllOcrBehaviors() { return ocrBehaviorRepo.findAll(); }

    @GetMapping("/id")
    public ResponseEntity<OcrBehavior> getOcrBehaviorById(@PathVariable(value ="id") Long ocrBehaviorId)
            throws ResourceNotFoundException {
        OcrBehavior employee = ocrBehaviorRepo.findById(ocrBehaviorId)
                .orElseThrow(() -> new ResourceNotFoundException("OcrBehavior not found for this id :: " + ocrBehaviorId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/add")
    public OcrBehavior createOcrBehavior(@Valid @RequestBody OcrBehavior ocrBehavior) {
        ocrBehavior.setId(null); //this is so that it auto-incrementes
        return ocrBehaviorRepo.save(ocrBehavior);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OcrBehavior> updateOcrBehavior(
            @PathVariable(value = "id") Long ocrBehaviorId,
            @Valid @RequestBody OcrBehavior ocrBehaviorDetails) throws ResourceNotFoundException {
        OcrBehavior ocrBehavior = ocrBehaviorRepo.findById(ocrBehaviorId)
                .orElseThrow(() -> new ResourceNotFoundException("OcrBehavior not found for this id :: " + ocrBehaviorId));

        ocrBehavior.setxCord(ocrBehaviorDetails.getxCord());
        ocrBehavior.setyCord(ocrBehaviorDetails.getyCord());
        ocrBehavior.setHeight(ocrBehaviorDetails.getHeight());
        ocrBehavior.setWidth(ocrBehaviorDetails.getWidth());
        ocrBehavior.setSanityRegex(ocrBehaviorDetails.getSanityRegex());
        ocrBehavior.setSampleRate(ocrBehaviorDetails.getSampleRate());
        ocrBehavior.setNextBehavior(ocrBehaviorDetails.getNextBehavior());

        final OcrBehavior updatedOcrBehavior = ocrBehaviorRepo.save(ocrBehavior);
        return ResponseEntity.ok(updatedOcrBehavior);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteOcrBehavior(@PathVariable(value = "id") Long ocrBehaviorId)
            throws ResourceNotFoundException {
        OcrBehavior ocrBehavior = ocrBehaviorRepo.findById(ocrBehaviorId)
                .orElseThrow(() -> new ResourceNotFoundException("ocrBehavior not found for this id :: " + ocrBehaviorId));

        ocrBehaviorRepo.delete(ocrBehavior);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
