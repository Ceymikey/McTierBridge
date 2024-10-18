# McTiersBridge

Mctiersbridge is a Minecraft plugin that fetches tier info from  the official [mctiers tierlist](https://mctiers.com/ranking/overall) backend and implements [PAPI](https://github.com/PlaceholderAPI/PlaceholderAPI) to register placeholders based on tier info of the player. Also comes equipped with a developer API.

## Small documentation
```kotlin
// Adding the project - build.gradle
repositories {
    maven {
        name "ceymikeydev"
        url "https://repo.ceymikey.dev/releases"
    }
}

dependencies {
    implementation "dev.ceymikey:mctiersbridge-api:1.0.0"
}
```

## Placeholders
- `%TierBridge_vanilla_{player}%` - Returns the vanilla tier of the player.
- `%TierBridge_overall_{player}%` - Returns the overall rank of the player.
- `%TierBridge_region_{player}%` - Returns the region of the player.
- `%TierBridge_points_{player}%` - Returns the overall points of the player.

## Compatibility
| Server software                                           | Version | Supported |
|-----------------------------------------------------------|---------|-----------|
| [Papermc](https://github.com/PaperMC/Paper)               | 1.19.-  | 🔴        |
|                                                           | 1.20    | 🔴        |
|                                                           | 1.20.2  | 🔴        |
|                                                           | 1.20.4  | ✅         |
|                                                           | 1.20.6  | 🔴        | 
|                                                           | 1.21.+  | 🔴        |
| [Pufferfish](https://github.com/pufferfish-gg/Pufferfish) | Any     | 🔴        |
| Anything else?                                            | Any     | 🔴        |

| Server proxies                                       | Version | Supported |
|------------------------------------------------------|---------|-----------|
| [Velocity](https://github.com/PaperMC/Velocity)      | Any     | 🔴        |
| [Waterfall](https://github.com/PaperMC/Waterfall)    | Any     | 🔴        |
| [Bungeecord](https://github.com/SpigotMC/BungeeCord) | Any     | 🔴        |