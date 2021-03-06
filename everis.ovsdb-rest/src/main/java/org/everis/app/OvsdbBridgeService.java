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

import org.onlab.packet.IpAddress;
import org.onosproject.net.intent.PathIntent;

/**
 * APIs for ovsdb driver access.
 */
public interface OvsdbBridgeService {

    /**
     * Creates a new bridge.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     * @throws OvsdbRestException.BridgeAlreadyExistsException Error Description
     */
    void createBridge(IpAddress ovsdbAddress, String bridgeName) throws OvsdbRestException.OvsdbDeviceException,
            OvsdbRestException.BridgeAlreadyExistsException;

    /**
     * Deletes a bridge.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     * @throws OvsdbRestException.BridgeNotFoundException Error Description
     */
    void deleteBridge(IpAddress ovsdbAddress, String bridgeName) throws OvsdbRestException.OvsdbDeviceException,
            OvsdbRestException.BridgeNotFoundException;

    /**
     * Adds a port to a bridge.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @param portName the name of the port to attach to the bridge
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     * @throws OvsdbRestException.BridgeNotFoundException Error Description
     */
    void addPort(IpAddress ovsdbAddress, String bridgeName, String portName)
            throws OvsdbRestException.OvsdbDeviceException, OvsdbRestException.BridgeNotFoundException;

    /**
     * Removes a port from a bridge.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @param portName the name of the port to remove from the bridge
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     * @throws OvsdbRestException.BridgeNotFoundException Error Description
     */
    void removePort(IpAddress ovsdbAddress, String bridgeName, String portName)
            throws OvsdbRestException.OvsdbDeviceException, OvsdbRestException.BridgeNotFoundException;

    /**
     * Adds a patch port to a bridge setting it as peer of an other port.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @param portName the port name
     * @param patchPeer the name of the peer port
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     * @throws OvsdbRestException.BridgeNotFoundException Error Description
     */
    void createPatchPeerPort(IpAddress ovsdbAddress, String bridgeName, String portName, String patchPeer)
            throws OvsdbRestException.OvsdbDeviceException, OvsdbRestException.BridgeNotFoundException;

    /**
     * Creates a GRE tunnel from a bridge to a remote destination.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @param portName the name of the new GRE port
     * @param remoteIp remote end point of GRE tunnel
     * @param key the tunnel key, should represent a 32 bit hexadecimal number
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     * @throws OvsdbRestException.BridgeNotFoundException Error Description
     */
    void createVxlanTunnel(IpAddress ovsdbAddress, String bridgeName, String portName,
                         IpAddress remoteIp, String key)
            throws OvsdbRestException.OvsdbDeviceException, OvsdbRestException.BridgeNotFoundException;

    /**
     * Deletes a GRE tunnel given the port name.
     * @param ovsdbAddress the ovsdb IP address
     * @param bridgeName the bridge identifier
     * @param portName the name of the GRE
     * @throws OvsdbRestException.OvsdbDeviceException Error Description
     */
    void deleteGreTunnel(IpAddress ovsdbAddress, String bridgeName, String portName)
            throws OvsdbRestException.OvsdbDeviceException;

    /**
     *
     * @param srcId Source ID of the Device
     * @param dstId Destination ID of the Device
     * @param portSrc Source Port that has the path
     * @param portDst Destination Port that has the path
     * @param setType set the type PRIMARY or BACKUP
     * @throws Exception Any possible error in the creation of the Intent
     */
    void createPathIntent(String srcId, String dstId, String portSrc, String portDst,
                          PathIntent.ProtectionType setType) throws Exception;
}
