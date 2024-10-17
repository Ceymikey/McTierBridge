/*
 * This file is part of McTierBridge, https://github.com/Ceymikey/McTierBridge
 *
 * Copyright (c) 2024 Ceymikeydev and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.ceymikey.mcTiersBridge.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Getter;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is used to open HTTPS connections to
 * the official mctiers API.
 */
@Getter
public class Https {
    private final ExecutorService threadpool;
    private final String endpoint;
    private final Types type;

    private Https(builder builder) {
        this.endpoint = builder.getEndpoint();
        this.type = builder.getType();
        this.threadpool = Executors.newCachedThreadPool();
    }

    public Object returnTier() throws Exception {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL(getEndpoint());
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    StringBuilder responseBuilder = new StringBuilder();
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        String line;
                        while ((line = in.readLine()) != null) {
                            responseBuilder.append(line);
                        }
                    }

                    String response = responseBuilder.toString();

                    Gson gson = new Gson();
                    JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

                    Object tier = type.getTier(jsonObject);

                    connection.disconnect();
                    return tier;
                } else {
                    throw new Exception("Failed to fetch info: " + responseCode);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error fetching tier", e);
            }
        }, threadpool);
        return future.join();
    }

    /**
     * This class is used to build a new Https connection.
     * We later use this data to open the Https connection.
     * This class might look awful but idc.
     */
    @Getter
    public static class builder {
        private String endpoint;
        private Types type;

        public builder setEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public builder setType(Types type) {
            this.type = type;
            return this;
        }

        public Https build() {
            return new Https(this);
        }
    }
}
