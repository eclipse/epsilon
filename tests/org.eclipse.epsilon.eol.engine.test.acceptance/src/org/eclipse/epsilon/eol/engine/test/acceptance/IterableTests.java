package org.eclipse.epsilon.eol.engine.test.acceptance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.eol.engine.test.acceptance.eunit.EUnitRunner;
import org.eclipse.epsilon.eol.engine.test.acceptance.eunit.ExtraModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.java.JavaModel;
import org.junit.runner.RunWith;

/**
 * Tests for Iterable objects that are not Collections.
 */
@RunWith(EUnitRunner.class)
public class IterableTests {
	/**
	 * Implements the Iterable interface without being a Collection, using
	 * composition. Also provides a method that populates the list with a
	 * particular number of elements, and another one that creates new
	 * instances. The create method is required in order to test that Iterable
	 * values are not wrapped by the PointExecutor.
	 */
	public static class FakeIterable implements Iterable<Integer> {
		private final List<Integer> list = new ArrayList<>();

		public FakeIterable create(int nElements) {
			final FakeIterable iterable = new FakeIterable();
			iterable.populate(nElements);
			return iterable;
		}

		public void populate(int nElements) {
			list.clear();
			for (int i = 0; i < nElements; ++i) {
				list.add(i);
			}
		}

		@Override
		public Iterator<Integer> iterator() {
			return list.iterator();
		}
	}

	@ExtraModel
	public IModel getJavaModel() {
		final JavaModel jModel = new JavaModel(Arrays.asList(), Arrays.asList(FakeIterable.class));
		jModel.setName("J");
		jModel.setReadOnLoad(true);
		jModel.setStoredOnDisposal(false);
		return jModel;
	}
}
