// Generated source.
package org.hamcrest;

public class Matchers {

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth, org.hamcrest.Matcher<? super T> sixth) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third, fourth, fifth, sixth);
  }

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third, fourth);
  }

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third, fourth, fifth);
  }

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(java.lang.Iterable<org.hamcrest.Matcher<? super T>> matchers) {
    return org.hamcrest.core.AllOf.<T>allOf(matchers);
  }

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<? super T>... matchers) {
    return org.hamcrest.core.AllOf.<T>allOf(matchers);
  }

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second);
  }

  /**
   * Evaluates to true only if ALL of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.Matcher<T> allOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third) {
    return org.hamcrest.core.AllOf.<T>allOf(first, second, third);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth, org.hamcrest.Matcher<? super T> sixth) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third, fourth, fifth, sixth);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third, fourth);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third, org.hamcrest.Matcher<? super T> fourth, org.hamcrest.Matcher<? super T> fifth) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third, fourth, fifth);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(java.lang.Iterable<org.hamcrest.Matcher<? super T>> matchers) {
    return org.hamcrest.core.AnyOf.<T>anyOf(matchers);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<? super T>... matchers) {
    return org.hamcrest.core.AnyOf.<T>anyOf(matchers);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second);
  }

  /**
   * Evaluates to true if ANY of the passed in matchers evaluate to true.
   */
  public static <T> org.hamcrest.core.AnyOf<T> anyOf(org.hamcrest.Matcher<T> first, org.hamcrest.Matcher<? super T> second, org.hamcrest.Matcher<? super T> third) {
    return org.hamcrest.core.AnyOf.<T>anyOf(first, second, third);
  }

  /**
   * This is useful for fluently combining matchers that must both pass. For example:
   * <pre>
   * assertThat(string, both(containsString("a")).and(containsString("b")));
   * </pre>
   */
  public static <LHS> org.hamcrest.core.CombinableMatcher<LHS> both(org.hamcrest.Matcher<? super LHS> matcher) {
    return org.hamcrest.core.CombinableMatcher.<LHS>both(matcher);
  }

  /**
   * This is useful for fluently combining matchers where either may pass, for example:
   * <pre>
   * assertThat(string, both(containsString("a")).and(containsString("b")));
   * </pre>
   */
  public static <LHS> org.hamcrest.core.CombinableMatcher<LHS> either(org.hamcrest.Matcher<? super LHS> matcher) {
    return org.hamcrest.core.CombinableMatcher.<LHS>either(matcher);
  }

  /**
   * Wraps an existing matcher and overrides the description when it fails.
   */
  public static <T> org.hamcrest.Matcher<T> describedAs(java.lang.String description, org.hamcrest.Matcher<T> matcher, java.lang.Object... values) {
    return org.hamcrest.core.DescribedAs.<T>describedAs(description, matcher, values);
  }

  /**
   * 
   * 
   * @param itemMatcher A matcher to apply to every element in a collection.
   * @return Evaluates to TRUE for a collection in which every item matches itemMatcher
   */
  public static <U> org.hamcrest.Matcher<java.lang.Iterable<U>> everyItem(org.hamcrest.Matcher<U> itemMatcher) {
    return org.hamcrest.core.Every.<U>everyItem(itemMatcher);
  }

  /**
   * Decorates another Matcher, retaining the behavior but allowing tests
   * to be slightly more expressive.
   * 
   * For example: assertThat(cheese, equalTo(smelly))
   * vs. assertThat(cheese, is(equalTo(smelly)))
   */
  public static <T> org.hamcrest.Matcher<T> is(org.hamcrest.Matcher<T> matcher) {
    return org.hamcrest.core.Is.<T>is(matcher);
  }

  /**
   * This is a shortcut to the frequently used is(equalTo(x)).
   * 
   * For example: assertThat(cheese, is(equalTo(smelly)))
   * vs. assertThat(cheese, is(smelly))
   */
  public static <T> org.hamcrest.Matcher<? super T> is(T value) {
    return org.hamcrest.core.Is.<T>is(value);
  }

  /**
   * This is a shortcut to the frequently used is(instanceOf(SomeClass.class)).
   * 
   * For example: assertThat(cheese, is(instanceOf(Cheddar.class)))
   * vs. assertThat(cheese, is(Cheddar.class))
   */
  public static <T> org.hamcrest.Matcher<? super T> is(java.lang.Class<T> type) {
    return org.hamcrest.core.Is.<T>is(type);
  }

  /**
   * This matcher always evaluates to true.
   */
  public static <T> org.hamcrest.Matcher<T> anything() {
    return org.hamcrest.core.IsAnything.<T>anything();
  }

  /**
   * This matcher always evaluates to true.
   * 
   * @param description A meaningful string used when describing itself.
   */
  public static <T> org.hamcrest.Matcher<T> anything(java.lang.String description) {
    return org.hamcrest.core.IsAnything.<T>anything(description);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<? super T>> hasItem(T element) {
    return org.hamcrest.core.IsCollectionContaining.<T>hasItem(element);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<? super T>> hasItem(org.hamcrest.Matcher<? super T> elementMatcher) {
    return org.hamcrest.core.IsCollectionContaining.<T>hasItem(elementMatcher);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<T>> hasItems(org.hamcrest.Matcher<? super T>... elementMatchers) {
    return org.hamcrest.core.IsCollectionContaining.<T>hasItems(elementMatchers);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<T>> hasItems(T... elements) {
    return org.hamcrest.core.IsCollectionContaining.<T>hasItems(elements);
  }

  /**
   * Is the value equal to another value, as tested by the
   * {@link java.lang.Object#equals} invokedMethod?
   */
  public static <T> org.hamcrest.Matcher<? super T> equalTo(T operand) {
    return org.hamcrest.core.IsEqual.<T>equalTo(operand);
  }

  /**
   * Is the value an instance of a particular type?
   * This version assumes no relationship between the required type and
   * the signature of the method that sets it up, for example in
   * <code>assertThat(anObject, instanceOf(Thing.class));</code>
   */
  public static <T> org.hamcrest.Matcher<T> instanceOf(java.lang.Class<?> type) {
    return org.hamcrest.core.IsInstanceOf.<T>instanceOf(type);
  }

  /**
   * Is the value an instance of a particular type?
   * Use this version to make generics conform, for example in
   * the JMock clause <code>with(any(Thing.class))</code>
   */
  public static <T> org.hamcrest.Matcher<T> any(java.lang.Class<T> type) {
    return org.hamcrest.core.IsInstanceOf.<T>any(type);
  }

  /**
   * Inverts the rule.
   */
  public static <T> org.hamcrest.Matcher<T> not(org.hamcrest.Matcher<T> matcher) {
    return org.hamcrest.core.IsNot.<T>not(matcher);
  }

  /**
   * This is a shortcut to the frequently used not(equalTo(x)).
   * 
   * For example: assertThat(cheese, is(not(equalTo(smelly))))
   * vs. assertThat(cheese, is(not(smelly)))
   */
  public static <T> org.hamcrest.Matcher<? super T> not(T value) {
    return org.hamcrest.core.IsNot.<T>not(value);
  }

  /**
   * Matches if value is null.
   */
  public static <T> org.hamcrest.Matcher<T> nullValue() {
    return org.hamcrest.core.IsNull.<T>nullValue();
  }

  /**
   * Matches if value is null. With type inference.
   */
  public static <T> org.hamcrest.Matcher<T> nullValue(java.lang.Class<T> type) {
    return org.hamcrest.core.IsNull.<T>nullValue(type);
  }

  /**
   * Matches if value is not null.
   */
  public static <T> org.hamcrest.Matcher<T> notNullValue() {
    return org.hamcrest.core.IsNull.<T>notNullValue();
  }

  /**
   * Matches if value is not null. With type inference.
   */
  public static <T> org.hamcrest.Matcher<T> notNullValue(java.lang.Class<T> type) {
    return org.hamcrest.core.IsNull.<T>notNullValue(type);
  }

  /**
   * Creates a new instance of IsSame
   * 
   * @param object The predicate evaluates to true only when the argument is
   * this object.
   */
  public static <T> org.hamcrest.Matcher<T> sameInstance(T object) {
    return org.hamcrest.core.IsSame.<T>sameInstance(object);
  }

  public static org.hamcrest.Matcher<java.lang.String> containsString(java.lang.String substring) {
    return org.hamcrest.core.StringContains.containsString(substring);
  }

  public static org.hamcrest.Matcher<java.lang.String> startsWith(java.lang.String substring) {
    return org.hamcrest.core.StringStartsWith.startsWith(substring);
  }

  public static org.hamcrest.Matcher<java.lang.String> endsWith(java.lang.String substring) {
    return org.hamcrest.core.StringEndsWith.endsWith(substring);
  }

  /**
   * Evaluates to true only if each matcher[i] is satisfied by array[i].
   */
  public static <T> org.hamcrest.collection.IsArray<T> array(org.hamcrest.Matcher<? super T>... elementMatchers) {
    return org.hamcrest.collection.IsArray.<T>array(elementMatchers);
  }

  /**
   * Evaluates to true if any item in an array satisfies the given matcher.
   */
  public static <T> org.hamcrest.Matcher<T[]> hasItemInArray(org.hamcrest.Matcher<? super T> elementMatcher) {
    return org.hamcrest.collection.IsArrayContaining.<T>hasItemInArray(elementMatcher);
  }

  /**
   * This is a shortcut to the frequently used hasItemInArray(equalTo(x)).
   * 
   * For example, assertThat(hasItemInArray(equal_to(x)))
   * vs. assertThat(hasItemInArray(x))
   */
  public static <T> org.hamcrest.Matcher<T[]> hasItemInArray(T element) {
    return org.hamcrest.collection.IsArrayContaining.<T>hasItemInArray(element);
  }

  public static <E> org.hamcrest.Matcher<E[]> arrayContaining(E... items) {
    return org.hamcrest.collection.IsArrayContainingInOrder.<E>arrayContaining(items);
  }

  public static <E> org.hamcrest.Matcher<E[]> arrayContaining(org.hamcrest.Matcher<? super E>... matchers) {
    return org.hamcrest.collection.IsArrayContainingInOrder.<E>arrayContaining(matchers);
  }

  public static <E> org.hamcrest.Matcher<E[]> arrayContaining(java.util.List<org.hamcrest.Matcher<? super E>> matchers) {
    return org.hamcrest.collection.IsArrayContainingInOrder.<E>arrayContaining(matchers);
  }

  public static <E> org.hamcrest.Matcher<E[]> arrayContainingInAnyOrder(org.hamcrest.Matcher<? super E>... matchers) {
    return org.hamcrest.collection.IsArrayContainingInAnyOrder.<E>arrayContainingInAnyOrder(matchers);
  }

  public static <E> org.hamcrest.Matcher<E[]> arrayContainingInAnyOrder(java.util.Collection<org.hamcrest.Matcher<? super E>> matchers) {
    return org.hamcrest.collection.IsArrayContainingInAnyOrder.<E>arrayContainingInAnyOrder(matchers);
  }

  public static <E> org.hamcrest.Matcher<E[]> arrayContainingInAnyOrder(E... items) {
    return org.hamcrest.collection.IsArrayContainingInAnyOrder.<E>arrayContainingInAnyOrder(items);
  }

  /**
   * Does array size satisfy a given matcher?
   */
  public static <E> org.hamcrest.Matcher<E[]> arrayWithSize(org.hamcrest.Matcher<? super java.lang.Integer> sizeMatcher) {
    return org.hamcrest.collection.IsArrayWithSize.<E>arrayWithSize(sizeMatcher);
  }

  /**
   * This is a shortcut to the frequently used arrayWithSize(equalTo(x)).
   * 
   * For example, assertThat(arrayWithSize(equal_to(x)))
   * vs. assertThat(arrayWithSize(x))
   */
  public static <E> org.hamcrest.Matcher<E[]> arrayWithSize(int size) {
    return org.hamcrest.collection.IsArrayWithSize.<E>arrayWithSize(size);
  }

  /**
   * Matches an empty array.
   */
  public static <E> org.hamcrest.Matcher<E[]> emptyArray() {
    return org.hamcrest.collection.IsArrayWithSize.<E>emptyArray();
  }

  /**
   * Does collection size satisfy a given matcher?
   */
  public static <E> org.hamcrest.Matcher<? super java.util.Collection<? extends E>> hasSize(org.hamcrest.Matcher<? super java.lang.Integer> size) {
    return org.hamcrest.collection.IsCollectionWithSize.<E>hasSize(size);
  }

  /**
   * This is a shortcut to the frequently used hasSize(equalTo(x)).
   * 
   * For example, assertThat(hasSize(equal_to(x)))
   * vs. assertThat(hasSize(x))
   */
  public static <E> org.hamcrest.Matcher<? super java.util.Collection<? extends E>> hasSize(int size) {
    return org.hamcrest.collection.IsCollectionWithSize.<E>hasSize(size);
  }

  /**
   * Matches an empty collection.
   */
  public static <E> org.hamcrest.Matcher<java.util.Collection<E>> empty() {
    return org.hamcrest.collection.IsEmptyCollection.<E>empty();
  }

  /**
   * Matches an empty iterable.
   */
  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> emptyIterable() {
    return org.hamcrest.collection.IsEmptyIterable.<E>emptyIterable();
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> contains(org.hamcrest.Matcher<E> item) {
    return org.hamcrest.collection.IsIterableContainingInOrder.<E>contains(item);
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> contains(org.hamcrest.Matcher<? super E>... item) {
    return org.hamcrest.collection.IsIterableContainingInOrder.<E>contains(item);
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> contains(java.util.List<org.hamcrest.Matcher<? super E>> contents) {
    return org.hamcrest.collection.IsIterableContainingInOrder.<E>contains(contents);
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> contains(E... items) {
    return org.hamcrest.collection.IsIterableContainingInOrder.<E>contains(items);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<T>> containsInAnyOrder(java.util.Collection<org.hamcrest.Matcher<? super T>> matchers) {
    return org.hamcrest.collection.IsIterableContainingInAnyOrder.<T>containsInAnyOrder(matchers);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<T>> containsInAnyOrder(org.hamcrest.Matcher<? super T>... item) {
    return org.hamcrest.collection.IsIterableContainingInAnyOrder.<T>containsInAnyOrder(item);
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> containsInAnyOrder(org.hamcrest.Matcher<E> item) {
    return org.hamcrest.collection.IsIterableContainingInAnyOrder.<E>containsInAnyOrder(item);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Iterable<T>> containsInAnyOrder(T... items) {
    return org.hamcrest.collection.IsIterableContainingInAnyOrder.<T>containsInAnyOrder(items);
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> iterableWithSize(org.hamcrest.Matcher<? super java.lang.Integer> sizeMatcher) {
    return org.hamcrest.collection.IsIterableWithSize.<E>iterableWithSize(sizeMatcher);
  }

  public static <E> org.hamcrest.Matcher<java.lang.Iterable<E>> iterableWithSize(int size) {
    return org.hamcrest.collection.IsIterableWithSize.<E>iterableWithSize(size);
  }

  public static <K, V> org.hamcrest.Matcher<java.util.Map<? extends K, ? extends V>> hasEntry(org.hamcrest.Matcher<? super K> keyMatcher, org.hamcrest.Matcher<? super V> valueMatcher) {
    return org.hamcrest.collection.IsMapContaining.<K,V>hasEntry(keyMatcher, valueMatcher);
  }

  public static <K, V> org.hamcrest.Matcher<java.util.Map<? extends K, ? extends V>> hasEntry(K key, V value) {
    return org.hamcrest.collection.IsMapContaining.<K,V>hasEntry(key, value);
  }

  public static <K> org.hamcrest.Matcher<java.util.Map<? super K, ?>> hasKey(K key) {
    return org.hamcrest.collection.IsMapContainingKey.<K>hasKey(key);
  }

  public static <K> org.hamcrest.Matcher<java.util.Map<? super K, ?>> hasKey(org.hamcrest.Matcher<? super K> keyMatcher) {
    return org.hamcrest.collection.IsMapContainingKey.<K>hasKey(keyMatcher);
  }

  public static <V> org.hamcrest.Matcher<? super java.util.Map<?, V>> hasValue(V value) {
    return org.hamcrest.collection.IsMapContainingValue.<V>hasValue(value);
  }

  public static <V> org.hamcrest.Matcher<? super java.util.Map<?, V>> hasValue(org.hamcrest.Matcher<? super V> valueMatcher) {
    return org.hamcrest.collection.IsMapContainingValue.<V>hasValue(valueMatcher);
  }

  public static <T> org.hamcrest.Matcher<T> isIn(java.util.Collection<T> collection) {
    return org.hamcrest.collection.IsIn.<T>isIn(collection);
  }

  public static <T> org.hamcrest.Matcher<T> isIn(T[] param1) {
    return org.hamcrest.collection.IsIn.<T>isIn(param1);
  }

  public static <T> org.hamcrest.Matcher<T> isOneOf(T... elements) {
    return org.hamcrest.collection.IsIn.<T>isOneOf(elements);
  }

  public static org.hamcrest.Matcher<java.lang.Double> closeTo(double operand, double error) {
    return org.hamcrest.number.IsCloseTo.closeTo(operand, error);
  }

  /**
   * Is value = expected?
   */
  public static <T extends java.lang.Comparable<T>> org.hamcrest.Matcher<? super T> comparesEqualTo(T value) {
    return org.hamcrest.number.OrderingComparison.<T>comparesEqualTo(value);
  }

  /**
   * Is value > expected?
   */
  public static <T extends java.lang.Comparable<T>> org.hamcrest.Matcher<? super T> greaterThan(T value) {
    return org.hamcrest.number.OrderingComparison.<T>greaterThan(value);
  }

  /**
   * Is value >= expected?
   */
  public static <T extends java.lang.Comparable<T>> org.hamcrest.Matcher<? super T> greaterThanOrEqualTo(T value) {
    return org.hamcrest.number.OrderingComparison.<T>greaterThanOrEqualTo(value);
  }

  /**
   * Is value < expected?
   */
  public static <T extends java.lang.Comparable<T>> org.hamcrest.Matcher<? super T> lessThan(T value) {
    return org.hamcrest.number.OrderingComparison.<T>lessThan(value);
  }

  /**
   * Is value <= expected?
   */
  public static <T extends java.lang.Comparable<T>> org.hamcrest.Matcher<? super T> lessThanOrEqualTo(T value) {
    return org.hamcrest.number.OrderingComparison.<T>lessThanOrEqualTo(value);
  }

  public static org.hamcrest.Matcher<java.lang.String> equalToIgnoringCase(java.lang.String string) {
    return org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase(string);
  }

  public static org.hamcrest.Matcher<java.lang.String> equalToIgnoringWhiteSpace(java.lang.String string) {
    return org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace(string);
  }

  /**
   * Evaluates whether item.toString() satisfies a given matcher.
   */
  public static <T> org.hamcrest.Matcher<T> hasToString(org.hamcrest.Matcher<? super java.lang.String> toStringMatcher) {
    return org.hamcrest.object.HasToString.<T>hasToString(toStringMatcher);
  }

  /**
   * This is a shortcut to the frequently used has_string(equalTo(x)).
   * 
   * For example, assertThat(hasToString(equal_to(x)))
   * vs. assertThat(hasToString(x))
   */
  public static <T> org.hamcrest.Matcher<T> hasToString(java.lang.String expectedToString) {
    return org.hamcrest.object.HasToString.<T>hasToString(expectedToString);
  }

  public static <T> org.hamcrest.Matcher<java.lang.Class<?>> typeCompatibleWith(java.lang.Class<T> baseType) {
    return org.hamcrest.object.IsCompatibleType.<T>typeCompatibleWith(baseType);
  }

  /**
   * Constructs an IsEventFrom Matcher that returns true for any object
   * derived from <var>eventClass</var> announced by <var>source</var>.
   */
  public static org.hamcrest.Matcher<java.util.EventObject> eventFrom(java.lang.Class<? extends java.util.EventObject> eventClass, java.lang.Object source) {
    return org.hamcrest.object.IsEventFrom.eventFrom(eventClass, source);
  }

  /**
   * Constructs an IsEventFrom Matcher that returns true for any object
   * derived from {@link java.util.EventObject} announced by <var>source
   * </var>.
   */
  public static org.hamcrest.Matcher<java.util.EventObject> eventFrom(java.lang.Object source) {
    return org.hamcrest.object.IsEventFrom.eventFrom(source);
  }

  public static <T> org.hamcrest.Matcher<T> hasProperty(java.lang.String propertyName) {
    return org.hamcrest.beans.HasProperty.<T>hasProperty(propertyName);
  }

  public static <T> org.hamcrest.Matcher<T> hasProperty(java.lang.String propertyName, org.hamcrest.Matcher<?> value) {
    return org.hamcrest.beans.HasPropertyWithValue.<T>hasProperty(propertyName, value);
  }

  public static <T> org.hamcrest.Matcher<T> samePropertyValuesAs(T expectedBean) {
    return org.hamcrest.beans.SamePropertyValuesAs.<T>samePropertyValuesAs(expectedBean);
  }

  public static org.hamcrest.Matcher<org.w3c.dom.Node> hasXPath(java.lang.String xPath, javax.xml.namespace.NamespaceContext namespaceContext, org.hamcrest.Matcher<? super java.lang.String> valueMatcher) {
    return org.hamcrest.xml.HasXPath.hasXPath(xPath, namespaceContext, valueMatcher);
  }

  public static org.hamcrest.Matcher<org.w3c.dom.Node> hasXPath(java.lang.String xPath, org.hamcrest.Matcher<? super java.lang.String> valueMatcher) {
    return org.hamcrest.xml.HasXPath.hasXPath(xPath, valueMatcher);
  }

  public static org.hamcrest.Matcher<org.w3c.dom.Node> hasXPath(java.lang.String xPath) {
    return org.hamcrest.xml.HasXPath.hasXPath(xPath);
  }

  public static org.hamcrest.Matcher<org.w3c.dom.Node> hasXPath(java.lang.String xPath, javax.xml.namespace.NamespaceContext namespaceContext) {
    return org.hamcrest.xml.HasXPath.hasXPath(xPath, namespaceContext);
  }

}
