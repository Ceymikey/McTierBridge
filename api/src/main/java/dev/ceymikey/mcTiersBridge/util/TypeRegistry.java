/*
 * This file is part of McTiersBridge, https://github.com/Ceymikey/McTiersBridge
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

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class TypeRegistry {
    public static final Types VANILLA = get("vanilla");
    public static final Types OVERALL = get("overall");
    public static final Types POSITION = get("position");
    public static final Types POINTS = get("points");
    public static final Types REGION = get("region");

    private static Map<String, Types> registry = new ConcurrentHashMap<>();

    public static void register(String name, Types tierType) {
        if (registry == null) {
            registry = new ConcurrentHashMap<>();
        }
        registry.put(name, tierType);
    }

    public static Types get(String name) {
        if (registry == null) {
            registry = new ConcurrentHashMap<>();
        }
        return registry.get(name);
    }

    public static Collection<Types> getAll() {
        return registry.values();
    }
}