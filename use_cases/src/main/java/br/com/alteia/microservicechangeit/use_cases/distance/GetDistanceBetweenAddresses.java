package br.com.alteia.microservicechangeit.use_cases.distance;

import br.com.alteia.microservicechangeit.entities.AddressDistance;
import br.com.alteia.microservicechangeit.use_cases.common.exceptions.NotFoundException;
import br.com.alteia.microservicechangeit.use_cases.distance.dto.GetDistanceBetweenAddressesResponseDto;

import java.util.Objects;

import static br.com.alteia.microservicechangeit.use_cases.common.enums.DistanceBetweenAdressesUseCaseErrorMessages.DISTANCE_BETWEEN_ADRESSES_NOT_FOUND;

public class GetDistanceBetweenAddresses {

    private final AddressDistanceRepository addressDistanceRepository;

    public GetDistanceBetweenAddresses(AddressDistanceRepository addressDistanceRepository) {
        this.addressDistanceRepository = addressDistanceRepository;
    }

    public GetDistanceBetweenAddressesResponseDto execute(String originCep, String destinationCep) {
        AddressDistance addressDistance = addressDistanceRepository.get(originCep, destinationCep);

        if (Objects.isNull(addressDistance)) {
            throw new NotFoundException(
                    DISTANCE_BETWEEN_ADRESSES_NOT_FOUND.getCode(),
                    DISTANCE_BETWEEN_ADRESSES_NOT_FOUND.getMessage(),
                    originCep,
                    destinationCep
            );
        }

        return new GetDistanceBetweenAddressesResponseDto(addressDistance);
    }


}
