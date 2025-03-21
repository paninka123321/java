import java.time.temporal.ChronoUnit;

public class RobotDomowy extends Robot implements PorozumieniePlus{
    public RobotDomowy(String nazwa, SztucznaInteligencja si) {
        super(nazwa, si);
    }
    public RobotDomowy(String nazwa, SztucznaInteligencja si) {
        super(nazwa, String.valueOf(si));
    }

    @Override
    public void meldunek() {
        long years = ChronoUnit.YEARS.between(super.dataProdukcji, LocalDate.now());
        System.out.println("Robot " + super.nazwa + " żyje od " + years + " lat.");
    }

    @Override
    public void powitanie() {
        System.out.println(super.nazwa + " o numerze fabrycznym " + super.nrFabryczny + " mówi: Witaj!");
    }

}
