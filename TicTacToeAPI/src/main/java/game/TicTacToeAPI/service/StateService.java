package game.TicTacToeAPI.service;

import game.TicTacToeAPI.dto.StateDataRequest;
import game.TicTacToeAPI.entity.StateData;
import game.TicTacToeAPI.repo.GameStateRepo;
import game.TicTacToeAPI.repo.StateDataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {
   private final StateDataRepo stateDataRepo;
   private final GameStateRepo gameStateRepo;
    public StateData saveStateData(StateDataRequest dataRequest) {
        return stateDataRepo.save(dataRequest.getStateData());
    }

    public List<StateData> getAllState() {
        return stateDataRepo.findAll();
    }
}
