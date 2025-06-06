/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.metadata.impl.batching;

import java.util.concurrent.CompletableFuture;

public interface MetadataOp {
    enum Type {
        GET,
        GET_CHILDREN,
        PUT,
        DELETE
    }

    Type getType();

    CompletableFuture<?> getFuture();

    int size();

    long created();

    default OpGet asGet() {
        return (OpGet) this;
    }

    default OpDelete asDelete() {
        return (OpDelete) this;
    }

    default OpGetChildren asGetChildren() {
        return (OpGetChildren) this;
    }

    default OpPut asPut() {
        return (OpPut) this;
    }

    String getPath();
}
