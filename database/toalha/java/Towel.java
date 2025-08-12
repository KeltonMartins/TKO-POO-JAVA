public class Towel{
    private String color;
    private String size;
    private int wetness;

    public Towel (String color, String size){
        this.color = color;
        this.size = size;
        this.wetness = 0;
    }

    public void dry(int amount){
        this.wetness += amount;
        if (this.wetness > getMaxWetness()){
            System.out.println("toalha encharcada");
            this.wetness = getMaxWetness();
        }
    }

    public void wringOut(){
        this.wetness = 0;
    }

    public int getMaxWetness(){
        switch (this.size){
            case "P":
                return 10;
            case "M":
                return 20;
            case "G":
                return 30;
            }
            return 0;
    }

    public boolean isDry(){
        return this.wetness == 0;
    }

    @Override
    public String toString(){
        return "cor: " + this.color + ", tamanho: " + this.size + ", nivel de molhado: " + this.wetness;
    }

    public void show(){
        System.out.println(this);
    }
}