package hr.element.example;

import hr.element.spt.AgeVerificatorFactory;
import hr.element.spt.Country;
import hr.element.spt.lda.LegalDrinkingAgeVerificatorFactory;

public class YouthAlchocolismPrevention {
    private final AgeVerificatorFactory ageVerificationFactory;

    public YouthAlchocolismPrevention() {
        ageVerificationFactory = LegalDrinkingAgeVerificatorFactory.INSTANCE;
    }

    public boolean isLegalToDrink(final Country country, final int age) {
        return !ageVerificationFactory.getAgeVerificator(country).isUnderage(age);
    }

    public static Country parseCountry(final String arg) {
        try {
            return Country.valueOf(arg.toUpperCase());
        }
        catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException("Unsupported country code: " + arg, e);
        }
    }

    public static int parseAge(final String arg) {
      try {
          final int age = Integer.parseInt(arg);
          if (age < 0) throw new IllegalArgumentException("Age cannot be negative, but got: " + arg);
          return age;
      }
      catch (final NumberFormatException e) {
          throw new IllegalArgumentException("Age sould be a positive integer, but got: " + arg, e);
      }
    }

    public static void main(final String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar YouthAlchocolismPrevention.jar [country-code] [age]");
            System.out.println();
            System.out.println("Supported countries:");
            for (final Country country : Country.values()) {
              System.out.println(String.format("  %s (%s)", country.name(), country.countryName));
            }
            System.exit(1);
        }

        try {
            final Country country = parseCountry(args[0]);
            final int age = parseAge(args[1]);

            final YouthAlchocolismPrevention yap = new YouthAlchocolismPrevention();
            if (yap.isLegalToDrink(country, age)) {
                System.out.println("It is perfectly legal to drink at " + age + " in " + country.countryName + "! (IANAL, TINLA)");
                System.exit(0);
            }
            else {
                System.out.println("It is _NOT_ legal to drink at " + age + " in " + country.countryName + "! (IANAL, TINLA)");
                System.exit(0);
            }
        }
        catch (final Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
