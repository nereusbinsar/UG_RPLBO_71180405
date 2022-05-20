package com.ug11.kalkulasipersentase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double persentase = 0;

        System.out.print("Masukan teks: ");
        String input = scanner.nextLine();
        String[] tempSaham = input.split(" ");
        StringBuilder konstruksiText = new StringBuilder("Rincian perhitungan: ");


        for(int i = 0; i < tempSaham.length; i++){
            if(tempSaham[i].contains("%")){
                String tempAngka = tempSaham[i].substring(0,tempSaham[i].length()-1);
                konstruksiText.append(tempSaham[i]).append(" + ");
                persentase += Double.parseDouble(tempAngka);
            }
        }

        String output = konstruksiText.toString();
        String rincian = output.substring(0,output.length()-3);
        System.out.println(rincian);
        System.out.println("Total kenaikan (Dalam Persen): " + persentase + "%");
    }
}