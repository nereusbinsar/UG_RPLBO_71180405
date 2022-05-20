package com.ug11.channelsahamukdw;

public class Main {
    public static void main(String[] args) throws EmailException {
        Channel channel = new Channel();
        System.out.println("----------Skenario 1: Login Gagal----------");
        channel.login("albertusadrian@gmail.com");
        channel.login("angelrumuy@students.ukdw.ac.id");
        System.out.println("\n----------Skenario 2: Login Berhasil----------");
        channel.login("albertus.adrian@students.ukdw.ac.id");
        System.out.println("\n----------Skenario 3: Membagikan Ide Tanpa Tag Saham----------");
        channel.bagikanIde("Market sedang crash ya");
        System.out.println("\n----------Skenario 4: Membagikan Ide Tanpa Tag Saham #1----------");
        channel.bagikanIde("#ISAT saat ini sedang menguji area resistance. Di sisi lain #TLKM sudah berhasil rebound");
        System.out.println("\n----------Skenario 5: Membagikan Ide Tanpa Tag Saham #2----------");
        channel.bagikanIde("#BBCA #BBNI saat ini memiliki potensi untuk rebound diikuti dengan saham #BMRI");
        System.out.println("\n----------Skenario Final: Print Informasi Akun----------");
        channel.printInfo();
    }
}