package com.unitedchunksofpaper;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * plugin java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("plugin");

  public void onEnable()
  {
    LOGGER.info("plugin enabled");
  }

  public void onDisable()
  {
    LOGGER.info("plugin disabled");
  }
}
