package org.bot.game;

public class Witch extends GameRole {
    public Witch() {
        super(roleName, description);
        this.roleName = "Phù thủy";
        this.description = "Phù thủy sẽ có hai bình thuốc. Một bình thuốc để cứu 1 người và một bình thuốc để giết 1 người. Trong đêm, Quản trò sẽ cho Phù Thủy biết ai sẽ bị giết trong đêm và hỏi xem Phù thủy có muốn sử dụng quyền năng nào hay không. Có thể dùng cả hai bình thuốc này vào cùng 1 đêm, nhưng mỗi bình chỉ dùng một lần.";
    }
}
