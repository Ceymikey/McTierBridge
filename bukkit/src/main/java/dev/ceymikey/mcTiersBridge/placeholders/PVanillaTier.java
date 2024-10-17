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

import dev.ceymikey.mcTiersBridge.util.TierBridge;
import dev.ceymikey.mcTiersBridge.util.Types;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
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
        TierBridge bridge = new TierBridge();
        // TODO: Separate classes for args
        String[] args = params.split("_");
        if (args[0].equals("vanilla")) {
            Player targetPlayer = Bukkit.getPlayerExact(args[1]);
            if (targetPlayer != null) {
                try {
                    Object tier = bridge.getTier(args[1], Types.VANILLA);
                    Object pos = bridge.getTier(args[1], Types.POSITION);
                    return pos + "" + tier;
                } catch (Exception e) {
                    e.printStackTrace();
                    return "ERROR_400";
                }
            }
        }
        if (params.equals(params)) {
            try {
                Object tier = bridge.getTier(params, Types.VANILLA);
                Object pos = bridge.getTier(params, Types.POSITION);
                return pos + "" + tier;
            } catch (Exception e) {
                e.printStackTrace();
                return "ERROR_400";
            }
        }
        return null;
    }
}
