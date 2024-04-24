import { Component } from '@angular/core';
import { GameState, state, stateData } from '../../model/model';
import { GameService } from '../../service/game.service';

@Component({
  selector: 'app-game-dashboard',
  templateUrl: './game-dashboard.component.html',
  styleUrl: './game-dashboard.component.scss',
})
export class GameDashboardComponent {
  // Initialization
  boardIndexes: any = [];
  playingCount: number = 0;
  turnOfO = true;
  winPossibilities = [
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  winner = '';
  isDraw = '';
  isNewGame = true;
  stateData!: GameState;
  playedState: stateData[] = [];
  items = [0, 1, 2, 3, 4, 5, 6, 7, 8];
  btnStatus = 'Start Game';

  constructor(private service: GameService) {
    this.stateData = { stateData: { state: [], status: '' } };
  }

  ngOnInit(): void {
    // Fetching state from the service
    this.service.getState().subscribe((res) => {
      this.playedState = res;
      console.log(this.playedState);
    });
  }

  get currentPlayer(): string {
    return this.turnOfO ? 'X' : 'O';
  }

  // Start a new game
  startNewGame(): void {
    this.btnStatus = 'Start Game';
    this.boardIndexes = Array(9).fill(null);
    this.playingCount = 0;
    this.winner = '';
    this.isDraw = '';
    this.isNewGame = false;
  }

  // Click event handler for each square
  onClickIndex(index: number) {
    this.btnStatus = 'Resume Game';
    if (!this.boardIndexes[index]) {
      this.boardIndexes.splice(index, 1, this.currentPlayer);
      this.turnOfO = !this.turnOfO;
      this.playingCount++;
    }
    this.winner = this.findWinner();
    this.stateData.stateData.status = this.winner;

    if (!this.winner && this.playingCount == 9) {
      this.isDraw = 'Draw';
      this.stateData.stateData.status = this.isDraw;
    }

    // Save state
    if (this.winner || (!this.winner && this.playingCount == 9)) {
      this.btnStatus = 'Play Again';
      this.stateData.stateData.state = [];
      for (let i = 0; i < this.boardIndexes.length; i++) {
        const currentState: state = {
          ind: i,
          value: this.boardIndexes[i],
        };
        this.stateData.stateData.state.push(currentState);
      }
      if (this.stateData.stateData.state.length > 0) {
        this.service.postState(this.stateData).subscribe((res) => {
          this.playedState = res;
          console.log(this.playedState);
        });
      }
    }
  }

  // Function to determine the winner
  findWinner() {
    for (const possibility of this.winPossibilities) {
      const [x, y, z] = possibility;

      // Check if all three positions are marked and are the same
      if (
        this.boardIndexes[x] &&
        this.boardIndexes[x] === this.boardIndexes[y] &&
        this.boardIndexes[x] === this.boardIndexes[z]
      ) {
        return this.boardIndexes[x];
      }
    }
    return null;
  }
}
