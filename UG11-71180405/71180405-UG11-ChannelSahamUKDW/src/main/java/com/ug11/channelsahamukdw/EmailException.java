package com.ug11.channelsahamukdw;

public class EmailException extends Exception{
    private String errorMessage;
    private int errorCode;

    public EmailException(int errorCode) {
        setErrorCode(errorCode);

        //Pengecekan input kode error
        if(getErrorCode() == 404){
            setErrorMessage("Login gagal! Email Anda tidak terdaftar dalam UKDW.");
        }
        else if(getErrorCode() == 401){
            setErrorMessage("Login gagal! Email UKDW Anda tidak valid.");
        }
    }



    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
