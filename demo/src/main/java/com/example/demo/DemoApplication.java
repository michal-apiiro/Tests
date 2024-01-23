package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * CustomerAddress
 */

@Generated(value = "value")
public class CustomerAddress  implements Serializable {

    private static final long ID = 1L;

    @JsonProperty("streetLine")
    private String streetLine;

    @JsonProperty("city")
    private String city;

    @JsonProperty("countryCode")
    private String countryCode;


}