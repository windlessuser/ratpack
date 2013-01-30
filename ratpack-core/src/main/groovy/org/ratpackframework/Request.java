/*
 * Copyright 2012 the original author or authors.
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

package org.ratpackframework;

import org.ratpackframework.session.Session;
import org.vertx.java.core.Handler;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.json.JsonObject;

import java.util.Map;

/**
 * A request to be handled.
 */
public interface Request {

  String getMethod();

  String getUri();

  String getQuery();

  String getPath();

  Map<String, ?> getQueryParams();

  Map<String, String> getUrlParams();

  void buffer(Handler<Buffer> bufferHandler);

  void text(Handler<String> textHandler);

  void json(Handler<JsonObject> jsonHandler);

  void form(Handler<Map<String, ?>> formHandler);

  Session getSession();

  HttpServerRequest getVertxRequest();


}