/*
 * Copyright 2013 the original author or authors.
 *
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

package ratpack.test.internal

import ratpack.test.embed.BaseDirBuilder
import ratpack.test.embed.JarFileBaseDirBuilder
import ratpack.test.embed.PathBaseDirBuilder
import spock.lang.AutoCleanup

import java.nio.file.Path

abstract class EmbeddedBaseDirRatpackSpec extends EmbeddedRatpackSpec {

  @AutoCleanup
  @Delegate
  BaseDirBuilder baseDir

  def setup() {
    baseDir = createBaseDirBuilder()
  }

  protected BaseDirBuilder createBaseDirBuilder() {
    new PathBaseDirBuilder(temporaryFolder.newFolder("app"))
  }

  protected ratpack.util.Factory<Path> getBaseDirFactory() {
    new ratpack.util.Factory() {
      @Override
      Object create() {
        getBaseDir().build()
      }
    }
  }

  void useJarBaseDir() {
    baseDir = new JarFileBaseDirBuilder(new File(temporaryFolder.newFolder("jar"), "the.jar"))
  }

}
