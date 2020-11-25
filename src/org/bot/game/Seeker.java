package org.bot.game;

public class Seeker extends GameRole {
    public Seeker() {
        super(roleName, description);
        this.roleName = "Tiên tri";
        this.description = "Mỗi đêm, Tiên tri chỉ tay vào một người. Quản trò sẽ cho Tiên tri biết người đó có phải là Ma sói hay không bằng cách gật hoặc lắc đầu.";
    }
}
