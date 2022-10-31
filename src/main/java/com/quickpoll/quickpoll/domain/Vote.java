package com.quickpoll.quickpoll.domain;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VOTE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Options options;

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Options getOption() {
        return options;
    }

    public void setOption(Options options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", options=" + options +
                '}';
    }
}
