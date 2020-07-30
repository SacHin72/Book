import { Component } from '@angular/core';
import { BookStoreConstantsService } from './book-store-constants.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookStoreTeam2Integrated';
  loggedIn : boolean ;
}
