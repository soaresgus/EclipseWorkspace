package net.eduard.api.listener

import net.eduard.api.lib.manager.EventsManager
import net.eduard.api.server.PluginHook
import org.bukkit.event.EventHandler
import org.bukkit.event.server.PluginEnableEvent

class HooksListener : EventsManager() {

    @EventHandler
    fun onPluginEnableEvent(event: PluginEnableEvent) {
        val rooks = PluginHook.getRooks(event.plugin.name)
        rooks.forEach(PluginHook::onPluginActive)
    }

}