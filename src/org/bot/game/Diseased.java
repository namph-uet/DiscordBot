package org.bot.game;

public class Diseased extends GameRole {
    public Diseased() {
        super(roleName, description);
        this.roleName = "Người bệnh";
        this.description = "Nếu Người bệnh bị Sói cắn, thì Sói sẽ không thể cắn người nào vào đêm tiếp theo do bị bệnh.";
    }
}
