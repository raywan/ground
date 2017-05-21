/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.berkeley.ground.common.dao.core;

import edu.berkeley.ground.common.exception.GroundException;
import edu.berkeley.ground.common.model.core.NodeVersion;
import java.util.List;

public interface NodeVersionDao extends RichVersionDao<NodeVersion> {

  @Override
  NodeVersion create(NodeVersion nodeVersion, List<Long> parentIds) throws GroundException;

  @Override
  NodeVersion retrieveFromDatabase(long id) throws GroundException;

  @Override
  default Class<NodeVersion> getType() {
    return NodeVersion.class;
  }
}
