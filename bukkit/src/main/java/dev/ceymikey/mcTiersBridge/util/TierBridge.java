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

import dev.ceymikey.mcTiersBridge.McTiersBridgeAPI;

/**
 * This class is used for various methods to
 * get the players MCTIER from the official backend.
 */
public class TierBridge extends McTiersBridgeAPI {
    /**
     * Gets the players MCTIER from the official backend
     * @param player  the player to get the rank from
     * @param type    the type of rank to get
     * @return        returns the rank as a string
     */
    public String getTierAsString(String player, Types type) {
        Https request = new Https.builder()
                .setEndpoint("https://mctiers.com/api/search_profile/" + player)
                .setType(type)
                .build();
        int tier;
        try {
            tier = request.returnTier();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(tier);
    }

    /**
     * Gets the players MCTIER from the official backend
     * @param player the player to get the rank from
     * @param type   the type of rank to get
     * @return       returns the rank as an int
     */
    public int getTierAsInt(String player, Types type) {
        Https request = new Https.builder()
                .setEndpoint("https://mctiers.com/api/search_profile/" + player)
                .setType(type)
                .build();
        int tier;
        try {
            tier = request.returnTier();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tier;
    }

    public void ScaryMethod() {
        System.out.println("This is a scary method");
    }
}
