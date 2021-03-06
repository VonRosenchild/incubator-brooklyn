/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package brooklyn.rest.domain;

import java.net.URI;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.google.common.collect.ImmutableSet;

public class CatalogPolicySummary extends CatalogItemSummary {

    private static final long serialVersionUID = -588856488327394445L;
    
    @JsonSerialize(include=Inclusion.NON_EMPTY)
    private final Set<PolicyConfigSummary> config;

    public CatalogPolicySummary(
            @JsonProperty("symbolicName") String symbolicName,
            @JsonProperty("version") String version,
            @JsonProperty("name") String name,
            @JsonProperty("javaType") String javaType,
            @JsonProperty("planYaml") String planYaml,
            @JsonProperty("description") String description,
            @JsonProperty("iconUrl") String iconUrl,
            @JsonProperty("config") Set<PolicyConfigSummary> config,
            @JsonProperty("deprecated") boolean deprecated,
            @JsonProperty("links") Map<String, URI> links
        ) {
        super(symbolicName, version, name, javaType, planYaml, description, iconUrl, deprecated, links);
        // TODO expose config from policies
        this.config = (config == null) ? ImmutableSet.<PolicyConfigSummary>of() : config;
    }
    
    public Set<PolicyConfigSummary> getConfig() {
        return config;
    }

    @Override
    public String toString() {
        return super.toString()+"["+
                "config="+getConfig()+"]";
    }
}
