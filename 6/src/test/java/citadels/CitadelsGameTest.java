package citadels;

import citadels.game.CitadelsGame;
import citadels.player.ComputerPlayer;
import citadels.player.HumanPlayer;
import citadels.player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CitadelsGameTest {

    @Test
    void playThreeRounds() {

        /* ── 1. 准备“假输入”供 HumanPlayer 读取 ── */
        String input = """
                       draw
                       skip
                       skip
                       """;
        Scanner humanIn = new Scanner(new ByteArrayInputStream(input.getBytes()));

        /* ── 2. 组装玩家列表（1 个真人 + 1 个电脑）── */
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1, humanIn));  // 你的 HumanPlayer(id, Scanner) 构造方法
        players.add(new ComputerPlayer(2));        // 电脑玩家自己生成输入

        /* ── 3. 创建游戏实例：符合  (List<Player>, Random) 这个构造签名 ── */
        CitadelsGame game = new CitadelsGame(players, new Random(42));

        /* ── 4. 真的跑 3 个回合 ── */
        game.play(3, new Scanner(
            "draw\nskip\n" +
            "draw\nskip\n" +
            "draw\nskip\n"
        ));

        /* ── 5. （可选）断言得分 / 城市规模 ── */
        // 这里只举例 assert 城市张数 = 0，你可以按需求改成得分断言
        assertEquals(0, players.get(0).getCity().size());
        assertEquals(0, players.get(1).getCity().size());
    }
}
