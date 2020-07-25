import { Component, OnInit } from '@angular/core';
import { Book } from '../book'
import { BookService } from '../book.service';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  book :Book=new Book();
  newBook :Book=new Book();
  todayDate : Date = new Date();
  successMessage;
  errorMessage;
  showSuccessMessage:boolean;
  showErorrMessage:boolean;

  constructor(private bookService:BookService,private route : ActivatedRoute) { }

  ngOnInit(): void {
  }

  updateBook(book:Book){
    this.book.lastUpdateTime=this.todayDate;
    this.book.bookCategory=null;
    this.bookService.updateBook(book).subscribe(
      data=>{
        this.successMessage=data,
        this.showSuccessMessage=true
      },
      (error:HttpErrorResponse)=>{
        this.errorMessage=error.error.message,
        this.showErorrMessage=true
      }
    );
  }
}
