package com.binsar.twitter.exceptions;

import com.binsar.twitter.states.TwitterStates;

public class TweetException extends Exception{
    private String message;
    private TwitterStates states;

    public TweetException(TwitterStates states) {
        setStates(states);
        setMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = switch(getStates()){
            case EMPTY -> "Maaf, username tidak boleh kosong!";
            case LENGTH_EXCEPTION -> "Maaf, tweet minimal harus terdiri dari 8 karakter dan maksimal 140 karakter";
        };
    }

    public TwitterStates getStates() {
        return states;
    }

    public void setStates(TwitterStates states) {
        this.states = states;
    }
}
