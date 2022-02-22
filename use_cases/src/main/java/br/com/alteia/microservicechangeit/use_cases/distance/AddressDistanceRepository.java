package br.com.alteia.microservicechangeit.use_cases.distance;

import br.com.alteia.microservicechangeit.entities.AddressDistance;

public interface AddressDistanceRepository {

    AddressDistance get(String originCep, String destinationCep);

}
