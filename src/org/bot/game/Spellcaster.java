package org.bot.game;

public class Spellcaster extends GameRole {
    public Spellcaster() {
        super(roleName, description);
        this.roleName = "Người phù phép";
        this.description = "Mỗi đêm, Người phú phép sẽ được phép chỉ định 1 người bị câm vào hôm sau. Người này vào ngày hôm sau sẽ không được nói.";
    }
}
