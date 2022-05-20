package com.binsar.twitter.exceptions;

import com.binsar.twitter.states.LoginStates;

public class LoginException extends Exception{
    private String message;
    private LoginStates state;

    public LoginException(LoginStates state) {
        setState(state);
        setMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = switch(getState()) {
            case EMPTY_USERMAME -> "Maaf, silakan masukan username!";
            case EMPTY_PASSWORD -> "Maaf, silakan masukan password!";
            case WRONG_INPUT -> "Maaf, username atau password salah! Silakan coba lagi!";
        };
    }

    public LoginStates getState() {
        return state;
    }

    public void setState(LoginStates state) {
        this.state = state;
    }
}
