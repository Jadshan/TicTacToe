package game.TicTacToeAPI.service;

import game.TicTacToeAPI.dto.StateDataRequest;
import game.TicTacToeAPI.entity.StateData;
import game.TicTacToeAPI.repo.GameStateRepo;
import game.TicTacToeAPI.repo.StateDataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        // Create a Pageable object to specify the page and sorting
        Pageable pageable = PageRequest.of(0, 12, Sort.by(Sort.Direction.DESC, "id"));

        // Fetch the last 12 records 
        return stateDataRepo.findAll(pageable).getContent();
    }
}
