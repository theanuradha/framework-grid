/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at EDV Systemhaus GmbH/Austria,
 * http://www.BestSolution.at
 *
 * This file is part of framework-grid which was developed with funding
 * from DI Christoph Hermann - InformationsTechnologie Beratung Hermann
 * /Austria.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package at.bestsolution.framework.grid;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import at.bestsolution.framework.grid.Grid.Selection;
import at.bestsolution.framework.grid.func.CellDataFunction;
import at.bestsolution.framework.grid.func.CellValueMatcherFunction;

/**
 * Utility methods
 *
 * @since 1.0
 */
public class Util {
	static class EmptySelection<R, O> implements Selection<R, O> {

		@Override
		public @Nullable O getFirst() {
			return null;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull List<@NonNull O> asList() {
			return Collections.emptyList();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public <C> @NonNull Selection<R, GridCell<R, C>> asCellSelection() {
			return new EmptySelection<>();
		}
	}

	/**
	 * @return an empty selection
	 */
	public static <R> @NonNull Selection<R, R> emptySelection() {
		return new EmptySelection<>();
	}

	/**
	 * @return cell data function who always return null
	 */
	public static <R, C, D> @NonNull CellDataFunction<R, C, @Nullable D> nullCellDataFunction() {
		return new CellDataFunction<R, C, @Nullable D>() {

			@Override
			public @Nullable D apply(R row, C cellValue) {
				return null;
			}
		};
	}

	/**
	 * @return cell data function who returns the toString value of the cell
	 *         value or <code>null</code>
	 */
	public static <R, C> @NonNull CellDataFunction<R, C, @Nullable CharSequence> defaultToStringCellDataFunction() {
		return new CellDataFunction<R, C, @Nullable CharSequence>() {

			@Override
			public @Nullable CharSequence apply(R row, C cellValue) {
				return cellValue == null ? null : cellValue.toString();
			}
		};
	}

	/**
	 * @return matcher function who compares the string value
	 */
	public static <R, C, O> @NonNull CellValueMatcherFunction<R, @Nullable C, @NonNull O> defaultToStringMatcher() {
		return new CellValueMatcherFunction<R, @Nullable C, @NonNull O>() {

			@Override
			public boolean apply(R row, @Nullable C cellValue,
					@NonNull O filterData) {
				if (cellValue == null) {
					return false;
				}
				return filterData.toString().equals(cellValue.toString());
			}
		};
	}

	/**
	 * @return supplier of empty list
	 */
	public static <O> @NonNull Supplier<@NonNull List<@NonNull O>> emptyListSupplier() {
		return new Supplier<@NonNull List<@NonNull O>>() {

			@SuppressWarnings("null")
			@Override
			public @NonNull List<@NonNull O> get() {
				return Collections.<@NonNull O> emptyList();
			}
		};
	}

	/**
	 * @return to string representation of value
	 */
	public static <O> @NonNull Function<@NonNull O, @Nullable CharSequence> defaultToStringFunction() {
		return new Function<@NonNull O, @Nullable CharSequence>() {

			@Override
			public CharSequence apply(@NonNull O t) {
				return t.toString();
			}
		};
	}
}