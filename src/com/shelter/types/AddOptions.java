package com.shelter.types;

public enum AddOptions {

    TYPE("Animal Type"),
    NAME("Animal's Name"),
    AGE("Animal's Age");

    private String description;


    private AddOptions(String description) {
          this.description = description;
      }

      public String getDescription() {
        return description;
      }

}
