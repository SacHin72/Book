import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateBookComponent } from './update-book/update-book.component';


const routes: Routes = [
  {path:'updateBook',component: UpdateBookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
