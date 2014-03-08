package hr.element.spt.lda;

import hr.element.spt.AgeVerificator;
import hr.element.spt.AgeVerificatorFactory;
import hr.element.spt.Country;
import hr.element.spt.lda.impl.LegalDrinkingAgeCountryRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * A singleton factory for creation of legal drinking age verificators.
 */
public enum LegalDrinkingAgeVerificatorFactory
        implements AgeVerificatorFactory {
    INSTANCE;

    private final Map<Country, AgeVerificator> cachedVerificators =
        new HashMap<Country, AgeVerificator>();

    public AgeVerificator getAgeVerificator(final Country country) {
      synchronized (cachedVerificators) {
        final AgeVerificator verificator = cachedVerificators.get(country);
        if (verificator != null) return verificator;

        final AgeVerificator newVerificator =
                LegalDrinkingAgeCountryRepository.createAgeVerifier(country);

        cachedVerificators.put(country, newVerificator);
        return newVerificator;
      }
    }
}
