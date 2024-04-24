package game.TicTacToeAPI.repo;

import game.TicTacToeAPI.entity.GameState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStateRepo extends JpaRepository<GameState, Long> {
}
