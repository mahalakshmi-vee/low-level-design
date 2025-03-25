## Design Library Management System

A library management system is an automated system used to manage a library and the different resource mangement required in it like 
cataloging of books, allowing check out and returning of books, invoicing, user management etc.,

For this problem, we have to design a library management system that can do a few of the above functionalities:

Requirements:
Create a command line application for the library management system with the following requirements:

1. Details about the library:
     a. The library will have one or more copies of multiple books.
     b. The library will have multiple racks and each rack can contain at most one copy any book.
2. Each Book will have the following properties:
     a. Book ID
     b. Title
     c. Authors
     d. Publishers
3. Details about Book Copies:
     a. There could be multiple copies of the same book.
     b. Each book copy will have a unique ID.
     c. Each book copy will be placed on a rack.
     d. Each book copy can be borrowed by a user with a specific due date.
4. Every rack will have a unique rack number (numbered serially from 1 to n where n is the total number of racks).
5. Details about user:
     a. User Details: User ID, Name
     b. A user can borrow a maximum of 5 books.
6. The functions that the library management system can do:
     a. Create a library.
     b. Add a book to the library and the book should be added to the first available rack.
     c. Remove a book copy from the library.
     d. Allow a user to borrow a book copy given the book id, user id, and due date. The first available copy based on the rack number should be provided.
     e. Allow a user to borrow a book copy given the book copy id, user id, and due date.
     f. Allow a user to return a book copy given the book copy id. The book should be added to the first available rack.
     g. Allow a user to print the book copy ids of all the books borrowed by them.
     h. Allow a user to search for books using few book properties (Book ID, Title, Author, Publisher). Searching should return details about all the book copies that match the search query.

 
