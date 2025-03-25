package DAL;

import Models.Book;
import Models.Reader;
import Models.Staff;
import Models.BorrowRecord;
import Models.BorrowReturnDetail;
import Models.ReturnRecord;
import Models.Login;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DAO {

    private Connection con;

    public static DAO INSTANCE = new DAO();

    private DAO() {
        con = new DBContext().connect;
    }

    public Login getLoginByUsernameAndPassword(String username, String password) {
        Login login = null;
        String sql = "SELECT * FROM Login WHERE username = ? AND password = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    login = new Login();
                    login.setLoginID(rs.getInt("loginID"));
                    login.setUsername(rs.getString("username"));
                    login.setPassword(rs.getString("password"));
                    login.setRoleID(rs.getInt("roleID"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching login by username and password: " + e.getMessage());
        }
        return login;
    }

    public Login getLoginByUsername(String username) {
        Login login = null;
        String sql = "SELECT * FROM Login WHERE username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    login = new Login();
                    login.setLoginID(rs.getInt("loginID"));
                    login.setUsername(rs.getString("username"));
                    login.setPassword(rs.getString("password"));
                    login.setRoleID(rs.getInt("roleID"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching login: " + e.getMessage());
        }
        return login;
    }

    public Reader getReaderByUsername(String username) {
        Reader reader = null;
        String sql = "SELECT * FROM Reader r INNER JOIN Login l ON r.loginID = l.loginID WHERE l.username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reader = new Reader();
                    reader.setReaderID(rs.getInt("readerID"));
                    reader.setReaderName(rs.getString("readerName"));
                    reader.setReaderGender(rs.getString("readerGender"));
                    reader.setReaderDOB(rs.getDate("readerDOB"));
                    reader.setReaderPhone(rs.getString("readerPhone"));
                    reader.setReaderAddress(rs.getString("readerAddress"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reader;
    }

    public ArrayList<Reader> getReaders() {
        ArrayList<Reader> readers = new ArrayList<>();
        String sql = "SELECT * FROM Reader";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderID(rs.getInt("readerID"));
                reader.setReaderName(rs.getString("readerName"));
                reader.setReaderGender(rs.getString("readerGender"));
                reader.setReaderDOB(rs.getDate("readerDOB"));
                reader.setReaderPhone(rs.getString("readerPhone"));
                reader.setReaderAddress(rs.getString("readerAddress"));
                readers.add(reader);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching readers: " + e.getMessage());
        }
        return readers;
    }

    public ArrayList<Staff> getStaffs() {
        ArrayList<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffID(rs.getInt("staffID"));
                staff.setStaffName(rs.getString("staffName"));
                staff.setStaffGender(rs.getString("staffGender"));
                staff.setStaffDOB(rs.getDate("staffDOB"));
                staff.setStaffPhone(rs.getString("staffPhone"));
                staff.setStaffAddress(rs.getString("staffAddress"));
                staffs.add(staff);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching staffs: " + e.getMessage());
        }
        return staffs;
    }

    public Book getBookByID(int bookID) {
        String sql = "SELECT * FROM Book WHERE bookID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, bookID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setTitle(rs.getString("title"));
                    book.setPublishedYear(rs.getInt("publishedYear"));
                    book.setQuantity(rs.getInt("quantity"));
                    book.setGenre(rs.getString("genre"));
                    book.setPublisherName(rs.getString("publisherName"));
                    book.setAuthorName(rs.getString("authorName"));

                    return book;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reader getReaderByID(int readerID) {
        String sql = "SELECT * FROM Reader WHERE readerID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, readerID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Reader reader = new Reader();
                    reader.setReaderID(rs.getInt("readerID"));
                    reader.setReaderName(rs.getString("readerName"));
                    reader.setReaderGender(rs.getString("readerGender"));
                    reader.setReaderDOB(rs.getDate("readerDOB"));
                    reader.setReaderPhone(rs.getString("readerPhone"));
                    reader.setReaderAddress(rs.getString("readerAddress"));
                    return reader;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Staff getStaffByID(int staffID) {
        String sql = "SELECT * FROM Staff WHERE staffID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, staffID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Staff staff = new Staff();
                    staff.setStaffID(rs.getInt("staffID"));
                    staff.setStaffName(rs.getString("staffName"));
                    staff.setStaffGender(rs.getString("staffGender"));
                    staff.setStaffDOB(rs.getDate("staffDOB"));
                    staff.setStaffPhone(rs.getString("staffPhone"));
                    staff.setStaffAddress(rs.getString("staffAddress"));
                    return staff;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBookByID(int bookID) {
        String sql = "DELETE FROM Book WHERE bookID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, bookID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting book: " + e.getMessage());
        }
    }

    public void deleteStaffByID(int staffID) {
        String sql = "DELETE FROM Staff WHERE staffID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, staffID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting staff: " + e.getMessage());
        }
    }

    public void deleteReaderByID(int readerID) {
        String sql = "DELETE FROM Reader WHERE readerID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, readerID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting reader: " + e.getMessage());
        }
    }

    public ArrayList<BorrowRecord> getBorrowRecords() {
        ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
        String sql = "SELECT * FROM BorrowRecord";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                BorrowRecord br = new BorrowRecord();
                br.setBorrowID(rs.getInt("borrowID"));
                br.setBorrowDate(rs.getDate("borrowDate"));
                br.setAllowedDay(rs.getInt("allowedDay"));
                br.setReaderID(rs.getInt("readerID"));
                br.setBookID(rs.getInt("bookID"));
                br.setStaffID(rs.getInt("staffID"));
                borrowRecords.add(br);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching borrow records: " + e.getMessage());
        }
        return borrowRecords;
    }

    public BorrowReturnDetail getBorrowReturnDetailByBorrowId(int borrowID) {
        String sql = "SELECT * FROM BorrowReturnDetail WHERE borrowID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, borrowID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    BorrowReturnDetail detail = new BorrowReturnDetail();
                    detail.setFineAmount(rs.getInt("fineAmount"));
                    return detail;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ReturnRecord> getReturnRecords() {
        ArrayList<ReturnRecord> returnRecords = new ArrayList<>();
        String sql = "SELECT * FROM ReturnRecord";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ReturnRecord rr = new ReturnRecord();
                rr.setReturnID(rs.getInt("returnID"));
                rr.setReturnDate(rs.getDate("returnDate"));
                returnRecords.add(rr);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching return records: " + e.getMessage());
        }
        return returnRecords;
    }

    public void insertBook(Book book) {
        String sql = "INSERT INTO Book (title, publishedYear, quantity, genre, publisherName, authorName) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getPublishedYear());
            ps.setInt(3, book.getQuantity());
            ps.setString(4, book.getGenre());
            ps.setString(5, book.getPublisherName());
            ps.setString(6, book.getAuthorName());

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Failed to add book");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting book: " + e.getMessage());
        }
    }

    public Staff getStaffByUsername(String username) {
        Staff staff = null;
        String sql = "SELECT * FROM Staff s INNER JOIN Login l ON s.loginID = l.loginID WHERE l.username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    staff = new Staff();
                    staff.setStaffID(rs.getInt("staffID"));
                    staff.setStaffName(rs.getString("staffName"));
                    staff.setStaffGender(rs.getString("staffGender"));
                    staff.setStaffDOB(rs.getDate("staffDOB"));
                    staff.setStaffPhone(rs.getString("staffPhone"));
                    staff.setStaffAddress(rs.getString("staffAddress"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public ArrayList<Map<String, Object>> getBorrowRecordsWithDetailsByReaderID(int readerID) {
        ArrayList<Map<String, Object>> borrowRecordsWithDetails = new ArrayList<>();
        String sql = "SELECT br.borrowID, br.borrowDate, br.allowedDay, b.title, brd.fineAmount "
                + "FROM BorrowRecord br "
                + "INNER JOIN Book b ON br.bookID = b.bookID "
                + "INNER JOIN BorrowReturnDetail brd ON br.borrowID = brd.borrowID "
                + "WHERE br.readerID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, readerID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> recordDetails = new HashMap<>();
                    recordDetails.put("borrowID", rs.getInt("borrowID"));
                    recordDetails.put("borrowDate", rs.getDate("borrowDate"));
                    recordDetails.put("allowedDay", rs.getInt("allowedDay"));
                    recordDetails.put("bookTitle", rs.getString("title"));
                    recordDetails.put("fineAmount", rs.getInt("fineAmount"));

                    borrowRecordsWithDetails.add(recordDetails);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowRecordsWithDetails;
    }

    public void updateBook(Book book) {
        String sql = "UPDATE Book SET title = ?, publishedYear = ?, quantity = ?, genre = ?, publisherName = ?, authorName = ? WHERE bookID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getPublishedYear());
            ps.setInt(3, book.getQuantity());
            ps.setString(4, book.getGenre());
            ps.setString(5, book.getPublisherName());
            ps.setString(6, book.getAuthorName());
            ps.setInt(7, book.getBookID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReader(Reader reader) {
        String sql = "UPDATE Reader SET readerName = ?, readerGender = ?, readerDOB = ?, readerPhone = ?, readerAddress = ? WHERE readerID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, reader.getReaderName());
            ps.setString(2, reader.getReaderGender());
            ps.setDate(3, new java.sql.Date(reader.getReaderDOB().getTime()));
            ps.setString(4, reader.getReaderPhone());
            ps.setString(5, reader.getReaderAddress());
            ps.setInt(6, reader.getReaderID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStaff(Staff staff) {
        String sql = "UPDATE Staff SET staffName = ?, staffGender = ?, staffDOB = ?, staffPhone = ?, staffAddress = ? WHERE staffID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getStaffGender());
            ps.setDate(3, new java.sql.Date(staff.getStaffDOB().getTime()));
            ps.setString(4, staff.getStaffPhone());
            ps.setString(5, staff.getStaffAddress());
            ps.setInt(6, staff.getStaffID());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setTitle(rs.getString("title"));
                book.setPublishedYear(rs.getInt("publishedYear"));
                book.setQuantity(rs.getInt("quantity"));
                book.setGenre(rs.getString("genre"));
                book.setPublisherName(rs.getString("publisherName"));
                book.setAuthorName(rs.getString("authorName"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public void insertReader(Reader reader) {
        String sql = "INSERT INTO Reader (readerName, readerGender, readerDOB, readerPhone, readerAddress) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, reader.getReaderName());
            ps.setString(2, reader.getReaderGender());
            ps.setDate(3, new java.sql.Date(reader.getReaderDOB().getTime()));
            ps.setString(4, reader.getReaderPhone());
            ps.setString(5, reader.getReaderAddress());

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Reader added successfully.");
            } else {
                System.out.println("Failed to add reader");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting reader: " + e.getMessage());
        }
    }

    public void insertStaff(Staff staff) {
        String sql = "INSERT INTO Staff (staffName, staffGender, staffDOB, staffPhone, staffAddress) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getStaffGender());
            ps.setDate(3, new java.sql.Date(staff.getStaffDOB().getTime()));
            ps.setString(4, staff.getStaffPhone());
            ps.setString(5, staff.getStaffAddress());

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Staff added successfully.");
            } else {
                System.out.println("Failed to add staff");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting staff: " + e.getMessage());
        }
    }

    public ArrayList<Book> searchBooksByKeyword(String keyword) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE title LIKE ? OR genre LIKE ? OR publisherName LIKE ? OR authorName LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);
            ps.setString(3, searchKeyword);
            ps.setString(4, searchKeyword);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookID(rs.getInt("bookID"));
                    book.setTitle(rs.getString("title"));
                    book.setPublishedYear(rs.getInt("publishedYear"));
                    book.setQuantity(rs.getInt("quantity"));
                    book.setGenre(rs.getString("genre"));
                    book.setPublisherName(rs.getString("publisherName"));
                    book.setAuthorName(rs.getString("authorName"));

                    books.add(book);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during book search: " + e.getMessage());
        }

        return books;
    }

    public ArrayList<Reader> searchReadersByKeyword(String keyword) {
        ArrayList<Reader> readers = new ArrayList<>();
        String sql = "SELECT * FROM Reader WHERE readerName LIKE ? OR readerPhone LIKE ? OR readerAddress LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);
            ps.setString(3, searchKeyword);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reader reader = new Reader();
                    reader.setReaderID(rs.getInt("readerID"));
                    reader.setReaderName(rs.getString("readerName"));
                    reader.setReaderGender(rs.getString("readerGender"));
                    reader.setReaderDOB(rs.getDate("readerDOB"));
                    reader.setReaderPhone(rs.getString("readerPhone"));
                    reader.setReaderAddress(rs.getString("readerAddress"));
                    readers.add(reader);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during reader search: " + e.getMessage());
        }

        return readers;
    }

    public ArrayList<Staff> searchStaffByKeyword(String keyword) {
        ArrayList<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM Staff WHERE staffName LIKE ? OR staffPhone LIKE ? OR staffAddress LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            String searchKeyword = "%" + keyword + "%";
            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);
            ps.setString(3, searchKeyword);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Staff staff = new Staff();
                    staff.setStaffID(rs.getInt("staffID"));
                    staff.setStaffName(rs.getString("staffName"));
                    staff.setStaffGender(rs.getString("staffGender"));
                    staff.setStaffDOB(rs.getDate("staffDOB"));
                    staff.setStaffPhone(rs.getString("staffPhone"));
                    staff.setStaffAddress(rs.getString("staffAddress"));
                    staffs.add(staff);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during staff search: " + e.getMessage());
        }

        return staffs;
    }

    public static void main(String[] args) {

        Book newBook = new Book(0, "New Book", 2024, 10, "Science Fiction", "XYZ Publishers", "John Smith", 1, 1);

        newBook.setTitle("Updated Book");
        DAO.INSTANCE.updateBook(newBook);

    }

}
