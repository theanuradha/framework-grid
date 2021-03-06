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
package at.bestsolution.framework.grid.component;

/**
 * Allows publishing grid informations like selection changes in an application
 * framework
 */
public interface XGridEventPublisher {
	/**
	 * Root topic
	 */
	public static final String ROOT_TOPIC = "xgrid"; //$NON-NLS-1$

	/**
	 * Selection topic
	 */
	public static final String SELECTION_CHANGED = ROOT_TOPIC + "/selection"; //$NON-NLS-1$

	/**
	 * Publish the event asynchronous (=none blocking)
	 */
	public static final String SYNC_TYPE_ASYNC = "async"; //$NON-NLS-1$

	/**
	 * Publish the event synchronous (=blocking)
	 */
	public static final String SYNC_TYPE_SYNC = "sync"; //$NON-NLS-1$

	/**
	 * Publish informations
	 *
	 * @param topic
	 *            the topic
	 * @param data
	 *            the data
	 */
	public void publish(String topic, Object data);
}
