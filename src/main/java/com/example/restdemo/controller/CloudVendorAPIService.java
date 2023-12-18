package com.example.restdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendors")
public class CloudVendorAPIService {
  private final List<CloudVendor> cloudVendors = new ArrayList<>();
  private long idCounter = 1;

  @GetMapping
  public List<CloudVendor> getCloudVendors() {
    return cloudVendors;
  }

  @GetMapping("/{vendorId}")
  public Optional<CloudVendor> getCloudVendorDetails(@PathVariable Long vendorId) {
    return cloudVendors.stream()
                       .filter(cloudVendor -> cloudVendor.getVendorId().equals(vendorId))
                       .findFirst();
  }

  @PostMapping
  public CloudVendor createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    cloudVendor.setVendorId(idCounter++);
    cloudVendors.add(cloudVendor);

    return cloudVendor;
  }

  @PutMapping("/{vendorId}")
  public Optional<CloudVendor> updateCloudVendorDetails(@PathVariable Long vendorId, @RequestBody CloudVendor newCloudVendor ) {
    for (CloudVendor cloudVendor : cloudVendors) {
      System.out.println(cloudVendor.getVendorId().equals(vendorId));
      if (cloudVendor.getVendorId().equals(vendorId)) {
        cloudVendor.setVendorName(newCloudVendor.getVendorName());
        cloudVendor.setVendorAddress(newCloudVendor.getVendorAddress());
        cloudVendor.setVendorPhoneNumber(newCloudVendor.getVendorPhoneNumber());
        return Optional.of(cloudVendor);
      }
    }
    return Optional.empty();
  }

  @DeleteMapping("/{vendorId}")
  public boolean deleteCloudVendorDetails(@PathVariable Long vendorId) {
    return cloudVendors.removeIf(cloudVendor -> cloudVendor.getVendorId().equals(vendorId));
  }
}
