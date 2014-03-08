scala-proguard-testing
======================

Adventures in ProGuarding

age-verificator-interface
  - this is a mock of a public (open source) project
  - a Java library interface with a singular public members in package hr.element.spt
  - it can be ProGuarded to reduce size via its bytecode optimization tricks
  - since this is a public class and method, no obfuscation should be performed

legal-drinking-age-implementation
  - this is a mock of a proprietary project, a Scala library using the before mentioned interface
  - everything except the public interface in hr.element.spt.lda should be package private
  - when ProGuarded, all non-public classes and methods must become obfuscated
  - when assembled for Java, the Scala library should be packaged inside the project
  - when assembled for Scala, only the dependencies for this project (simple-library-interface) should be bundled

usage-example
  - a Java project using the legal-drinking-age-implementation ProGuarded assembly
  - all obfuscated classes like A.class, a.class, B.class, should be private, and not seen by the IDE
