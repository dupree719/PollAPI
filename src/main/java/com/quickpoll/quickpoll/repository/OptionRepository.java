package com.quickpoll.quickpoll.repository;

import com.quickpoll.quickpoll.domain.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Options, Long> {
}
