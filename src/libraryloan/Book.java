package libraryloan;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class Book {

    private long uniqueID;
    private String name;
    private List<String> authors;
    private int publishedYear;
    private boolean available;

    public String getAuthors() {
        String result = "";
        for(String author: authors)
            result += author + "_";
        return result.substring(0,result.length()-1);
    }
    
    public void setAuthors(String authors){
        this.authors = Arrays.asList(authors.split("_"));
    }
    
    public long getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" + "uniqueID=" + uniqueID + ", name=" + name + ", authors=" + authors + ", publishedYear=" + publishedYear + ", available=" + available + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.uniqueID ^ (this.uniqueID >>> 32));
        hash = 59 * hash + Objects.hashCode(this.authors);
        hash = 59 * hash + this.publishedYear;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.uniqueID != other.uniqueID) {
            return false;
        }
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        return true;
    }
}
