package br.com.alteia.microservicechangeit.use_cases.distance.dto;

import br.com.alteia.microservicechangeit.entities.AddressDistance;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class GetDistanceBetweenAddressesResponseDto {

    @ApiModelProperty(value = "CEP Destino", required = true)
    private String destination;

    @ApiModelProperty(value = "CEP Origem", required = true)
    private String origin;

    @ApiModelProperty(value = "Distância entre os CEPs", required = true)
    private String distance;

    @ApiModelProperty(value = "Duração do trajeto principal", required = true)
    private String duration;

    public GetDistanceBetweenAddressesResponseDto(AddressDistance addressDistance) {
        if (Objects.isNull(addressDistance)) {
            this.destination = addressDistance.getDestination();
            this.origin = addressDistance.getOrigin();
            this.distance = addressDistance.getDistance();
            this.duration = addressDistance.getDuration();
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
