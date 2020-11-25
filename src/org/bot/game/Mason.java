package org.bot.game;

public class Mason extends GameRole {
    public Mason() {
        super(roleName, description);
        this.roleName = "Sinh đôi";
        this.description = "Đêm đầu tiên, Quản trò gọi Sinh đôi dậy để tìm kiếm các Sinh đôi khác. Không ai trong làng được phép nói hoặc ám chỉ về Sinh đôi, bằng không họ sẽ bị giết đêm hôm đó, tự động xử thua dù thuộc phe thắng.";
    }
}
