/*
 * Copyright (c) 2011-2014 Pivotal Software, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package reactor.rx.action;

import reactor.core.Dispatcher;

/**
 * @author Stephane Maldini
 * @since 1.1
 */
public class DistinctUntilChangedAction<T> extends Action<T,T> {

	private T lastData;

	public DistinctUntilChangedAction(Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	protected void doNext(T currentData) {
		if(currentData == null || !currentData.equals(lastData)){
			lastData = currentData;
			broadcastNext(currentData);
		}
	}
}
