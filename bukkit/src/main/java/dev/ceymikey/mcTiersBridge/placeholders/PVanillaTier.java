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

package dev.ceymikey.mcTiersBridge.placeholders;

import dev.ceymikey.mcTiersBridge.util.Https;
import dev.ceymikey.mcTiersBridge.util.Types;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PVanillaTier extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "TierBridge";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Ceymikey";
    }

    @Override
    public @NotNull String getVersion() {
        return "V++";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        /**
         * We build a new HTTPS connection from here.
         * We than use the data from the builder
         */
        Https request = new Https.builder()
                .setEndpoint("https://mctiers.com/api/search_profile/" + params)
                .setType(Types.VANILLA)
                .build();
        if (params.equals(params)) {
            try {
                int tier = request.returnTier();
                return String.valueOf(tier);
            } catch (Exception e) {
                e.printStackTrace();
                return "ERROR_400";
            }
        }
        return null;
    }
}
