package hr.element.spt;

public interface AgeVerificatorFactory {
    public AgeVerificator getAgeVerificator(final Country country);
}
