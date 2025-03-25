package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Book;
import Models.Reader;
import Models.Staff;
import Models.BorrowRecord;

public class DBContext {

    public Connection connect;

    public DBContext() {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                    + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final String serverName = "localhost";
    private final String dbName = "LibraryDataBase";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";

    public ArrayList<Book> getBooks() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";

        try (PreparedStatement statement = connect.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    public ArrayList<Reader> getReaders() throws SQLException {
        ArrayList<Reader> readers = new ArrayList<>();
        String sql = "SELECT * FROM Reader";

        try (PreparedStatement statement = connect.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }

    public ArrayList<Staff> getStaffs() throws SQLException {
        ArrayList<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM Staff";

        try (PreparedStatement statement = connect.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffs;
    }

    public ArrayList<BorrowRecord> getBorrowRecords() throws SQLException {
        ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
        String sql = "SELECT * FROM BorrowRecord";

        try (PreparedStatement statement = connect.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                BorrowRecord borrowRecord = new BorrowRecord();
                borrowRecord.setBorrowID(rs.getInt("borrowID"));
                borrowRecord.setBorrowDate(rs.getDate("borrowDate"));
                borrowRecord.setAllowedDay(rs.getInt("allowedDay"));
                borrowRecord.setReaderID(rs.getInt("readerID"));
                borrowRecord.setBookID(rs.getInt("bookID"));
                borrowRecord.setStaffID(rs.getInt("staffID"));
                borrowRecords.add(borrowRecord);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrowRecords;
    }
}
