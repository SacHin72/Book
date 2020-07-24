import { Component, OnInit } from '@angular/core';
import { Book } from '../book'
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  book :Book=new Book();
  
  constructor(private bookService:BookService,private router: Router) { }
  message:String;
  ngOnInit(): void {
  }

  updateBook(book:Book){
    this.book.bookCategory=null;
    console.log('Updating...Please Wait!!!');
    this.bookService.updateBook(book).subscribe(
        data=>{
          this.message=data;
          console.log(this.message);
          console.log(data);
          alert(this.message);
          
        },
        error => {
          console.log(this.message);
        }
    );
  }
}
