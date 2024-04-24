package game.TicTacToeAPI.repo;

import game.TicTacToeAPI.entity.StateData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateDataRepo extends JpaRepository<StateData, Long>{

}
