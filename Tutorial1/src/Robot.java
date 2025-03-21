import java.time.LocalDate;
import java.util.Random;

public abstract class Robot implements Porozumienie{
    private LocalDate dataProdukcji;
    private int rokProdukcji;
    private int dzienProdukcji;
    String imie[] = {"Adam1000", "Roman2", "Aleks900", "Zosia Samosia", "Ala2", "Ula"};
    private String nazwa;
    private int ileZadan;
    SztucznaInteligencja si;
    private final String identyfikator;
    private static int licznikNrFabryczny = 1;
    private final int nrFabryczny;

    // use constructor to choose random date always the new Robot is created
    public Robot(String nazwa, SztucznaInteligencja si) {
        Random random = new Random();
        this.rokProdukcji = random.nextInt(22) + 2000;
        this.dzienProdukcji = random.nextInt(LocalDate.of(rokProdukcji, 12, 31).getDayOfYear()) + 1;
        this.dataProdukcji = LocalDate.ofYearDay(rokProdukcji, dzienProdukcji);
        this.ileZadan = 0;
        this.nazwa = wybierzNazwe(nazwa);
        this.identyfikator = generujIdentyfikator();
        this.nrFabryczny = licznikNrFabryczny++;
        this.si = si;
    }



    public LocalDate getDataProdukcji() {
        return dataProdukcji;
    }

    public String wybierzNazwe(String nazwa) {
        for (int i = 0; i < imie.length; i++) {
            if (nazwa == imie[i]) {
                return nazwa;
            }
        }
        return imie[new Random().nextInt(imie.length)];
    }

    private String generujIdentyfikator() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append((char) (random.nextInt(26) + 'A'));
        }
        return sb.toString();

    }
    public void wykonajZadanie() {
        Random rand = new Random();
        int randomTasks = 1 + rand.nextInt(20);
        ileZadan+= randomTasks;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIleZadan() {
        return ileZadan;
    }

    public String getIdentyfikator() {
        return identyfikator;
    }

    public int getNrFabryczny() {
        return nrFabryczny;
    }

    public SztucznaInteligencja getSi() {
        return si;
    }
    public abstract void meldunek(); // Robot musi zaimplementować meldunek
    @Override
    public String toString() {
        return "Robot{" +
                "dataProdukcji=" + dataProdukcji +
                ", nazwa='" + nazwa + '\'' +
                ", identyfikator='" + identyfikator + '\'' +
                ", ileZadan=" + ileZadan +
                ", nrFabryczny='" + nrFabryczny + '\'' +
                '}';
    }

    // Equals porównuje roboty po identyfikatorze
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Robot robot = (Robot) obj;
        return identyfikator.equals(robot.identyfikator);
    }
}
