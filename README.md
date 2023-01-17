# No Enchantment Conflicts

![No-Enchantment-Conflicts icon](src/main/resources/assets/noeconflicts/icon.png?raw=true)

This mod removes the conflicts between:
- Infinity and Mending
- Protection, Projectile Protection, Fire Protection and Blast Protection
- Sharpness, Smite and Bane of Arthropods

- I tried to add Multishot/Piercing, but minecraft's implementation is weird for it, so I couldn't get it to work. If you are smart enough to figure it out, feel free to make a pull request.

Infinity and Mending
```java
public boolean checkCompatibility(Enchantment other) {
    return other instanceof MendingEnchantment ? false : super.checkCompatibility(other);
}
```

Piercing and Multishot
```java
public boolean checkCompatibility(Enchantment other) {
    return super.checkCompatibility(other) && other != Enchantments.MULTISHOT;
}
```

This is a server-side only mod (works with unmodded clients!) 

***Note:*** *Although this is a server-side mod, it can still be used in single player on clients*

## Setup

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
