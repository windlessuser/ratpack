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

package ratpack.form.internal;

import ratpack.form.Form;
import ratpack.form.FormParser;
import ratpack.handling.Context;
import ratpack.http.TypedData;
import ratpack.parse.NoOptParse;
import ratpack.parse.NoOptParserSupport;

public class DefaultFormParser extends NoOptParserSupport<Form> implements FormParser {

  private DefaultFormParser(String contentType) {
    super(contentType);
  }

  @Override
  public Form parse(Context context, TypedData requestBody, NoOptParse<Form> parse) {
    return FormDecoder.parseForm(context, requestBody);
  }

  public static FormParser multiPart() {
    return new DefaultFormParser("multipart/form-data");
  }

  public static FormParser urlEncoded() {
    return new DefaultFormParser("application/x-www-form-urlencoded");
  }

}