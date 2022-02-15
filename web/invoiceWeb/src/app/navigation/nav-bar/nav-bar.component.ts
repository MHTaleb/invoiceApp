import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MdbDropdownDirective } from 'mdb-angular-ui-kit/dropdown';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements AfterViewInit {
  @ViewChild('dropdown') dropdown!: MdbDropdownDirective;

  constructor() {}

  ngAfterViewInit(): void {
    setTimeout(() => {
      this.dropdown.show();
    }, 0);
  }
}
