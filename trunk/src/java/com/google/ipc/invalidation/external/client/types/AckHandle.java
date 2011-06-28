/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ipc.invalidation.external.client.types;

import java.util.Arrays;

/**
 * Represents an opaque handle that can be used to acknowledge an invalidation event by calling
 * {@code InvalidationClient.acknowledge(AckHandle)} to indicate that the client has successfully
 * handled the event.
 *
 */
public final class AckHandle {

  /** The serialized representation of the handle */
  private final byte[] handleData;

  /** Creates a new ack handle from the serialized {@code handleData} representation. */
  public static AckHandle newInstance(byte[] handleData) {
    return new AckHandle(handleData);
  }

  private AckHandle(byte[] handleData) {
    this.handleData = handleData;
  }

  public byte[] getHandleData() {
    return handleData;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }

    if (!(object instanceof AckHandle)) {
      return false;
    }

    final AckHandle other = (AckHandle) object;
    return Arrays.equals(handleData, other.handleData);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(handleData);
  }
}