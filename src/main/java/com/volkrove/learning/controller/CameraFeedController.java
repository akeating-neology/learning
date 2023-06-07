package com.volkrove.learning.controller;

import com.volkrove.learning.model.CameraFeed;
import com.volkrove.learning.repo.CameraFeedRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.volkrove.learning.plumbing.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/cameras/")
public class CameraFeedController {

    @Autowired
    private CameraFeedRepo cameraFeedRepo;

    @GetMapping("/list")
    public List<CameraFeed> getAllCameraFeeds() {
        return cameraFeedRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CameraFeed> getCameraFeedById(@PathVariable(value = "id") Long cameraFeedId)
            throws ResourceNotFoundException {
        CameraFeed cameraFeed = cameraFeedRepo.findById(cameraFeedId)
                .orElseThrow(() -> new ResourceNotFoundException("CameraFeed not found for this id :: " + cameraFeedId));
        return ResponseEntity.ok().body(cameraFeed);
    }
    @PostMapping("/add")
    public CameraFeed createCameraFeed(@Valid @RequestBody CameraFeed camera) {
        camera.setId(null); //this is so that it auto-incrementes
        return cameraFeedRepo.save(camera);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CameraFeed> updateCameraFeed(
            @PathVariable(value = "id") Long cameraFeedId,
            @Valid @RequestBody CameraFeed cameraDetails) throws ResourceNotFoundException {
        CameraFeed cameraFeed = cameraFeedRepo.findById(cameraFeedId)
                .orElseThrow(() -> new ResourceNotFoundException("CameraFeed not found for this id :: " + cameraFeedId));

        cameraFeed.setName(cameraDetails.getName());
        cameraFeed.setUrl(cameraDetails.getUrl());
        cameraFeed.setActive(cameraDetails.getActive());
        cameraFeed.setFirstBehavior(cameraDetails.getFirstBehavior());

        final CameraFeed updatedCameraFeed = cameraFeedRepo.save(cameraFeed);
        return ResponseEntity.ok(updatedCameraFeed);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteCameraFeed(@PathVariable(value = "id") Long cameraFeedId)
            throws ResourceNotFoundException {
        CameraFeed cameraFeed = cameraFeedRepo.findById(cameraFeedId)
                .orElseThrow(() -> new ResourceNotFoundException("CameraFeed not found for this id :: " + cameraFeedId));

        cameraFeedRepo.delete(cameraFeed);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<CameraFeed> activateCameraFeed(
            @PathVariable(value = "id") Long cameraFeedId,
            @Valid @RequestBody CameraFeed cameraDetails) throws ResourceNotFoundException {
        CameraFeed cameraFeed = cameraFeedRepo.findById(cameraFeedId)
                .orElseThrow(() -> new ResourceNotFoundException("CameraFeed not found for this id :: " + cameraFeedId));

        cameraFeed.setActive(Boolean.TRUE);

        final CameraFeed updatedCameraFeed = cameraFeedRepo.save(cameraFeed);
        return ResponseEntity.ok(updatedCameraFeed);
    }
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<CameraFeed> deactivateCameraFeed(
            @PathVariable(value = "id") Long cameraFeedId,
            @Valid @RequestBody CameraFeed cameraDetails) throws ResourceNotFoundException {
        CameraFeed cameraFeed = cameraFeedRepo.findById(cameraFeedId)
                .orElseThrow(() -> new ResourceNotFoundException("CameraFeed not found for this id :: " + cameraFeedId));

        cameraFeed.setActive(Boolean.FALSE);

        final CameraFeed updatedCameraFeed = cameraFeedRepo.save(cameraFeed);
        return ResponseEntity.ok(updatedCameraFeed);
    }

}
