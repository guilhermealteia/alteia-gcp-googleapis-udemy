package br.com.alteia.microservicechangeit.entities;

import static br.com.alteia.microservicechangeit.use_cases.common.utils.EntityFieldsValidations.notNull;

public class AddressDistance {

    private String destination;
    private String origin;
    private String distance;
    private String duration;

    public AddressDistance(String destination, String origin, String distance, String duration) {
        setDestination(destination);
        setOrigin(origin);
        setDistance(distance);
        setDuration(duration);
    }

    public String getDestination() {
        return destination;
    }

    private void setDestination(String destination) {
        notNull("destination", destination);
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    private void setOrigin(String origin) {
        notNull("origin", origin);
        this.origin = origin;
    }

    public String getDistance() {
        return distance;
    }

    private void setDistance(String distance) {
        notNull("distance", distance);
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    private void setDuration(String duration) {
        notNull("duration", duration);
        this.duration = duration;
    }
}
