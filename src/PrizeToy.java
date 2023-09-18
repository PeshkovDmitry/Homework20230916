public class PrizeToy implements Toy {

    private Integer id;

    private String title;

    private Integer weight;

    public PrizeToy(String text) {
        String[] data = text.split(" ");
        id = Integer.parseInt(data[0]);
        title = data[1];
        weight = Integer.parseInt(data[2]);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
