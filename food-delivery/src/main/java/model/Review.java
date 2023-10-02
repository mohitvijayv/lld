package model;

public class Review {
    double rating;
    String review;

    public Review(double rating) {
        this.rating = rating;
    }

    public Review(double rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}
