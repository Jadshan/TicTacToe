import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-gaming',
  templateUrl: './gaming.component.html',
  styleUrl: './gaming.component.scss',
})
export class GamingComponent {
  @Input() valueOfIndex: 'X' | 'O' | undefined;
}
