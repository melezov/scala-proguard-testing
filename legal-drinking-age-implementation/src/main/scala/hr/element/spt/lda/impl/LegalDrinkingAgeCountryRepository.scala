package hr.element.spt
package lda
package impl

private [impl] object NoAgeVerification
    extends AgeVerificator {
  def isUnderage(age: Int) = false
}

private [impl] class ThresholdAgeVerification(threshold: Int)
    extends AgeVerificator {
  def isUnderage(age: Int) = {
    require(age >= 0, s"Invalid age was provided ($age), it must be a positive integer")
    age < threshold
  }
}

/**
 * A mock implementation of a countries legal drinking age limits,
 *  for the purposes of a reasonably complete implementation.
 */
private[lda] object LegalDrinkingAgeCountryRepository {
  def createAgeVerifier(country: Country) =
    country match {
      case Country.CU | Country.NO =>
        NoAgeVerification

      case Country.BA | Country.IT =>
        new ThresholdAgeVerification(16)

      case Country.CY | Country.MT =>
        new ThresholdAgeVerification(17)

      case Country.GB | Country.HR | Country.NZ | Country.RU =>
        new ThresholdAgeVerification(18)

      case Country.KR | Country.NI =>
        new ThresholdAgeVerification(19)

      case Country.IS | Country.JP | Country.PY =>
        new ThresholdAgeVerification(20)

      case Country.KZ | Country.LK | Country.US =>
        new ThresholdAgeVerification(21)
    }
}
