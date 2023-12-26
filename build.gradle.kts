import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.5.11" // Check for new versions at https://plugins.gradle.org/plugin/io.papermc.paperweight.userdev
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0" // Auto generates plugin.yml
    id("xyz.jpenilla.run-paper") version "2.2.2" //Integration testing
}

group = "mx.plugin.unitedchunksofpaper"
version = "1.0.0-SNAPSHOT"
description = "United Chunks of Paper Plugin"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
    implementation("com.google.code.gson:gson:2.9.0")
    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
}

tasks {
  // Configure reobfJar to run when invoking the build task
  assemble {
    dependsOn(reobfJar)
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

    // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
    // See https://openjdk.java.net/jeps/247 for more information.
    options.release.set(17)
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  processResources {
    filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
  }

  runServer {
    // Configure the Minecraft version for our task.
    // This is the only required configuration besides applying the plugin.
    // Your plugin's jar (or shadowJar if present) will be used automatically.
    minecraftVersion("1.20.4")
  }
}


// Configure plugin.yml generation
bukkit {
  load = BukkitPluginDescription.PluginLoadOrder.STARTUP
  main = "mx.plugin.unitedchunksofpaper.UCPMain"
  apiVersion = "1.20"
  authors = listOf("MXKhronos")
}
