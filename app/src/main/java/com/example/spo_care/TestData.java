package com.example.spo_care;

public class TestData {
    int CAcounter1;
    int CAcounter2;
    int CAcounter3;
    int PDcounter1;
    int PDcounter2;
    int PDcounter3;
    String CAdate1;
    String CAdate2;
    String CAdate3;
    String PDdate1;
    String PDdate2;
    String PDdate3;
    float CAscore1, CAscore2, CAscore3, PDscore1, PDscore2, PDscore3;

    int[] caCountTempArray = new int[3];
    int[] pdCountTempArray = new int[3];
    String[] caDateTempArray = new String[3];
    String[] pdDateTempArray = new String[3];
    float[] caScoreTempArray = new float[3];
    float[] pdScoreTempArray = new float[3];

    public int[] getCaCounterArray() {
        caCountTempArray[0] = CAcounter1;
        caCountTempArray[1] = CAcounter2;
        caCountTempArray[2] = CAcounter3;

        return caCountTempArray;
    }

    public int[] getPdCounterArray() {
        pdCountTempArray[0] = PDcounter1;
        pdCountTempArray[1] = PDcounter2;
        pdCountTempArray[2] = PDcounter3;

        return pdCountTempArray;
    }

    public String[] getCaDateTempArray() {
        caDateTempArray[0] = CAdate1;
        caDateTempArray[1] = CAdate2;
        caDateTempArray[2] = CAdate3;

        return caDateTempArray;
    }

    public String[] getpdDateTempArray() {
        pdDateTempArray[0] = PDdate1;
        pdDateTempArray[1] = PDdate2;
        pdDateTempArray[2] = PDdate3;

        return pdDateTempArray;
    }

    public float[] getCaScoreTempArray(){
        caScoreTempArray[0] = CAscore1;
        caScoreTempArray[1] = CAscore2;
        caScoreTempArray[2] = CAscore3;

        return caScoreTempArray;
    }

    public float[] getPdScoreTempArray(){
        pdScoreTempArray[0] = PDscore1;
        pdScoreTempArray[1] = PDscore2;
        pdScoreTempArray[2] = PDscore3;

        return pdScoreTempArray;
    }


    public int getPDcounter1() {
        return PDcounter1;
    }

    public void setPDcounter1(int PDcounter1) {
        this.PDcounter1 = PDcounter1;
    }

    public int getPDcounter2() {
        return PDcounter2;
    }

    public void setPDcounter2(int PDcounter2) {
        this.PDcounter2 = PDcounter2;
    }

    public int getPDcounter3() {
        return PDcounter3;
    }

    public void setPDcounter3(int PDcounter3) {
        this.PDcounter3 = PDcounter3;
    }

    public String getCAdate1() {
        return CAdate1;
    }

    public void setCAdate1(String CAdate1) {
        this.CAdate1 = CAdate1;
    }

    public String getCAdate2() {
        return CAdate2;
    }

    public void setCAdate2(String CAdate2) {
        this.CAdate2 = CAdate2;
    }

    public String getCAdate3() {
        return CAdate3;
    }

    public void setCAdate3(String CAdate3) {
        this.CAdate3 = CAdate3;
    }

    public String getPDdate1() {
        return PDdate1;
    }

    public void setPDdate1(String PDdate1) {
        this.PDdate1 = PDdate1;
    }

    public String getPDdate2() {
        return PDdate2;
    }

    public void setPDdate2(String PDdate2) {
        this.PDdate2 = PDdate2;
    }

    public String getPDdate3() {
        return PDdate3;
    }

    public void setPDdate3(String PDdate3) {
        this.PDdate3 = PDdate3;
    }

    public float getCAscore1() {
        return CAscore1;
    }

    public void setCAscore1(float CAscore1) {
        this.CAscore1 = CAscore1;
    }

    public float getCAscore2() {
        return CAscore2;
    }

    public void setCAscore2(float CAscore2) {
        this.CAscore2 =  CAscore2;
    }

    public float getCAscore3() {
        return CAscore3;
    }

    public void setCAscore3(float CAscore3) {
        this.CAscore3 = CAscore3;
    }

    public float getPDscore1() {
        return PDscore1;
    }

    public void setPDscore1(float PDscore1) {
        this.PDscore1 = PDscore1;
    }

    public float getPDscore2() {
        return PDscore2;
    }

    public void setPDscore2(float PDscore2) {
        this.PDscore2 = PDscore2;
    }

    public float getPDscore3() {
        return PDscore3;
    }

    public void setPDscore3(float PDscore3) {
        this.PDscore3 = PDscore3;
    }


    public int getCAcounter1() {
        return CAcounter1;
    }

    public void setCAcounter1(int CAcounter1) {
        this.CAcounter1 = CAcounter1;
    }

    public int getCAcounter2() {
        return CAcounter2;
    }

    public void setCAcounter2(int CAcounter2) {
        this.CAcounter2 = CAcounter2;
    }
    public int getCAcounter3() {
        return CAcounter3;
    }

    public void setCAcounter3(int CAcounter3) {
        this.CAcounter3 = CAcounter3;
    }
}
