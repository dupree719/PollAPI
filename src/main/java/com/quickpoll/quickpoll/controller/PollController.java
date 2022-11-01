package com.quickpoll.quickpoll.controller;

import com.quickpoll.quickpoll.domain.Poll;
import com.quickpoll.quickpoll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

    @RestController
    public class PollController {

        @Autowired
        private PollService pollService;

        @GetMapping("/polls")
        public ResponseEntity<Iterable<Poll>> getAllPolls() {
            return pollService.getAllPolls();
        }

        @PostMapping("/polls")
        public void createPoll(@Valid @RequestBody Poll poll) {
            pollService.createPoll(poll);
        }


        @GetMapping("/polls/{pollId}")
        public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
            return pollService.getPoll(pollId);
        }

        @PutMapping("/polls/{pollId}")
        public void updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {

           pollService.updatePoll(poll, pollId);
        }

        @DeleteMapping("/polls/{pollId}")
        public void deletePoll(@PathVariable Long pollId) {

          pollService.deletePoll(pollId);
        }
}
