package org.bot.game;

public class Prince extends GameRole {
    public Prince() {
        super(roleName, description);
        this.roleName = "Hoàng tử";
        this.description = "Hoàng tử không thể bị treo cổ chết. Vào lần bị vote chết và chuẩn bị treo cổ, người này sẽ lật lá bài lên để mọi người được thấy và không phải chịu treo cổ. Tất cả người chơi lập tức đi ngủ.";
    }
}
