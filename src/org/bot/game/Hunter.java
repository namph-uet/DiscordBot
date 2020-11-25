package org.bot.game;

public class Hunter extends GameRole {
    public Hunter() {
        super(roleName, description);
        this.roleName = "Thợ săn";
        this.description = "Nếu thợ săn chết, hắn lập tức được phép nhắm vào một người và người này sẽ bị chết. Nếu thợ săn chết trong đêm, Quản trò sẽ đụng vai Thợ săn để báo Thợ săn nhắm bắn.";
    }
}
