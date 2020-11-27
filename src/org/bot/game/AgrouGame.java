package org.bot.game;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bot.config.CrunchifyGetPropertyValues;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.List;

public class AgrouGame extends ListenerAdapter implements Runnable {

    private CrunchifyGetPropertyValues config;
    private List<Member> player;

    public AgrouGame(List player) {
        config = new CrunchifyGetPropertyValues();
        this.player = player;
    }

    @Override
    public void run() {
        JDABuilder builder = null;
        try {
            builder = JDABuilder.createDefault(config.getConfig("discordToken"), GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_VOICE_STATES);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk dwaelete events
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("TV"));

        builder.addEventListeners(this);

        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ", 2);
        if ("~play".equals(command[0]) && command.length == 2) {

        } else if ("~play".equals(command[0])) {

        }

        event.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessage("hello").queue();
        });

        super.onGuildMessageReceived(event);
    }
}
