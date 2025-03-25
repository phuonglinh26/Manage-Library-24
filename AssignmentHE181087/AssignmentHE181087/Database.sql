CREATE DATABASE LibraryDatabase;
USE LibraryDatabase;

-- Bảng Role
CREATE TABLE Role (
    roleID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    roleName nvarchar(20) NOT NULL
);

-- Bảng Login
CREATE TABLE Login (
    loginID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    username nvarchar(30) NOT NULL,
    password nvarchar(100) NOT NULL,
    roleID int FOREIGN KEY REFERENCES Role(roleID)
);

-- Bảng Reader
CREATE TABLE Reader (
    readerID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    readerName nvarchar(30) NOT NULL,
    readerGender nvarchar(6),
    readerDOB date NOT NULL,
    readerPhone varchar(11),
    readerAddress nvarchar(100) NOT NULL,
    loginID int FOREIGN KEY REFERENCES Login(loginID)
);

-- Bảng Staff
CREATE TABLE Staff (
    staffID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    staffName nvarchar(30) NOT NULL,
    staffGender nvarchar(6),
    staffDOB date NOT NULL,
    staffPhone varchar(11),
    staffAddress nvarchar(100) NOT NULL,
    loginID int FOREIGN KEY REFERENCES Login(loginID)
);

-- Bảng ReturnRecord
CREATE TABLE ReturnRecord (
    returnID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    returnDate date NOT NULL
);


-- Bảng Book
CREATE TABLE Book (
    bookID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    title nvarchar(30) NOT NULL,
    publishedYear int NOT NULL,
    quantity int NOT NULL,
    genre nvarchar(20),
    publisherName nvarchar(30),
    authorName nvarchar(30),
    
);

-- Bảng BorrowRecord
CREATE TABLE BorrowRecord (
    borrowID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    borrowDate date NOT NULL,
    allowedDay int NOT NULL,
    readerID int FOREIGN KEY REFERENCES Reader(readerID) NOT NULL,
    bookID int FOREIGN KEY REFERENCES Book(bookID) NOT NULL,
    staffID int FOREIGN KEY REFERENCES Staff(staffID) NOT NULL
);

-- Bảng BorrowReturnDetail
CREATE TABLE BorrowReturnDetail (
    note nvarchar(20),
    fineAmount int NOT NULL,
    borrowID int FOREIGN KEY REFERENCES BorrowRecord(borrowID),
    returnID int FOREIGN KEY REFERENCES ReturnRecord(returnID),
    PRIMARY KEY (borrowID, returnID)
);

-- Dữ liệu cho bảng Role
INSERT INTO Role (roleName) VALUES
('Admin'),
('Staff'),
('Reader');

-- Dữ liệu cho bảng Login
INSERT INTO Login (username, password, roleID) VALUES
('alice', '123', 3),
('bob', '123', 3),
('carol', '123', 3),
('david', '123', 3),
('emma', '123', 3),
('sarah', '456', 2),
('brown', '456', 2),
('emily', '456', 2),
('daniel', '456', 2),
('jess', '456', 2),
('admin','123',1);



-- Dữ liệu cho bảng Reader
INSERT INTO Reader (readerName, readerGender, readerDOB, readerPhone, readerAddress, loginID) VALUES
('Alice Johnson', 'Female', '1995-06-05', '0123456789', '123 Main Street', 1),
('Bob Smith', 'Male', '1998-10-09', '0987654321', '456 Park Avenue', 2),
('Carol Williams', 'Female', '2000-12-22', '0112345678', '789 Elm Street', 3),
('David Brown', 'Male', '1990-06-18', '0178901234', '101 Oak Lane', 4),
('Emma Davis', 'Female', '1993-11-07', '0167890123', '234 Cedar Avenue', 5);

-- Dữ liệu cho bảng Staff
INSERT INTO Staff (staffName, staffGender, staffDOB, staffPhone, staffAddress, loginID) VALUES
('Sarah Adams', 'Female', '1999-10-27', '0123456789', '789 Elm Street', 6),
('Michael Brown', 'Male', '1995-12-12', '0987654321', '101 Pine Road', 7),
('Emily Clark', 'Female', '1999-03-29', '0112345678', '456 Oak Avenue', 8),
('Daniel Davis', 'Male', '2000-04-16', '0178901234', '789 Maple Street', 9),
('Jessica Evans', 'Female', '2001-01-09', '0167890123', '123 Pine Lane', 10);

-- Dữ liệu cho bảng ReturnRecord
INSERT INTO ReturnRecord (returnDate) VALUES
('2023-05-10'),
('2023-06-15'),
('2023-07-15'),
('2023-08-25'),
('2023-09-30');

-- Dữ liệu cho bảng Book
INSERT INTO Book (title, publishedYear, quantity, genre, publisherName, authorName) VALUES
('The Great Novel', 2020, 50, 'Fiction', 'ABC Publications', 'John Doe'),
('Science Unleashed', 2021, 30, 'Science', 'XYZ Books', 'Jane Smith'),
('History in Pages', 2019, 40, 'History', 'BookWorld Ltd', 'Michael John'),
('Fantasy World', 2022, 45, 'Fantasy', 'Global Books', 'Karen David'),
('Mystery of Life', 2023, 35, 'Mystery', 'Novel Concepts', 'Jennifer White');

-- Dữ liệu cho bảng BorrowRecord
INSERT INTO BorrowRecord (borrowDate, allowedDay, readerID, bookID, staffID) VALUES
('2023-04-01', 15, 1, 4, 1),
('2023-05-15', 15, 2, 5, 2),
('2023-06-30', 15, 3, 3, 3),
('2023-07-15', 15, 4, 4, 4),
('2023-08-01', 14, 5, 1, 5);

-- Dữ liệu cho bảng BorrowReturnDetail
INSERT INTO BorrowReturnDetail (note, fineAmount, borrowID, returnID) VALUES
('Late return', 25, 1, 1),
('Late return', 16, 2, 2),
('Returned on time', 0, 3, 3),
('Late return', 26, 4, 4),
('Late return', 46, 5, 5);
