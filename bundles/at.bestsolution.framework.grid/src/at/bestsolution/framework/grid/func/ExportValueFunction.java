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
package at.bestsolution.framework.grid.func;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Converts the cell value into an export value
 *
 * @param <R>
 *            the row type
 * @param <C>
 *            the cell value type
 * @since 1.0
 */
@FunctionalInterface
public interface ExportValueFunction<@NonNull R, @Nullable C> {
	/**
	 * Apply the function on the value
	 *
	 * @param row
	 *            the row
	 * @param cellValue
	 *            the cell
	 * @return the value to present in the UI
	 */
	public @Nullable Object apply(@NonNull R row, @Nullable C cellValue);
}
