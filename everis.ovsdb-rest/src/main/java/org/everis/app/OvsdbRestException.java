/*
 * Copyright 2017-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.everis.app;

/**
 * Custom exception class for OVSDB device.
 */
public class OvsdbRestException {

    /**
     *
     * @throws Exception Thrown for problems related to a device entity representing an ovsdb node.
     *
     */
    public static class OvsdbDeviceException extends Exception {
        public OvsdbDeviceException(String message) {
            super(message);
        }
    }

    /**
     *
     * @throws Exception Thrown when the an ovs bridge already exists with a given name.
     *
     */
    public static class BridgeAlreadyExistsException extends Exception { }

    /**
     *
     * @throws Exception Thrown when an ovs bridge is not found.
     *
     */
    public static class BridgeNotFoundException extends Exception { }
}
