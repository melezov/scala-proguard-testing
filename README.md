scala-proguard-testing
======================

Adventures in ProGuarding

age-verification-interface
  - this is a mock of a public (open source) project, describing an interface
  - a Java library interface with only public members in package hr.element.spt
  - it can be ProGuarded to reduce size via its bytecode optimization tricks
  - since these are all public classes and methods, no obfuscation should be performed

legal-drinking-age-implementation
  - this is a mock of a proprietary project, a Scala library implementing the before mentioned interface
  - everything except the interface class / methods is package private [hr.element.spt]
  - when ProGuarded, everything except the method implementing the interface must become obfuscated
  - when assembled for Java, the Scala library should be packaged inside the project
  - when assembled for Scala, only the dependencies for this project (simple-library-interface) should be bundled

usage-example
  - a Java project using the legal-drinking-age-implementation ProGuarded assembly
  - all obfuscated classes like A.class, a.class, B.class, should be private, and not seen by the IDE

