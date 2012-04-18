Re-use via firing more than one rule per type
=============================================

Idea:
 o Every applicable rule fires for each source model element
 o Target types (i.e. retypings) are determined from a new language construct (not from rules)
 
Thoughts:
  + Less code than extends when migration applies to all subtypes
  - Extra code needed when some subtypes must not be migrated with logic for supertype
    o Might be slightly less confusing if there was an "unless:" equivalent to "when: not"
  
  + Introduction of extra construct separates two concerns (migration logic and retyping)

  - In what order should rules run? Some possible solutions
    o The order they appear?
      + Consistent with current rule selection semantics
      + Gives user some control
      - Might be counter-intuitive
    o More general rules first
      + Seems intuitive
      - How would we reason about the generality of rules with guards? Seems difficult...