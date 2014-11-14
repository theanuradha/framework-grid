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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Provides the list content to the grid
 *
 * @param <R>
 *            the content type
 * @since 1.0
 */
public class ListGridContentProvider<@NonNull R> implements
		GridContentProvider<R> {
	/**
	 * 
	 */
	private final List<R> data;

	/**
	 * @param data
	 *            list of elements to be provided
	 */
	public ListGridContentProvider(@NonNull List<R> data) {
		this.data = data;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public @NonNull R getElementAt(int index) throws IllegalArgumentException {
		return data.get(index);
	}
}