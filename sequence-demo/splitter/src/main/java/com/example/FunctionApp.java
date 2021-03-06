/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Splitter FunctionApp
 */
public class FunctionApp {
  public static JsonObject main(JsonObject args) {
    JsonObject response = new JsonObject();
    String text = null;
    if (args.has("text")) {
      text = args.getAsJsonPrimitive("text").getAsString();
    }
    String[] results = new String[] { text };
    if (text != null && text.indexOf(",") != -1) {
      results = text.split(",");
    }
    JsonArray splitStrings = new JsonArray();
    for (String var : results) {
      splitStrings.add(var);
    }
    response.add("result", splitStrings);
    return response;
  }
}
