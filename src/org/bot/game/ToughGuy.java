package org.bot.game;

public class ToughGuy extends GameRole {
    public ToughGuy() {
        super(roleName, description);
        this.roleName = "Người cứng cỏi";
        this.description = "Nếu bị Sói cắn, Người cứng cói sẽ chết vào đêm tiếp theo chứ không phải ngay tại đêm đó.";
    }
}
