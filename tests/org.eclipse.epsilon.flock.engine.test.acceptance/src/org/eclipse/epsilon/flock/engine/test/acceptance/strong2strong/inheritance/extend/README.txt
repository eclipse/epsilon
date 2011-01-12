Re-use via explicit extends
===========================

Idea:
 o Change Flock's rule matching to ETL semantics (rules match by type, not by kind)
 o Add an extends keyword
 
Thoughts:
 - Must explicitly re-use via extends, which means extra code
 + But this might also imply that re-use need not follow the inheritance hierarchy
   (e.g. migrate Fish extends Mammal, even though Fish doesn't extend Mammal in the metamodel).
 
 - When there is more than one rule defined for the extended type, it's not clear what should happen.
   Some solutions:
    o Named rules
      + explicit
      - verbose
    o Apply the first applicable rule
      + consistent with the rule selection semantics
      - might be hard to understand
   