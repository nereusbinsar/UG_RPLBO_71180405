package com.binsar.twitter;

import com.binsar.twitter.exceptions.BioException;
import com.binsar.twitter.exceptions.LoginException;
import com.binsar.twitter.exceptions.TweetException;
import com.binsar.twitter.exceptions.UsernameException;
import com.binsar.twitter.states.BioStates;
import com.binsar.twitter.states.TwitterStates;
import com.binsar.twitter.states.UsernameStates;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.binsar.twitter.states.LoginStates.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int failedLogin = 0;
    private static boolean loginStatus = false;
    private static final User user = new User("u71180405","p71180405");
    private static String username, password, bio, tweet;


    public static void main(String[] args) {
        loginMenu();
        homeMenu();
    }

    private static void loginMenu() {
        do {
            failedLogin++;
            if(failedLogin == 4) {
                System.out.println("Kamu gagal login 3x, program berhenti!");
                break;
            }

            do{
                System.out.print("Username: ");
                username = scanner.nextLine();
                try {
                    if(username.isEmpty()) {
                        throw new LoginException(EMPTY_USERMAME);
                    }
                    else{
                        break;
                    }
                }
                catch (LoginException e) {
                    System.out.println(e.getMessage());
                }
            } while(true);

            do{
                System.out.print("Password: ");
                password = scanner.nextLine();
                try {
                    if(password.isEmpty()) {
                        throw new LoginException(EMPTY_PASSWORD);
                    }
                    else{
                        break;
                    }
                } catch (LoginException e) {
                    System.out.println(e.getMessage());
                }
            } while(true);

            try {
                if(!username.equals(user.getUsername()) || !password.equals(user.getPassword())) {
                    throw new LoginException(WRONG_INPUT);
                }
                else{
                    loginStatus = true;
                    break;
                }
            }
            catch (LoginException e) {
                System.out.println(e.getMessage());
            }
        }while(failedLogin < 4);
    }

    private static void homeMenu(){
        String usernameRegex = "^[A-Za-z]\\w{5,29}$",
                bioRegex = "[^a-zA-Z\\d@. ]";

        if (loginStatus) {
            failedLogin = 0;
            System.out.println("Selamat datang di Twitter, " + user.getUsername());
            System.out.println("Kamu diminta untuk mengganti username, silakan masukan username kamu");
            while(true) {
                System.out.print("Username: ");
                username = scanner.nextLine();
                try {
                    Pattern pattern = Pattern.compile(usernameRegex);
                    Matcher userValidation = pattern.matcher(username);
                    if(username.isEmpty()) {
                        throw new UsernameException(UsernameStates.EMPTY);
                    }
                    else if(username.length() < 6) {
                        throw new UsernameException(UsernameStates.LENGTH_EXCEPTION);
                    }
                    else if(!userValidation.matches()) {
                        throw new UsernameException(UsernameStates.MINIMUM_REQUIREMENT);
                    }
                    else{
                        user.setUsername(username);
                        System.out.println("Username kamu berhasil diperbaharui, " + user.getUsername() + "!");
                        break;
                    }
                }
                catch (UsernameException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Maaf, " + user.getUsername() + " kamu juga diminta untuk mengisi bio, silakan masukan bio kamu");
            while(true) {
                System.out.print("Bio: ");
                bio = scanner.nextLine();
                try {
                    Pattern pattern = Pattern.compile(bioRegex);
                    Matcher valid = pattern.matcher(bio);
                    if(bio.isEmpty()) {
                        throw new BioException(BioStates.EMPTY);
                    }
                    else if(bio.length() < 5 || bio.length() > 30) {
                        throw new BioException(BioStates.LENGTH_EXCEPTION);
                    }
                    else if(valid.find()) {
                        throw new BioException(BioStates.MINIMUM_REQUIREMENT);
                    }
                    else{
                        user.setBio(bio);
                        System.out.println("Bio kamu berhasil diperbaharui, " + user.getBio() + "!");
                        break;
                    }
                }
                catch (BioException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Selamat, " + user.getUsername() + " kamu sudah dapat memposting tweet pertama kamu");
            while(true) {
                System.out.print("Tweet: ");
                tweet = scanner.nextLine();
                try {
                    if(tweet.isEmpty()) {
                        throw new TweetException(TwitterStates.EMPTY);
                    }
                    else if(tweet.length() < 8 || tweet.length() > 140) {
                        throw new TweetException(TwitterStates.LENGTH_EXCEPTION);
                    }
                    else{
                        System.out.println("@" + user.getUsername() + ": " + tweet);
                        break;
                    }
                }
                catch (TweetException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("\n");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Bio: " + user.getBio());
        }
    }
}
