export class Book{
    bookId:number;
    title:string;
    author:string;
    description:string;
    isbnNumber:string;
    publishDate:Date;
    lastUpdateTime:Date;
    bookCategory:BookCategory;
}
export class BookCategory{
    categoryId:number;
    categoryName:String;
}