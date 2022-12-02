package io.vgrente.callmeservice.repository;

import io.vgrente.callmeservice.model.Callme;
import org.springframework.data.repository.CrudRepository;

public interface CallmeRepository extends CrudRepository<Callme, Integer> {
}
