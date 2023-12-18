package com.example.restdemo.model;
import java.util.Objects;

public class CloudVendor {
  private Long vendorId;
  private String vendorName;
  private String vendorAddress;
  private String vendorPhoneNumber;


  public CloudVendor() {
  }


  public CloudVendor(Long vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
    this.vendorId = vendorId;
    this.vendorName = vendorName;
    this.vendorAddress = vendorAddress;
    this.vendorPhoneNumber = vendorPhoneNumber;
  }


  public Long getVendorId() {
    return this.vendorId;
  }

  public void setVendorId(Long vendorId) {
    this.vendorId = vendorId;
  }

  public String getVendorName() {
    return this.vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public String getVendorAddress() {
    return this.vendorAddress;
  }

  public void setVendorAddress(String vendorAddress) {
    this.vendorAddress = vendorAddress;
  }

  public String getVendorPhoneNumber() {
    return this.vendorPhoneNumber;
  }

  public void setVendorPhoneNumber(String vendorPhoneNumber) {
    this.vendorPhoneNumber = vendorPhoneNumber;
  }


  @Override
  public String toString() {
    return "{" +
      " vendorId='" + getVendorId() + "'" +
      ", vendorName='" + getVendorName() + "'" +
      ", vendorAddress='" + getVendorAddress() + "'" +
      ", vendorPhoneNumber='" + getVendorPhoneNumber() + "'" +
      "}";
  }

}
