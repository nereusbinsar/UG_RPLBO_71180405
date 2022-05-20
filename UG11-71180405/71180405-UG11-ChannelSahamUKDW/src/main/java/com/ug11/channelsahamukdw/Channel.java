package com.ug11.channelsahamukdw;

public class Channel {
    private String email, namaDepan, namaBelakang;
    private int totalTag = 0;

    public Channel(String email, String namaDepan, String namaBelakang, int totalTag) {
        setEmail(email);
        setNamaDepan(namaDepan);
        setNamaBelakang(namaBelakang);
        setTotalTag(totalTag);
    }

    public Channel() {}

    public void login(String email){
        try{
            if(!email.contains("@students.ukdw.ac.id")){
                throw new EmailException(404);
            }
            else {
                String[] temp = email.split("@");
                String[] temp1 = temp[0].split("\\.");
                if (temp1.length != 2){
                    throw new EmailException(401);
                } else {
                    setNamaDepan(temp1[0].toUpperCase());
                    setNamaBelakang(temp1[1].toUpperCase());
                    setEmail(email);
                    System.out.println("Login berhasil!");
                }
            }
        }
        catch (EmailException e) {
            System.out.println("Error: " + e.getErrorMessage());
        }
    }

    public void bagikanIde(String ide){
        String temp;
        int jmlTag = 0;

        StringBuilder tag = new StringBuilder();
        String[] arrPesan = ide.split(" ");

        for (String text : arrPesan) {
            if (text.charAt(0) == '#') {
                tag.append(text).append(", ");
                jmlTag += 1;
            }
        }

        if(jmlTag == 0){
            tag.append("-");
            temp = tag.toString();
        }
        else {
            String res = tag.toString();
            temp = res.substring(0, res.length()-2);
        }

        setTotalTag(jmlTag);
        System.out.println("Ide: " + ide);
        System.out.println("Saham Yang Anda Tag: " + temp);
        System.out.println("Total Saham Yang Anda Tag: " + jmlTag);
    }

    public void printInfo(){
        System.out.println("Nama Depan: " + this.namaDepan);
        System.out.println("Nama Belakang: " + this.namaBelakang);
        System.out.println("Email: " + this.email);
        System.out.println("Total Tag: " + this.totalTag);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public int getTotalTag() {
        return totalTag;
    }

    public void setTotalTag(int totalTag) {
        this.totalTag += totalTag;
    }
}
