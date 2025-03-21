public class SztucznaInteligencja {
    private String reprezentacjaDanych;

    public SztucznaInteligencja(String reprezentacjaDanych) {
        this.reprezentacjaDanych = reprezentacjaDanych;
    }

    public String getReprezentacjaDanych() {
        return reprezentacjaDanych;
    }

    @Override
    public String toString() {
        return "SztucznaInteligencja{" + "reprezentacjaDanych='" + reprezentacjaDanych + '\'' + '}';
    }
}