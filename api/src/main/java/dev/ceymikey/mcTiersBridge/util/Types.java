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

import com.google.gson.JsonObject;

/**
 * Types class for the McTierBridge API.
 * Registering these types in TypeRegistry.
 */
public abstract class Types {
    public static Types VANILLA = new Types() {
        @Override
        public int getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject vanilla = rankings.getAsJsonObject("vanilla");
            return vanilla.get("tier").getAsInt();
        }
    };
    public static Types OVERALL = new Types() {
        @Override
        public int getTier(JsonObject jsonObject) {
            return jsonObject.get("overall").getAsInt();
        }
    };

    /**
     * Forces getTier method to be implemented in all enum values.
     * @param jsonObject  JsonObject containing the tier information
     * @return            Returns tier value
     */
    public abstract int getTier(JsonObject jsonObject);
}
