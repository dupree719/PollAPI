package com.quickpoll.quickpoll.controller;

import com.quickpoll.quickpoll.domain.Vote;
import com.quickpoll.quickpoll.dto.OptionCount;
import com.quickpoll.quickpoll.dto.VoteResult;
import com.quickpoll.quickpoll.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

    @RestController
    public class ComputeResultController {

        @Autowired
        private VoteRepository voteRepository;

        @GetMapping("/computeresult")
        public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
            VoteResult voteResult = new VoteResult();
            Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);
// Algorithm to count votes
            int totalVotes = 0;
            Map<Long, OptionCount> tempMap = new HashMap<Long,
                    OptionCount>();
            for (Vote v : allVotes) {
                totalVotes++;
// Get the OptionCount corresponding to this Option
                OptionCount optionCount
                        = tempMap.get(v.getOption().getId());
                if (optionCount == null) {
                    optionCount = new OptionCount();
                    optionCount.setOptionId(v.getOption().getId());
                    tempMap.put(v.getOption().getId(),
                            optionCount);
                }
                optionCount.setCount(optionCount.getCount() + 1);
            }
            voteResult.setTotalVotes(totalVotes);

            return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
        }
    }
