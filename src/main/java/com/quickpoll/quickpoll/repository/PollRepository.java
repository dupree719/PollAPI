package com.quickpoll.quickpoll.repository;


import com.quickpoll.quickpoll.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
}
