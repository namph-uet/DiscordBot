package org.bot.game;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bot.config.CrunchifyGetPropertyValues;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

public class AgrouGame extends ListenerAdapter implements Runnable {

    private CrunchifyGetPropertyValues config;
    private List<Member> player;
    private AgrouGame instance;

    public AgrouGame(List player) {
        config = new CrunchifyGetPropertyValues();
        this.player = player;
        instance = this;
        System.out.println("sdasd");
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

        builder.addEventListeners(instance);

        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ", 2);
        System.out.println("heasd");
        event.getChannel().sendMessage("test thread").queue();

        super.onGuildMessageReceived(event);
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        player.stream().forEach(element -> {
             createTextChannel(element, "hel");
        });
    }


    public void sendPrivateMessage(User user, String content) {
        // openPrivateChannel provides a RestAction<PrivateChannel>
        // which means it supplies you with the resulting channel
        user.openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(content).queue();
        });
    }

    @Override
    public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        System.out.println("dm");

        if(message.equalsIgnoreCase("hello")) {
            sendPrivateMessage(event.getAuthor(), "Testing ... .link");
        }
    }

    @Override
    public void onGenericEvent(@Nonnull GenericEvent event) {

    }

    public static void createTextChannel(Member member, String name) {
        Guild guild = member.getGuild();
        guild.createTextChannel(name)
                .addPermissionOverride(member, EnumSet.of(Permission.VIEW_CHANNEL), null)
                .addPermissionOverride(guild.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                .queue(); // this actually sends the request to discord.
    }
}
