package com.binsar.twitter.exceptions;

import com.binsar.twitter.states.UsernameStates;

public class UsernameException extends Exception {
    private String message;
    private UsernameStates code;


    public UsernameException(UsernameStates code) {
        setCode(code);
        setMessage();
    }

    public UsernameStates getCode() {
        return code;
    }

    public void setCode(UsernameStates code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = switch(getCode()) {
            case EMPTY -> "Maaf, username tidak boleh kosong!";
            case LENGTH_EXCEPTION -> "Maaf, username minimal harus terdiri dari 6 karakter";
            case MINIMUM_REQUIREMENT -> "Maaf, username hanya boleh mengandung huruf,angka,dan _(underscore)";
        };
    }
}
