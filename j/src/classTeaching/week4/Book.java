package classTeaching.week4;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int copiesSold;

    public Book() {

    }

    public Book(String title, String author, String publisher, int copiesSold) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    @Override
    public String toString() {
        return "书名:" + title + ", 作者:" + author + ", 出版商:" + publisher + ", 售出:" + copiesSold;
    }
}
