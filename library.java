package sample;

import java.util.*;

public class library {
    private static final Scanner in = new Scanner(System.in);
    private static final Map<String, Book> bookByName = new HashMap<>();
    private static final Map<Integer, Author> authorById = new HashMap<>();

    private static int nextAuthorId = 0;

    public static void main(String[] args) {

        for (; ; ) {
            printMenu();
            int n = in.nextInt();
            if (n == 0) {
                System.out.println("Завершаю программу");
                break;
            } else if (n == 1) {
                bookProcessing();
            } else if (n == 2) {
                authorProcessing();
            } else {
                System.out.println("Не верное значение попробуйте еще");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Введите 1 если будете работать над книгами\n" +
                "Введите 2 если будете работать над авторами\n" +
                "Введите 0 для завершения работы");
    }

    private static void authorProcessing() {
        System.out.println("Введите 1 для добавления автора\n" +
                "Введите 2 для удаления автора\n" +
                "Введите 3 для обновления автора\n" +
                "Введите 4 для получения списка всех авторов\n" +
                "Введите 5 для получения полной информации об авторе");

        int n = in.nextInt();
        if (n == 1) {
            addAuthor();
        } else if (n == 2) {
            removeAuthor();
        } else if (n == 3) {
            updateAuthor();
        } else if (n == 4) {
            listOfALlAuthors();
        } else if (n == 5) {
            printInformationAboutAuthor();
        } else {
            System.out.println("Не верное значение возврат в главное меню");
        }
    }

    private static void addAuthor() {
        System.out.println("Введите имя автора");
        String authorName = readLine();
        System.out.println("Введите фамилию автора");
        String authorSurname = readLine();

        Author author = new Author(nextAuthorId, authorName, authorSurname);
        authorById.put(nextAuthorId, author);

        nextAuthorId++;
        System.out.println("Автор был добавлен");
    }

    private static void removeAuthor() {
        System.out.println("Введите id автора");
        int authorId = in.nextInt();
        if (!authorById.containsKey(authorId)) {
            System.out.println("Такого автора нет");
            return;
        }
        authorById.remove(authorId);
        System.out.println("Автор был удален");
    }

    private static void updateAuthor() {
        System.out.println("Введите id автора");
        int authorId = in.nextInt();
        if (!authorById.containsKey(authorId)) {
            System.out.println("Такого автора нет");
            return;
        }
        System.out.println("Введите имя автора");
        String authorName = readLine();
        System.out.println("Введите фамилию автора");
        String authorSurname = readLine();
        Author author = authorById.get(authorId);
        author.setName(authorName);
        author.setSurname(authorSurname);
    }

    private static void listOfALlAuthors() {
        System.out.println("Список всех авторов");
        for (Author value : authorById.values()) {
            System.out.println(value.toString());
        }
    }

    private static void printInformationAboutAuthor() {
        System.out.println("Введите id автора");
        int authorId = in.nextInt();
        if (!authorById.containsKey(authorId)) {
            System.out.println("Такого автора нет");
            return;
        }
        Author author = authorById.get(authorId);
        System.out.println(author.toString());
        System.out.println("Список книг");
        for (Book book : author.getBooks()) {
            System.out.println(book.toString());
        }

    }

    private static void bookProcessing() {
        System.out.println("Введите 1 для добавления книги\n" +
                "Введите 2 для удаления книги\n" +
                "Введите 3 для обновления книги\n" +
                "Введите 4 для получения списка всех книг\n" +
                "Введите 5 дляя получения полной информации о книгею");

        int n = in.nextInt();
        if (n == 1) {
            addBook();
        } else if (n == 2) {
            removeBook();
        } else if (n == 3) {
            updateBook();
        } else if (n == 4) {
            listOfAllBooks();
        } else if (n == 5) {
            printInformationAboutBook();
        } else {
            System.out.println("Не верное значение возврат в главное меню");
        }
    }

    private static void printInformationAboutBook() {
        System.out.println("Введите название книги");
        String bookName = readLine();
        if (!bookByName.containsKey(bookName)) {
            System.out.println("Книга с таким названием существует");
            return;
        }
        Book book = bookByName.get(bookName);
        System.out.println("Имя " + book.getName());
        System.out.println("Список авторов");
        for (Author author : book.getAuthors()) {
            System.out.println(author.toString());
        }
    }

    private static void listOfAllBooks() {
        System.out.println("В библиотеке содержаться такие книги");
        for (Map.Entry<String, Book> stringBookEntry : bookByName.entrySet()) {
            System.out.println("Название " + stringBookEntry.getKey() + " Информация " + stringBookEntry.getValue().toString());
        }

    }

    private static void updateBook() {
        System.out.println("Введите название книги");
        String bookName = readLine();
        if (!bookByName.containsKey(bookName)) {
            System.out.println("Книга с таким названием существует");
            return;
        }
        System.out.println("Введите список новых авторов книги");
        String authorId = readLine();
        List<Author> authors = new ArrayList<>();
        for (String id : authorId.split(",")) {
            Integer intId = Integer.parseInt(id);
            if (!authorById.containsKey(intId)) {
                System.out.println("Автора с айди " + id + " не существует");
                return;
            }
            authors.add(authorById.get(intId));

        }
        Book book = bookByName.get(bookName);
        for (Author author : book.getAuthors()) {
            author.removeBook(book);
        }
        book.setAuthors(authors);
        for (Author author : authors) {
            author.addBook(book);
        }
        bookByName.put(bookName, book);
        System.out.println("Книга была обнавлена");
    }

    private static void removeBook() {
        System.out.println("Введите название книги");
        String bookName = readLine();
        if (!bookByName.containsKey(bookName)) {
            System.out.println("Книга с таким названием существует");
            return;
        }
        Book book = bookByName.remove(bookName);
        for (Author author : book.getAuthors()) {
            author.removeBook(book);
        }
        System.out.println("Книга была удалена");
    }

    private static void addBook() {
        System.out.println("Введите название книги ");
        String bookName = readLine();
        if (bookByName.containsKey(bookName)) {
            System.out.println("Книга с таким названием существует");
            return;
        }
        System.out.println("Введите id автора через запятую");
        String authorId = readLine();
        List<Author> authors = new ArrayList<>();
        Book book = new Book(bookName, authors);
        for (String id : authorId.split(",")) {
            Integer intId = Integer.parseInt(id);
            if (!authorById.containsKey(intId)) {
                System.out.println("Автора с айди " + id + " не существует");
                return;
            }
            authors.add(authorById.get(intId));
            authorById.get(intId).addBook(book);
        }
        bookByName.put(bookName,book);
        System.out.println("Книга была добавлена");
    }

    private static String readLine() {
        String line = "";
        while (line.length() == 0) {
            line = in.nextLine();
        }
        return line;
    }
}


class Book {
    private String Name;
    private List<Author> authors;

    public Book(String name, List<Author> authors) {
        Name = name;
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getName() {
        return Name;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Name='" + Name + '\'' +
                ", authors=" + authors +
                '}';
    }
}

class Author {
    private int Id;
    private String Name;
    private String Surname;
    private List<Book> books;

    public Author(int Id, String name, String surname) {
        this.Id = Id;
        Name = name;
        Surname = surname;
        this.books = new ArrayList<>();
    }

    public String getSurname() {
        return Surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}