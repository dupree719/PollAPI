package com.quickpoll.quickpoll.domain;

import java.util.Set;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POLL_ID")
    private Long id;

    @Column(name="QUESTION")
    @NotEmpty

    private String question;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    @Size(min=2, max = 6)
    private Set<Options> options;


    public Poll() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {

        this.options = options;
    }
    //we may need a to-string method as well


    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
