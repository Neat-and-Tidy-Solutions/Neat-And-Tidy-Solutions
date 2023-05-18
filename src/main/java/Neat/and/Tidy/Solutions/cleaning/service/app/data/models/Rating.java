package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

public enum Rating {
    BAD(1),
    SATISFACTORY(2),
    GOOD(3),
    EXCELLENT(4);
    private int rating;

    public int getRating(){
        return rating;
    }
    Rating(int rating){
        this.rating=rating;
    }
}
