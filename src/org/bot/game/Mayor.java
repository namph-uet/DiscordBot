package org.bot.game;

public class Mayor extends GameRole {
    public Mayor() {
        super(roleName, description);
        this.roleName = "Thị trưởng";
        this.description = "Phiếu biểu quyết của Thị trường được tính là 2 phiếu khi biểu quyết treo cổ.";
    }
}
