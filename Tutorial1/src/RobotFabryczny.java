import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public abstract class RobotFabryczny extends Robot {
    public enum Zadanie {
        SKRAWANIE(1), ZGRZEWANIE(2), MODELOWANIE(3), PODNOSNIK(4), LAKIEROWANIE(5), SKLEJANIE(6);

        private final int numerZadania;

        Zadanie(int numerZadania) {
            this.numerZadania = numerZadania;
        }

        public int getNumerZadania() {
            return numerZadania;
        }
    }

    protected Zadanie zadanie;

    public RobotFabryczny(String nazwa, SztucznaInteligencja si) {
        super(nazwa, si);
        this.zadanie = Zadanie.values()[new Random().nextInt(Zadanie.values().length)];
    }

    @Override
    public void meldunek() {
        long years = ChronoUnit.YEARS.between(super.getDataProdukcji(), LocalDate.now());
        System.out.println("Robot fabryczny " + super.getNazwa() + " żyje od " + years + " lat, zadanie: " + zadanie);
    }
}
