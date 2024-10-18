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

import dev.ceymikey.mcTiersBridge.placeholders.holders.PVanilla;
import dev.ceymikey.mcTiersBridge.placeholders.holders.POverall;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BasicHolder extends PlaceholderExpansion {
    private final ArrayList<Holder> subHolder = new ArrayList<>();

    public BasicHolder() {
        subHolder.add(new PVanilla());
        subHolder.add(new POverall());
    }

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
        String[] args = params.split("_");
        for (int i = 0; i < subHolder.size(); i++) {
            if (args[0].equalsIgnoreCase(subHolder.get(i).getName())) {
                return subHolder.get(i).process(args);
            }
        }
        return null;
    }
}
