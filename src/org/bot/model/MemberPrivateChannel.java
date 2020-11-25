package org.bot.model;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;

import javax.annotation.Nonnull;

public class MemberPrivateChannel implements PrivateChannel  {
    private User user;
    private JDA jda;
    @Nonnull
    @Override
    public User getUser() {
        return user;
    }

    @Override
    public long getLatestMessageIdLong() {
        return 0;
    }

    @Override
    public boolean hasLatestMessage() {
        return false;
    }

    @Nonnull
    @Override
    public String getName() {
        return null;
    }

    @Nonnull
    @Override
    public ChannelType getType() {
        return ChannelType.PRIVATE;
    }

    @Nonnull
    @Override
    public JDA getJDA() {
        return jda;
    }

    @Nonnull
    @Override
    public RestAction<Void> close() {
        return null;
    }

    @Override
    public boolean isFake() {
        return false;
    }

    @Override
    public long getIdLong() {
        return 0;
    }
}
