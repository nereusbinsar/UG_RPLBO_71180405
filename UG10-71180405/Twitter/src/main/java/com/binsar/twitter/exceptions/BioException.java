package com.binsar.twitter.exceptions;

import com.binsar.twitter.states.BioStates;

public class BioException extends Exception{
    private String message;
    private BioStates states;

    public BioException(BioStates state) {
        setStates(state);
        setMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = switch (getStates()) {
            case EMPTY -> "Maaf, bio tidak boleh kosong!";
            case LENGTH_EXCEPTION -> "Maaf, bio minimal harus terdiri dari 5 karakter dan maksimal 30 karakter";
            case MINIMUM_REQUIREMENT -> "Maaf, bio tidak boleh mengandung karakter spesial selain titik, et (@), serta spasi";
        };
    }

    public BioStates getStates() {
        return states;
    }

    private void setStates(BioStates states) {
        this.states = states;
    }
}
