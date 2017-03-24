/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.berkeley.ground.model.usage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.berkeley.ground.model.models.Tag;
import edu.berkeley.ground.model.versions.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LineageEdge extends Item<LineageEdgeVersion> {
  // the name of this LineageEdge
  private String name;

  // the source key for this Node
  private String sourceKey;

  @JsonCreator
  public LineageEdge(@JsonProperty("id") long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("sourceKey") String sourceKey,
                     @JsonProperty("tags")Map<String, Tag> tags) {
    super(id, tags);

    this.name = name;
    this.sourceKey = sourceKey;
  }

  @JsonProperty
  public String getName() {
    return this.name;
  }

  @JsonProperty
  public String getSourceKey() {
    return this.sourceKey;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof LineageEdge)) {
      return false;
    }

    LineageEdge otherLineageEdge = (LineageEdge) other;

    return this.name.equals(otherLineageEdge.name) &&
        this.getId() == otherLineageEdge.getId() &&
        this.sourceKey.equals(otherLineageEdge.sourceKey);
  }
}
