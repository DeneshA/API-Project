package co.pragra.coop.springbootjpaproject;

import lombok.Data;

import java.time.Instant;
@Data
public class Error {
    private String code;
    private String description;
    private Instant time;

    public Error(String code, String description, Instant time) {
        this.code = code;
        this.description = description;
        this.time = time;
    }
}
