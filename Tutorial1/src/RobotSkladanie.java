import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RobotSkladanie extends RobotFabryczny implements PorozumieniePlus {
    private int limit;

    public RobotSkladanie(String nazwa, SztucznaInteligencja si) {
        super(nazwa, si);
        this.limit = 1 + new Random().nextInt(10);
    }

    @Override
    public void meldunek() {
        long years = ChronoUnit.YEARS.between(super.getDataProdukcji(), LocalDate.now());
        System.out.println("Robot składania " + super.getNazwa() + " żyje od " + years + " lat, może wykonać " + (limit - super.getIleZadan()) + " więcej zadań.");
    }

    @Override
    public void powitanie() {
        System.out.println(super.getNazwa() + " o numerze fabrycznym " + super.getNrFabryczny() + " mówi: Witaj!");
    }
}
